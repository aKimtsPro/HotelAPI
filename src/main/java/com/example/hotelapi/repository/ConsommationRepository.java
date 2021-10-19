package com.example.hotelapi.repository;

import com.example.hotelapi.models.entity.Consommation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsommationRepository extends JpaRepository<Consommation, Long> {
}
