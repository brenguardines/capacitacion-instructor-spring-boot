package com.example.springboot.services;

import com.example.springboot.dtos.input.MascotaInputDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface IMascotaService {
  UUID crear(MascotaInputDTO mascotaInputDTO, UserDetails userDetails);
}
