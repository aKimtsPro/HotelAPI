package com.example.hotelapi.service.impl;

import com.example.hotelapi.exceptions.models.ElementNotFoundException;
import com.example.hotelapi.exceptions.models.InvalidDatesException;
import com.example.hotelapi.exceptions.models.NoRoomAvailableException;
import com.example.hotelapi.mapper.ReservationMapper;
import com.example.hotelapi.models.dto.ReservationDTO;
import com.example.hotelapi.models.entity.Chambre;
import com.example.hotelapi.models.entity.Client;
import com.example.hotelapi.models.entity.Reservation;
import com.example.hotelapi.models.form.ReservationForm;
import com.example.hotelapi.models.form.ReservationRequestForm;
import com.example.hotelapi.repository.ChambreRepository;
import com.example.hotelapi.repository.ClientRepository;
import com.example.hotelapi.repository.ReservationRepository;
import com.example.hotelapi.service.AbstractBaseService;
import com.example.hotelapi.service.spec.ReservationService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl extends AbstractBaseService<ReservationDTO, ReservationForm, ReservationForm, Reservation, Long> implements ReservationService {

    private final ChambreRepository chambreRepository;
    private final ClientRepository clientRepository;

    public ReservationServiceImpl(ReservationRepository repository, ReservationMapper mapper, ChambreRepository chambreRepository, ClientRepository clientRepository, ReservationRepository repository1) {
        super(repository, mapper);
        this.chambreRepository = chambreRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public ReservationDTO insert(ReservationForm form) {

        Reservation toInsert = mapper.formToEntity( form );

        toInsert.setReserve( chambreRepository.findById(form.getRoomId())
                .orElseThrow(ElementNotFoundException::new) );
        toInsert.setReservePar( clientRepository.findById(form.getReservedById())
                .orElseThrow(ElementNotFoundException::new));

        toInsert = repository.save(toInsert);

        return mapper.toDto(toInsert);

    }

    @Override
    public ReservationDTO update(Long id, ReservationForm form) {
        throw new NotYetImplementedException();
    }

    @Override
    public ReservationDTO askForReserv(String username, ReservationRequestForm form){

        if( !form.getCheckin().isBefore( form.getCheckout() ))
            throw new InvalidDatesException(form.getCheckin(), form.getCheckout());

        // Récupération d'une chambre disponible
        List<Chambre> chambres = chambreRepository.getChambreByType( form.getChambre() );
        Chambre toReserve = chambres.stream()
                .filter( c -> c.getNbrPlaces() == form.getNbrPers() )
                .filter( c -> checkAvailable(c, form.checkin, form.checkout))
                .findFirst()
                .orElseThrow( () -> new NoRoomAvailableException(form) );

        // Récupération du client
        Client reserver = clientRepository.findByUsername( username )
                .orElseThrow( ElementNotFoundException::new );

        // Création de la réservation
        Reservation reservation = new Reservation();
        reservation.setReserve(toReserve);
        reservation.setReservePar(reserver);
        reservation.setCheckin(form.getCheckin());
        reservation.setCheckout(form.getCheckout());
        reservation.setBreakfastIncluded(form.isBreakfastIncluded());

        reservation = repository.save( reservation );

        return mapper.toDto(reservation);
    }

    private boolean checkAvailable(Chambre chambre, LocalDate start, LocalDate end){

        List<Reservation> reservations = ((ReservationRepository)repository).findAllByReserveAndCheckinIsAfter(chambre, LocalDate.now());

        return reservations
                .stream()
                .allMatch( res -> end.isBefore( res.getCheckin() ) || start.isAfter( res.getCheckout() ));

    }
}
