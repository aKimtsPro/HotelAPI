package com.example.hotelapi.repository;

import com.example.hotelapi.models.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
}
