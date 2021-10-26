package com.example.hotelapi.service.spec;

import com.example.hotelapi.models.dto.ReservationDTO;
import com.example.hotelapi.models.entity.Reservation;
import com.example.hotelapi.models.form.ReservationForm;
import com.example.hotelapi.models.form.ReservationRequestForm;
import com.example.hotelapi.service.BaseService;

public interface ReservationService extends BaseService<ReservationDTO, ReservationForm, ReservationForm, Long> {
    ReservationDTO askForReserv(String username, ReservationRequestForm form);
}
