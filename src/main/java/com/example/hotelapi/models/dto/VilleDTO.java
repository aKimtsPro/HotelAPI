package com.example.hotelapi.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VilleDTO {
    private long id;

    private String nom;

    private String imgType;

    private byte[] imgBytes;
}
