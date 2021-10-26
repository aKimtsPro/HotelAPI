package com.example.hotelapi.models.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

@Data
@Builder
public class ClientDTO {

    private long id;
    private String username;
    private String nom;
    private String prenom;
    private String tel;
    private List<String> moyenPayement;

    private List<ReservationDTO> reservations;

}
