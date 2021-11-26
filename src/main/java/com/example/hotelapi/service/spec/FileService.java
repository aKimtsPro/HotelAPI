package com.example.hotelapi.service.spec;

public interface FileService {

    byte[] compress(byte[] input);
    byte[] decompress(byte[] input);

}
