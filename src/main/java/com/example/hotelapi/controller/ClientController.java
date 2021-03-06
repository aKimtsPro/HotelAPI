package com.example.hotelapi.controller;

import com.example.hotelapi.models.dto.ClientDTO;
import com.example.hotelapi.models.dto.RedirectionDTO;
import com.example.hotelapi.models.form.ClientForm;
import com.example.hotelapi.service.BaseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController extends AbstractCrudController<ClientDTO, ClientForm, ClientForm, Long>  {
    public ClientController(BaseService<ClientDTO, ClientForm, ClientForm, Long> service) {
        super(service);
    }

    @GetMapping("/test")
    public ResponseEntity<RedirectionDTO> test(Authentication auth){
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .body( new RedirectionDTO("http://localhost:8080/login") );
    }

}
