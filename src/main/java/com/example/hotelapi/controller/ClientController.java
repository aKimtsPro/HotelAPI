package com.example.hotelapi.controller;

import com.example.hotelapi.models.dto.ClientDTO;
import com.example.hotelapi.models.form.ClientForm;
import com.example.hotelapi.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends AbstractCrudController<ClientDTO, ClientForm, ClientForm, Long>  {
    public ClientController(BaseService<ClientDTO, ClientForm, ClientForm, Long> service) {
        super(service);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(Authentication auth){
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
