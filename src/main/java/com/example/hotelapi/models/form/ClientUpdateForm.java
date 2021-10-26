package com.example.hotelapi.models.form;

import com.example.hotelapi.models.entity.Client;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
public class ClientUpdateForm {

    private String password;
    private String nom;
    private String prenom;
    private String tel;
    private List<String> moyenPayement;

    public Client toEntity(){
        Client client = new Client();

        client.setPassword(password);

        client.setNom(nom);
        client.setPrenom(prenom);
        client.setTel(tel);
        client.setMoyenPayement(moyenPayement);

        return client;
    }

}
