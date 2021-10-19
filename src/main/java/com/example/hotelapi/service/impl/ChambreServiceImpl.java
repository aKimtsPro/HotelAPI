package com.example.hotelapi.service.impl;

import com.example.hotelapi.exceptions.models.ElementAlreadyExistsException;
import com.example.hotelapi.exceptions.models.ElementNotFoundException;
import com.example.hotelapi.mapper.ChambreMapper;
import com.example.hotelapi.models.dto.ChambreDTO;
import com.example.hotelapi.models.entity.Chambre;
import com.example.hotelapi.models.form.ChambreForm;
import com.example.hotelapi.models.form.ChambreUpdateForm;
import com.example.hotelapi.repository.ChambreRepository;
import com.example.hotelapi.service.AbstractBaseService;
import com.example.hotelapi.service.spec.ChambreService;
import org.springframework.stereotype.Service;

@Service
public class ChambreServiceImpl extends AbstractBaseService<ChambreDTO, ChambreForm, ChambreUpdateForm, Chambre, Integer> implements ChambreService {

    protected ChambreServiceImpl(ChambreRepository repository, ChambreMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ChambreDTO insert(ChambreForm form) {
        if(repository.existsById(form.getNumeroChambre()))
            throw new ElementAlreadyExistsException();

        return super.insert(form);
    }

    @Override
    public ChambreDTO update(Integer id, ChambreUpdateForm form) {

        Chambre chambre = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        chambre.setNbrPlaces( form.getNbrPlaces() );
        chambre.setType( form.getType() );
        chambre.setPrix( form.getPrix() );

        chambre = repository.save( chambre );

        return mapper.toDto(chambre);

    }


}
