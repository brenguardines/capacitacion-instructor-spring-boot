package org.utn.ba.clase1.services;

import org.utn.ba.clase1.dtos.input.TurnoIntputDTO;
import org.utn.ba.clase1.dtos.output.TurnoOutputDTO;

import java.util.List;

public interface ITurnosService {
  List<TurnoOutputDTO> obtenerTodos();
  TurnoOutputDTO obtenerPorId(Long id);
  Long crearTurno(TurnoIntputDTO turno);
  void eliminarTurno(Long id);
  TurnoOutputDTO modificarTurno(TurnoIntputDTO turno, Long id);
}
