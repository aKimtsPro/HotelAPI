package com.example.hotelapi.mapper;

import com.example.hotelapi.models.dto.ChambreDTO;
import com.example.hotelapi.models.entity.Chambre;
import com.example.hotelapi.models.form.ChambreForm;
import org.springframework.stereotype.Service;

@Service
public class ChambreMapper implements BaseMapper<ChambreDTO, ChambreForm, Chambre>{
    @Override
    public ChambreDTO toDto( Chambre entity ) {
        if( entity == null )
            return null;

        return ChambreDTO.builder()
                .numeroChambre( entity.getNumeroChambre() )
                .nbrPlaces( entity.getNbrPlaces() )
                .prix( entity.getPrix() )
                .type( entity.getType() )
                .build();
    }

    @Override
    public Chambre formToEntity(ChambreForm form) {

        if( form == null )
            return null;

        Chambre entity = new Chambre();
        entity.setNumeroChambre(form.getNumeroChambre());
        entity.setPrix(form.getPrix());
        entity.setType(form.getType());
        entity.setNbrPlaces(form.getNbrPlaces());
        return entity;

    }
}
