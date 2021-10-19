package com.example.hotelapi.repository;

import com.example.hotelapi.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
