package com.example.hotelapi.repository;

import com.example.hotelapi.models.entity.Chambre;
import com.example.hotelapi.models.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByReserveAndCheckinIsAfter(Chambre chambre, LocalDate after);
}
