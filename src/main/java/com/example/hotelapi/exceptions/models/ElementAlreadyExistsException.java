package com.example.hotelapi.exceptions.models;

import com.example.hotelapi.exceptions.annotation.AdviserHandled;
import com.example.hotelapi.exceptions.annotation.SkippedProperty;

@AdviserHandled
public class ElementAlreadyExistsException extends RuntimeException{

    @SkippedProperty
    private final String ok = "ok";

    public ElementAlreadyExistsException() {
        super("L'élément à insérer existe déjà.");
    }

    public String getOk() {
        return ok;
    }
}
