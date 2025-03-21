package org.utn.ba.clase1.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utn.ba.clase1.dtos.input.MascotaIntputDTO;
import org.utn.ba.clase1.dtos.output.MascotaOutputDTO;
import org.utn.ba.clase1.exceptions.MascotaNotFoundException;
import org.utn.ba.clase1.mappers.MascotaMapper;
import org.utn.ba.clase1.models.entities.Mascota;
import org.utn.ba.clase1.models.repositories.MascotaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService{

  @Autowired
  private MascotaRepository mascotaRepository;
  @Override
  public List<MascotaOutputDTO> obtenerTodas() {
    return this.mascotaRepository.findAll().stream().map(MascotaMapper::crearMascotaAPartirDe).toList();
  }

  @Override
  public MascotaOutputDTO obtenerPorId(Long id) {
    Optional<Mascota> mascota = this.mascotaRepository.findById(id);

    if(mascota.isPresent()){
      return MascotaMapper.crearMascotaAPartirDe(mascota.get());
    }else{
      throw new MascotaNotFoundException("Mascota no encontrada");
    }
  }

  @Override
  public Long crearMascota(MascotaIntputDTO mascota) {
    Mascota nuevaMascota = new ObjectMapper().convertValue(mascota, Mascota.class);

    this.mascotaRepository.save(nuevaMascota);

    return nuevaMascota.getId();
  }

  @Override
  public void eliminarMascota(Long id) {
    mascotaRepository.deleteById(id);
  }

  @Override
  public MascotaOutputDTO modificarMascota(MascotaIntputDTO mascota, Long id) {
    Mascota mascotaExistente = mascotaRepository.findById(id)
        .orElseThrow(() -> new MascotaNotFoundException("Mascota no encontrada"));

    mascotaExistente.setNombre(mascota.getNombre());
    mascotaExistente.setRaza(mascota.getRaza());

    Mascota mascotaActualizada = mascotaRepository.save(mascotaExistente);

    return MascotaMapper.crearMascotaAPartirDe(mascotaActualizada);

  }
}
