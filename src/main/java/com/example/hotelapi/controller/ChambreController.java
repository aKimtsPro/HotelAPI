package com.example.hotelapi.controller;

import com.example.hotelapi.models.dto.ChambreDTO;
import com.example.hotelapi.models.form.ChambreForm;
import com.example.hotelapi.models.form.ChambreUpdateForm;
import com.example.hotelapi.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class ChambreController extends AbstractCrudController<ChambreDTO, ChambreForm, ChambreUpdateForm, Integer> {
    protected ChambreController(BaseService<ChambreDTO, ChambreForm, ChambreUpdateForm, Integer> service) {
        super(service);
    }

    // get all: GET /room
    // insert: POST /room (ChambreForm valide en body)
}
