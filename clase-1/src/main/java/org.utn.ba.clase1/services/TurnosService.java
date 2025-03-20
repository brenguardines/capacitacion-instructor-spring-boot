package org.utn.ba.clase1.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utn.ba.clase1.dtos.input.TurnoIntputDTO;
import org.utn.ba.clase1.dtos.output.TurnoOutputDTO;
import org.utn.ba.clase1.exceptions.TurnoNotFoundException;
import org.utn.ba.clase1.mappers.TurnoMapper;
import org.utn.ba.clase1.models.entities.Turno;
import org.utn.ba.clase1.models.repositories.TurnoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TurnosService implements ITurnosService{

  @Autowired
  private TurnoRepository turnoRepository;
  @Override
  public List<TurnoOutputDTO> obtenerTodos() {
    return this.turnoRepository.findAll().stream().map(TurnoMapper::crearAPartirDe).toList();
  }

  @Override
  public TurnoOutputDTO obtenerPorId(Long id) {
    Optional<Turno> turno = this.turnoRepository.findById(id);

    if(turno.isPresent()){
      return TurnoMapper.crearAPartirDe(turno.get());
    } else{
      throw new TurnoNotFoundException("Turno no encontrado");
    }

  }

  @Override
  public Long crearTurno(TurnoIntputDTO turno) {
    Turno nuevoTurno = new ObjectMapper().convertValue(turno, Turno.class);
    this.turnoRepository.save(nuevoTurno);
    return nuevoTurno.getId();
  }

  @Override
  public void eliminarTurno(Long id) {
    turnoRepository.deleteById(id);
  }

  @Override
  public TurnoOutputDTO modificarTurno(TurnoIntputDTO turno, Long id) {
    Turno turnoAModificar = new ObjectMapper().convertValue(turno, Turno.class);

    if(turnoRepository.existsById(id)){
      this.turnoRepository.save(turnoAModificar);
      return TurnoMapper.crearAPartirDe(turnoAModificar);
    }

    return null;
  }
}
