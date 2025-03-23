package com.example.springboot.services.imp;

import com.example.springboot.dtos.input.UsuarioInputDTO;
import com.example.springboot.models.entities.users.Rol;
import com.example.springboot.models.entities.users.Usuario;
import com.example.springboot.models.repositories.UsuarioRepository;
import com.example.springboot.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UsuariosService implements IUsuarioService {
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public Long registrarUsuario(UsuarioInputDTO usuarioInputDTO) {
    Usuario nuevoUsuario = Usuario.builder()
        .nombreDeUsuario(usuarioInputDTO.getNombreDeUsuario())
        .nombre(usuarioInputDTO.getNombre())
        .apellido(usuarioInputDTO.getApellido())
        .contrasenia(passwordEncoder.encode(usuarioInputDTO.getContrasenia()))
        .roles(usuarioInputDTO.getRoles().stream().map(Rol::valueOf).collect(Collectors.toSet()))
        .build();

    this.usuarioRepository.save(nuevoUsuario);

    return nuevoUsuario.getId();
  }
}
