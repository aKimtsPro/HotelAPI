package com.example.hotelapi.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "chambre")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Chambre {

    @Id
    @Column(name = "numeroChambre")
    private int numeroChambre;
    @Column(nullable = false)
    private int nbrPlaces;
    @Column(nullable = false)
    @Enumerated( EnumType.STRING )
    private TypeChambre type;
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double prix;

    @OneToMany(mappedBy = "reserve")
    private Set<Reservation> reservations;

    @ManyToMany
    private Set<Consommation> consommations;
}
