package com.example.springboot.services.imp;

import com.example.springboot.dtos.input.MascotaInputDTO;
import com.example.springboot.models.entities.Animal;
import com.example.springboot.models.entities.Mascota;
import com.example.springboot.models.repositories.MascotaRepository;
import com.example.springboot.models.repositories.UsuarioRepository;
import com.example.springboot.services.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MascotaService implements IMascotaService {
  @Autowired
  private MascotaRepository mascotaRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;
  @Override
  public UUID crear(MascotaInputDTO mascotaInputDTO, UserDetails userDetails) {
    var usuario = this.usuarioRepository.findByNombreDeUsuario(userDetails.getUsername());

    var nuevaMascota = Mascota.builder()
        .nombre(mascotaInputDTO.getNombre())
        .animal(Animal.valueOf(mascotaInputDTO.getAnimal()))
        .anios(mascotaInputDTO.getAnios())
        .usuario(usuario.get())
        .build();

    return this.mascotaRepository.save(nuevaMascota).getId();
  }
}
