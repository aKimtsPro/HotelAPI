package com.example.hotelapi.repository;

import com.example.hotelapi.models.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
