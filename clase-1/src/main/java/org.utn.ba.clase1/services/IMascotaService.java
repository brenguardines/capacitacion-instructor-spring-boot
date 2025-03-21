package org.utn.ba.clase1.services;

import org.utn.ba.clase1.dtos.input.MascotaIntputDTO;
import org.utn.ba.clase1.dtos.output.MascotaOutputDTO;

import java.util.List;

public interface IMascotaService {
  List<MascotaOutputDTO> obtenerTodas();
  MascotaOutputDTO obtenerPorId(Long id);
  Long crearMascota(MascotaIntputDTO mascota);
  void eliminarMascota(Long id);
  MascotaOutputDTO modificarMascota(MascotaIntputDTO mascota, Long id);
}



