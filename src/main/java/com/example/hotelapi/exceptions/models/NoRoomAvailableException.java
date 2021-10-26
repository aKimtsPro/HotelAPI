package com.example.hotelapi.exceptions.models;

import com.example.hotelapi.exceptions.annotation.AdviserHandled;
import com.example.hotelapi.models.entity.TypeChambre;
import com.example.hotelapi.models.form.ReservationRequestForm;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Getter
@AdviserHandled(HttpStatus.UNPROCESSABLE_ENTITY)
public class NoRoomAvailableException extends RuntimeException {

    private final TypeChambre type;
    private final LocalDate checkin;
    private final LocalDate checkout;

    public NoRoomAvailableException(ReservationRequestForm requestForm) {
        super("Il n'y a pas de chambre du type voulu disponible");
        type = requestForm.getChambre();
        checkin = requestForm.getCheckin();
        checkout = requestForm.getCheckout();
    }

}
