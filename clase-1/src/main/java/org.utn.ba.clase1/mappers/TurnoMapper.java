package org.utn.ba.clase1.mappers;

import org.utn.ba.clase1.dtos.output.TurnoOutputDTO;
import org.utn.ba.clase1.models.entities.Turno;

public class TurnoMapper {
  public static TurnoOutputDTO crearTurnoAPartirDe (Turno turno){
    return TurnoOutputDTO
        .builder()
        .id(turno.getId())
        .mascota(MascotaMapper.crearMascotaAPartirDe(turno.getMascota()))
        .build();
  }
}
