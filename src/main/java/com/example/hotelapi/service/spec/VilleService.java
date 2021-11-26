package com.example.hotelapi.service.spec;

import com.example.hotelapi.models.dto.VilleDTO;
import com.example.hotelapi.models.form.VilleDataForm;
import com.example.hotelapi.models.form.VilleForm;

public interface VilleService {

    VilleDTO insert(VilleForm form);
    VilleDTO insert(VilleDataForm form);
    VilleDTO getOne(long id);

}
