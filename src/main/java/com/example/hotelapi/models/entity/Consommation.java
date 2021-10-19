package com.example.hotelapi.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "consommation")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consommation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String marque;
    @Column(nullable = false)
    private double prix;

}
