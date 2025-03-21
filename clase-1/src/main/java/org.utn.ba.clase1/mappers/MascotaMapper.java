package org.utn.ba.clase1.mappers;

import org.utn.ba.clase1.dtos.output.MascotaOutputDTO;
import org.utn.ba.clase1.models.entities.Mascota;

public class MascotaMapper {
  public static MascotaOutputDTO crearMascotaAPartirDe (Mascota mascota){
    return MascotaOutputDTO
        .builder()
        .id(mascota.getId())
        .nombre(mascota.getNombre())
        .raza(mascota.getRaza())
        .build();
  }
}
