package com.example.hotelapi.controller;

import com.example.hotelapi.models.dto.ReservationDTO;
import com.example.hotelapi.models.form.ReservationForm;
import com.example.hotelapi.models.form.ReservationRequestForm;
import com.example.hotelapi.service.BaseService;
import com.example.hotelapi.service.spec.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/reserv")
public class ReservationController extends AbstractCrudController<ReservationDTO, ReservationForm, ReservationForm, Long> {
    public ReservationController(ReservationService service) {
        super(service);
    }

    @PostMapping("/request")
    public ResponseEntity<ReservationDTO> askForReserv(Authentication auth, @Valid @RequestBody ReservationRequestForm form){
        return ResponseEntity.ok( ((ReservationService)service).askForReserv( (String)auth.getPrincipal(), form ));
    }
}
