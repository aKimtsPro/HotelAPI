package com.example.hotelapi.mapper;

import com.example.hotelapi.models.dto.ClientDTO;
import com.example.hotelapi.models.entity.Client;
import com.example.hotelapi.models.form.ClientForm;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper implements BaseMapper<ClientDTO, ClientForm, Client> {
    @Override
    public ClientDTO toDto(Client entity) {

        if( entity == null )
            return null;

        return ClientDTO.builder()
                .username(entity.getUsername())
                .prenom(entity.getPrenom())
                .nom(entity.getNom())
                .moyenPayement(entity.getMoyenPayement())
                .tel(entity.getTel())
                .build();
    }

    @Override
    public Client formToEntity(ClientForm form) {
        return form.toEntity();
    }
}
