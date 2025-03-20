package org.utn.ba.clase1.dtos.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TurnoOutputDTO {
  private Long id;
  private String razaPaciente;
  private String nombrePaciente;
}
