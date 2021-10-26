package com.example.hotelapi.exceptions.models;

import com.example.hotelapi.exceptions.annotation.AdviserHandled;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AdviserHandled
public class InvalidDatesException extends RuntimeException{

    private final LocalDate checkin;
    private final LocalDate checkout;

    public InvalidDatesException(LocalDate checkin, LocalDate checkout) {
        super("Les dates données sont invalides, la date de checkout doit être après la date de checkin");
        this.checkin = checkin;
        this.checkout = checkout;
    }
}
