package com.example.hotelapi.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "DATE default CURRENT_DATE", nullable = false, insertable = false)
    private LocalDate checkin;
    @Column(nullable = false)
    private LocalDate checkout;
    @Column(nullable = false)
    private boolean breakfastIncluded;

    @ManyToOne
    private Client reservePar;
    @ManyToOne
    private Chambre reserve;


}
