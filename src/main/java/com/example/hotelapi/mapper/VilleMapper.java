package com.example.hotelapi.mapper;

import com.example.hotelapi.models.dto.VilleDTO;
import com.example.hotelapi.models.entity.Ville;
import com.example.hotelapi.models.form.VilleForm;
import org.springframework.stereotype.Service;

@Service
public class VilleMapper implements BaseMapper<VilleDTO, VilleForm, Ville> {


    @Override
    public VilleDTO toDto(Ville entity) {

        if( entity == null )
            return null;

        return VilleDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .imgType(entity.getImgType())
                .imgBytes(entity.getImgBytes())
                .build();

    }

    @Override
    public Ville formToEntity(VilleForm form) {

        if( form == null )
            return null;

        Ville v = new Ville();
        v.setNom(form.getNom());
        v.setImgType(form.getImgType());
        v.setImgBytes(form.getImgBytes());
        return v;

    }
}
