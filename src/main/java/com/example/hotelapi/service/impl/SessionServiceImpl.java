package com.example.hotelapi.service.impl;

import com.example.hotelapi.models.dto.LoginSuccessDTO;
import com.example.hotelapi.models.entity.User;
import com.example.hotelapi.models.form.LoginForm;
import com.example.hotelapi.repository.UserRepository;
import com.example.hotelapi.security.JwtProvider;
import com.example.hotelapi.service.spec.SessionService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    private final UserRepository repository;
    private final AuthenticationManager manager;
    private final JwtProvider provider;

    public SessionServiceImpl(UserRepository repository, AuthenticationManager manager, JwtProvider provider) {
        this.repository = repository;
        this.manager = manager;
        this.provider = provider;
    }

    @Override
    public LoginSuccessDTO login(LoginForm form) {
        User user = repository.findByUsername(form.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("l'utilisateur n'existe pas"));
        // creer l'authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(),form.getPassword());
        // tester l'authentication
        manager.authenticate( authentication );

        // -> ok : creer token et le renvoyer
        return LoginSuccessDTO.builder()
                .jwt( provider.createToken(user.getUsername(), user.getRoles()) )
                .username( user.getUsername() )
                .build()  ;
    }

}
