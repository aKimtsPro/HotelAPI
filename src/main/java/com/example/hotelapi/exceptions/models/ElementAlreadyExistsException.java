package com.example.hotelapi.exceptions.models;

import com.example.hotelapi.exceptions.annotation.AdviserHandled;
import com.example.hotelapi.exceptions.annotation.SkippedProperty;
import lombok.Getter;

@Getter
@AdviserHandled
public class ElementAlreadyExistsException extends RuntimeException{

    @SkippedProperty
    private final String ignored = "ok";

    public ElementAlreadyExistsException() {
        super("L'élément à insérer existe déjà.");
    }

}
