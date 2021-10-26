package com.example.hotelapi.mapper;

import com.example.hotelapi.models.dto.ReservationDTO;
import com.example.hotelapi.models.entity.Chambre;
import com.example.hotelapi.models.entity.Client;
import com.example.hotelapi.models.entity.Reservation;
import com.example.hotelapi.models.form.ReservationForm;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper implements BaseMapper<ReservationDTO, ReservationForm, Reservation>{
    @Override
    public ReservationDTO toDto(Reservation entity) {
        if( entity == null )
            return null;

        return ReservationDTO.builder()
                .id( entity.getId() )
                .checkin( entity.getCheckin() )
                .checkout( entity.getCheckout() )
                .breakfastIncluded( entity.isBreakfastIncluded() )
                .chambre( toInnerDTO(entity.getReserve()) )
                .client( toInnerDTO(entity.getReservePar()) )
                .build();
    }

    @Override
    public Reservation formToEntity(ReservationForm form) {

        if( form == null )
            return null;

        Reservation reservation = new Reservation();
        reservation.setCheckin(form.getCheckin());
        reservation.setCheckout(form.getCheckout());
        reservation.setBreakfastIncluded(form.isBreakfastIncluded());

        return reservation;
    }

    private ReservationDTO.ChambreDTO toInnerDTO(Chambre entity){
        if( entity == null )
            return null;

        return ReservationDTO.ChambreDTO.builder()
                .numeroChambre( entity.getNumeroChambre() )
                .nbrPlaces( entity.getNbrPlaces() )
                .prix( entity.getPrix() )
                .type( entity.getType() )
                .build();
    }

    private ReservationDTO.ClientDTO toInnerDTO(Client entity){
        if( entity == null )
            return null;

        return ReservationDTO.ClientDTO.builder()
                .username( entity.getUsername() )
                .nom( entity.getNom() )
                .prenom( entity.getPrenom() )
                .tel( entity.getTel() )
                .moyenPayement( entity.getMoyenPayement() )
                .build();
    }
}
