package com.example.springboot.controllers;

import com.example.springboot.dtos.input.MascotaInputDTO;
import com.example.springboot.services.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {
  @Autowired
  private IMascotaService mascotaService;

  @PostMapping
  public ResponseEntity<?> crear(@AuthenticationPrincipal UserDetails userDetails, @RequestBody MascotaInputDTO mascotaInputDTO){
    return ResponseEntity.status(201).body(this.mascotaService.crear(mascotaInputDTO, userDetails));
  }
}
