package com.example.springboot.controllers;

import com.example.springboot.dtos.input.UsuarioInputDTO;
import com.example.springboot.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private IUsuarioService usuarioService;

  @PostMapping
  public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioInputDTO usuarioInputDTO){
    var id = usuarioService.registrarUsuario(usuarioInputDTO);
    return ResponseEntity.ok(id.toString());
  }
}
