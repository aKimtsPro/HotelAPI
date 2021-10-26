package com.example.hotelapi.service.spec;

import com.example.hotelapi.models.form.LoginForm;

public interface SessionService {

    String login(LoginForm form);

}
