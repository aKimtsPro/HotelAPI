package com.example.hotelapi.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Validated
public class ReservationForm {

    @Future
    private LocalDate checkin;
    @Future
    private LocalDate checkout;
    private boolean breakfastIncluded;
    @Min(1)
    private long reservedById;
    @Min(1)
    private int roomId;


}
