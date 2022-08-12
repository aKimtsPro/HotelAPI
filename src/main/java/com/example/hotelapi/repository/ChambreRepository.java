package com.example.hotelapi.repository;

import com.example.hotelapi.models.entity.Chambre;
import com.example.hotelapi.models.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {

    List<Chambre> findByType(TypeChambre type);

    List<Chambre> findByNbrPlacesGreaterThanEqual(int nbrPlaces);

    @Query("SELECT c FROM Chambre c WHERE c.numeroChambre = :id")
    Optional<Chambre> truc(int id);

}
