package com.example.hotelapi.utils;

import com.example.hotelapi.models.entity.User;
import com.example.hotelapi.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseFiller implements InitializingBean {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public DatabaseFiller(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        User u = new User();
        u.setUsername("admin");
        u.setPassword( encoder.encode("pass")) ;
        u.setRoles(List.of( "ADMIN" ));

        repository.save( u );

    }
}
