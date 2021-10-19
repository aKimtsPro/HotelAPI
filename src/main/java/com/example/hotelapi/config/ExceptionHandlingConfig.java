package com.example.hotelapi.config;

import com.example.hotelapi.exceptions.ControllerAdviserConfiguration;
import com.example.hotelapi.exceptions.ControllerAdviserConfigurer;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ExceptionHandlingConfig extends ControllerAdviserConfigurer {

    public ExceptionHandlingConfig(ControllerAdviserConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void configure() throws Exception{
        configuration.addHandling( NotYetImplementedException.class, HttpStatus.NOT_IMPLEMENTED );
    }
}
