package com.example.hotelapi.models.form;

import com.example.hotelapi.models.entity.TypeChambre;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Validated
public class ReservationRequestForm {

    @NotNull
    public TypeChambre chambre;
    @Future
    public LocalDate checkin;
    @Future
    public LocalDate checkout;
    public boolean breakfastIncluded;

}
