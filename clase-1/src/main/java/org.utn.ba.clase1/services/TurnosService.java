package org.utn.ba.clase1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utn.ba.clase1.dtos.input.TurnoIntputDTO;
import org.utn.ba.clase1.dtos.output.TurnoOutputDTO;
import org.utn.ba.clase1.exceptions.MascotaNotFoundException;
import org.utn.ba.clase1.exceptions.TurnoNotFoundException;
import org.utn.ba.clase1.mappers.TurnoMapper;
import org.utn.ba.clase1.models.entities.Mascota;
import org.utn.ba.clase1.models.entities.Turno;
import org.utn.ba.clase1.models.repositories.MascotaRepository;
import org.utn.ba.clase1.models.repositories.TurnoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TurnosService implements ITurnosService{

  @Autowired
  private TurnoRepository turnoRepository;
  @Autowired
  private MascotaRepository mascotaRepository;
  @Override
  public List<TurnoOutputDTO> obtenerTodos() {
    return this.turnoRepository.findAll().stream().map(TurnoMapper::crearTurnoAPartirDe).toList();
  }

  @Override
  public TurnoOutputDTO obtenerPorId(Long id) {
    Optional<Turno> turno = this.turnoRepository.findById(id);

    if(turno.isPresent()){
      return TurnoMapper.crearTurnoAPartirDe(turno.get());
    } else{
      throw new TurnoNotFoundException("Turno no encontrado");
    }

  }

  @Override
  public Long crearTurno(TurnoIntputDTO turno) {
    Mascota mascota = mascotaRepository.findById(turno.getMascotaId())
        .orElseThrow(() -> new MascotaNotFoundException("Mascota no encontrada"));

    Turno nuevoTurno = new Turno();
    nuevoTurno.setMascota(mascota);

    this.turnoRepository.save(nuevoTurno);

    return nuevoTurno.getId();
  }

  @Override
  public void eliminarTurno(Long id) {
    turnoRepository.deleteById(id);
  }

  @Override
  public TurnoOutputDTO modificarTurno(TurnoIntputDTO turno, Long id) {
    Turno turnoExistente = turnoRepository.findById(id)
        .orElseThrow(() -> new MascotaNotFoundException("Mascota no encontrada"));

    turnoExistente.setMascota(mascotaRepository.findById(turno.getMascotaId())
        .orElseThrow(() -> new MascotaNotFoundException("Mascota no encontrada")));

    Turno turnoActualizado = turnoRepository.save(turnoExistente);

    return TurnoMapper.crearTurnoAPartirDe(turnoActualizado);
  }
}
