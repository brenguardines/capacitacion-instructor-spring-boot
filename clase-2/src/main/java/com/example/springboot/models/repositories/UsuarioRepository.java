package com.example.springboot.models.repositories;

import com.example.springboot.models.entities.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Optional<Usuario> findByNombreDeUsuario(String nombreDeUsuario);

}
