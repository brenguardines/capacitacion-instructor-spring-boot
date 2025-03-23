package com.example.springboot.dtos.input;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioInputDTO {
  private String nombreDeUsuario;
  private String contrasenia;
  private String nombre;
  private String apellido;
  private List<String> roles;
}
