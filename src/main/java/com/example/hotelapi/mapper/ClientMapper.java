package com.example.hotelapi.mapper;

import com.example.hotelapi.models.dto.ClientDTO;
import com.example.hotelapi.models.entity.Client;
import com.example.hotelapi.models.form.ClientForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
public class ClientMapper implements BaseMapper<ClientDTO, ClientForm, Client> {

    private final ReservationMapper reservationMapper;

    public ClientMapper(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ClientDTO toDto(Client entity) {

        if( entity == null )
            return null;

        return ClientDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .prenom(entity.getPrenom())
                .nom(entity.getNom())
                .moyenPayement(entity.getMoyenPayement())
                .tel(entity.getTel())
                .reservations(
                        entity.getReservations()
                                .stream()
                                .map(reservationMapper::toDto)
                                .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public Client formToEntity(ClientForm form) {
        return form.toEntity();
    }
}
