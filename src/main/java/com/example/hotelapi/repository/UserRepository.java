package com.example.hotelapi.repository;

import com.example.hotelapi.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
