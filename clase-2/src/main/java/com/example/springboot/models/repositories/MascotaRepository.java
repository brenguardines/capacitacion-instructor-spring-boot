package com.example.springboot.models.repositories;

import com.example.springboot.models.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, UUID> {
}
