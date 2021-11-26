package com.example.hotelapi.models.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VilleDataForm {

    private String nom;
    private String lien;

}
