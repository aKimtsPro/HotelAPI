package com.example.hotelapi.service.impl;

import com.example.hotelapi.exceptions.models.ElementNotFoundException;
import com.example.hotelapi.mapper.VilleMapper;
import com.example.hotelapi.models.dto.VilleDTO;
import com.example.hotelapi.models.entity.Ville;
import com.example.hotelapi.models.form.VilleDataForm;
import com.example.hotelapi.models.form.VilleForm;
import com.example.hotelapi.repository.VilleRepository;
import com.example.hotelapi.service.spec.FileService;
import com.example.hotelapi.service.spec.VilleService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class VilleServiceImpl implements VilleService {

    private final FileService fileService;
    private final VilleMapper mapper;
    private final VilleRepository repository;

    public VilleServiceImpl(FileService fileService, VilleMapper mapper, VilleRepository repository) {
        this.fileService = fileService;
        this.mapper = mapper;
        this.repository = repository;
    }

    // Enregistre l'image
    @Override
    public VilleDTO insert(@Valid VilleForm form) {

        Ville toInsert = mapper.formToEntity(form);
        toInsert.setImgBytes( fileService.compress(toInsert.getImgBytes()) );
        return mapper.toDto( repository.save(toInsert) );

    }

    // Enregistre le lien de l'image
    @Override
    public VilleDTO insert(VilleDataForm form){

        Ville toInsert = new Ville();
        toInsert.setNom(form.getNom());
        toInsert.setLien(form.getLien());

        return mapper.toDto( repository.save(toInsert) );

    }

    @Override
    public VilleDTO getOne(long id) {

        Ville ville = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        VilleDTO dto = mapper.toDto( ville );
        dto.setImgBytes( fileService.decompress(dto.getImgBytes()) );
        return dto;

    }
}
