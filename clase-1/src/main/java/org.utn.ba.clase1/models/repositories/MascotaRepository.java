package org.utn.ba.clase1.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utn.ba.clase1.models.entities.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
