package com.example.hotelapi.models.dto;

import com.example.hotelapi.models.entity.TypeChambre;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ReservationDTO {

    private long id;
    private LocalDate checkin;
    private LocalDate checkout;
    private boolean breakfastIncluded;

    private ReservationDTO.ClientDTO client;
    private ReservationDTO.ChambreDTO chambre;

    @Data
    @Builder
    public static class ClientDTO{
        private String username;
        private String nom;
        private String prenom;
        private String tel;
        private List<String> moyenPayement;
    }

    @Data
    @Builder
    public static class ChambreDTO{
        private int numeroChambre;
        private int nbrPlaces;
        private TypeChambre type;
        private double prix;
    }
}
