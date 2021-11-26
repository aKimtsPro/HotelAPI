package com.example.hotelapi.service.spec;

import com.example.hotelapi.models.dto.LoginSuccessDTO;
import com.example.hotelapi.models.form.LoginForm;

public interface SessionService {

    LoginSuccessDTO login(LoginForm form);

}
