package com.example.hotelapi.models.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "DATE default CURRENT_DATE", unique = true, insertable = false)
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    @Column(nullable = false)
    private boolean breakfastIncluded;

    @ManyToOne
    private Client reservePar;
    @ManyToOne
    private Chambre reserve;


}
