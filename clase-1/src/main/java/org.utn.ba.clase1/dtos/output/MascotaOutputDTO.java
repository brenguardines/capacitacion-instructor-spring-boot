package org.utn.ba.clase1.dtos.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MascotaOutputDTO {
  private Long id;
  private String nombre;
  private String raza;
}
