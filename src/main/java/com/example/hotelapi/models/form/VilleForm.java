package com.example.hotelapi.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class VilleForm {
    @NotBlank
    private String nom;

    @NotBlank
    private String imgType;

    @NotNull
    private byte[] imgBytes;
}
