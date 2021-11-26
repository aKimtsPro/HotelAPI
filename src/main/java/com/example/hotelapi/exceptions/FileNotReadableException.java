package com.example.hotelapi.exceptions;

public class FileNotReadableException extends RuntimeException{

    public FileNotReadableException() {
        super("Le fichier n'est pas lisible");
    }
}
