package com.example.hotelapi.service.impl;

import com.example.hotelapi.exceptions.models.ElementNotFoundException;
import com.example.hotelapi.mapper.ClientMapper;
import com.example.hotelapi.models.dto.ClientDTO;
import com.example.hotelapi.models.entity.Client;
import com.example.hotelapi.models.form.ClientForm;
import com.example.hotelapi.repository.ClientRepository;
import com.example.hotelapi.service.AbstractBaseService;
import com.example.hotelapi.service.spec.ClientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl extends AbstractBaseService<ClientDTO, ClientForm, ClientForm, Client, Long> implements ClientService {

    private final PasswordEncoder encoder;

    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper, PasswordEncoder encoder) {
        super(repository, mapper);
        this.encoder = encoder;
    }

    @Override
    public ClientDTO insert(ClientForm form) {

        Client toInsert = mapper.formToEntity(form);

        toInsert.setPassword( encoder.encode(toInsert.getPassword()) );
        toInsert.setAccountNonExpired(true);
        toInsert.setAccountNonLocked(true);
        toInsert.setCredentialsNonExpired(true);
        toInsert.setEnabled(true);
        toInsert.setRoles( List.of("CLIENT") );

        toInsert = repository.save(toInsert);

        return mapper.toDto(toInsert);
    }

    @Override
    public ClientDTO update(Long id, ClientForm form) {

        Client client = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        client.setPassword( encoder.encode(form.getPassword()) );
        client.setPrenom( form.getPrenom() );
        client.setNom( form.getNom() );
        client.setTel( form.getTel() );
        client.setMoyenPayement( form.getMoyenPayement() );

        client = repository.save( client );

        return mapper.toDto( client );
    }
}
