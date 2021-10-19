package com.example.hotelapi.models.form;

import com.example.hotelapi.models.entity.Chambre;
import com.example.hotelapi.models.entity.TypeChambre;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Validated
public class ChambreForm {

    @Min(1)
    private int numeroChambre;
    @Min(1) @Max(5)
    private int nbrPlaces;
    private TypeChambre type;
    @Min(0)
    private double prix;

    public Chambre toEntity(){
        Chambre chambre = new Chambre();
        chambre.setNumeroChambre(numeroChambre);
        chambre.setNbrPlaces(nbrPlaces);
        chambre.setType(type);
        chambre.setPrix(prix);
        return chambre;
    }

}
