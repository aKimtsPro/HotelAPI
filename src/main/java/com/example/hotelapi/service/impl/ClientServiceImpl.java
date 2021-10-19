package com.example.hotelapi.service.impl;

import com.example.hotelapi.mapper.ClientMapper;
import com.example.hotelapi.models.dto.ClientDTO;
import com.example.hotelapi.models.entity.Client;
import com.example.hotelapi.models.form.ClientForm;
import com.example.hotelapi.repository.ClientRepository;
import com.example.hotelapi.service.AbstractBaseService;
import com.example.hotelapi.service.spec.ClientService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends AbstractBaseService<ClientDTO, ClientForm, ClientForm, Client, Long> implements ClientService {

    private final PasswordEncoder encoder;

    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper, PasswordEncoder encoder) {
        super(repository, mapper);
        this.encoder = encoder;
    }

    @Override
    public ClientDTO insert(ClientForm form) {
        form.setPassword( encoder.encode(form.getPassword()) );
        return super.insert(form);
    }

    @Override
    public ClientDTO update(Long id, ClientForm form) {
        // TODO : implement
        throw new NotYetImplementedException();
//        return null;
    }
}
