package com.example.hotelapi.controller;

import com.example.hotelapi.models.dto.LoginSuccessDTO;
import com.example.hotelapi.models.form.LoginForm;
import com.example.hotelapi.service.spec.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SessionController {

    private final SessionService service;

    public SessionController(SessionService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginSuccessDTO> login(@Valid @RequestBody LoginForm form){
        return ResponseEntity.ok( service.login(form) );
    }

}
