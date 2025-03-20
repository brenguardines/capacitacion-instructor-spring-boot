package org.utn.ba.clase1.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utn.ba.clase1.models.entities.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
}
