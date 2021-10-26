package com.example.hotelapi.repository;

import com.example.hotelapi.models.entity.Chambre;
import com.example.hotelapi.models.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {

    List<Chambre> getChambreByType(TypeChambre type);
}
