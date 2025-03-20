package org.utn.ba.clase1.mappers;

import org.utn.ba.clase1.dtos.output.TurnoOutputDTO;
import org.utn.ba.clase1.models.entities.Turno;

public class TurnoMapper {
  public static TurnoOutputDTO crearAPartirDe (Turno turno){
    return TurnoOutputDTO
        .builder()
        .id(turno.getId())
        .nombrePaciente(turno.getNombrePaciente())
        .razaPaciente(turno.getRazaPaciente())
        .build();
  }
}
