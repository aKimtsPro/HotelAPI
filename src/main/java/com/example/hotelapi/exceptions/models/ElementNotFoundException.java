package com.example.hotelapi.exceptions.models;

import com.example.hotelapi.exceptions.annotation.AdviserHandled;
import com.example.hotelapi.exceptions.annotation.SkippedProperty;
import org.springframework.http.HttpStatus;

@AdviserHandled(HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends RuntimeException{


    @SuppressWarnings("FieldCanBeLocal")
    private final String ignored = "ok";

    public ElementNotFoundException() {
        super("L'element recherché n'existe pas");
    }

    @SkippedProperty
    public String getIgnored() {
        return ignored;
    }
}
