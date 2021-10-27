package com.example.hotelapi.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "clientId")
public class Client extends User{

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    private String tel;
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE) // multiple bag fix
    private List<String> moyenPayement;

    @OneToMany(mappedBy = "reservePar", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

}
