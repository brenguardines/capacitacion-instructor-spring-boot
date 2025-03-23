package com.example.springboot.services;

import com.example.springboot.dtos.input.TurnoInputDTO;
import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.models.entities.Turno;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ITurnosService {
    List<TurnoOutputDTO> obtenerTodos();
    TurnoOutputDTO obtenerPorId(Long id);
    Long crearTurno(TurnoInputDTO turno, UserDetails userDetails);
    void eliminarTurno(Long id);
    TurnoOutputDTO modificarTurno(TurnoInputDTO turno, Long id);
}
