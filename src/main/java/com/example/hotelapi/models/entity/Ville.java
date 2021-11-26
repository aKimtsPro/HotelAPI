package com.example.hotelapi.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    private String imgType;

    @Column(columnDefinition = "VARBINARY(100000)", nullable = true)
    private byte[] imgBytes;

    @Column(columnDefinition = "VARCHAR(200000)", nullable = true)
    private String lien;

}
