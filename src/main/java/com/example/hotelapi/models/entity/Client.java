package com.example.hotelapi.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User{

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    private String tel;
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE) // multiple bag fix
    private List<String> moyenPayement;

    @OneToMany(mappedBy = "reservePar")
    private Set<Reservation> reservations;

}
