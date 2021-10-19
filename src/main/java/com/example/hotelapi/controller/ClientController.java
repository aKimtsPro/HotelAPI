package com.example.hotelapi.controller;

import com.example.hotelapi.models.dto.ClientDTO;
import com.example.hotelapi.models.form.ClientForm;
import com.example.hotelapi.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends AbstractCrudController<ClientDTO, ClientForm, ClientForm, Long>  {
    protected ClientController(BaseService<ClientDTO, ClientForm, ClientForm, Long> service) {
        super(service);
    }
}
