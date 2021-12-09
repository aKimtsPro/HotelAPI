package com.example.hotelapi.models.dto.toDelete;

import java.util.List;

public class CatDTO {

    String id;
    String nom;

    CatDTO.SmallCatDTO parent;
    List<CatDTO.SmallCatDTO> enfant;

    static class SmallCatDTO {
        String id;
        String nom;
    }

}
