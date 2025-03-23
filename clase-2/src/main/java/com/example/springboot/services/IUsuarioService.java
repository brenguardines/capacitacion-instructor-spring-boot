package com.example.springboot.services;

import com.example.springboot.dtos.input.UsuarioInputDTO;

public interface IUsuarioService {
  Long registrarUsuario(UsuarioInputDTO usuarioInputDTO);
}
