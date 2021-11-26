package com.example.hotelapi.repository;

import com.example.hotelapi.models.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville, Long> {
}
