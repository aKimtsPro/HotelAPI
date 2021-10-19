package com.example.hotelapi.models.dto;

import com.example.hotelapi.models.entity.TypeChambre;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChambreDTO {

    private int numeroChambre;
    private int nbrPlaces;
    private TypeChambre type;
    private double prix;

}
