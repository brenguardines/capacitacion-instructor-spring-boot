package com.example.springboot.models.entities.users;

import com.example.springboot.models.entities.Timestamp;
import com.example.springboot.models.entities.users.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "usuario")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre", length = 50, nullable = false)
  private String nombre;

  @Column(name = "apellido", length = 50, nullable = false)
  private String apellido;

  @Column(name = "nombreDeUsuario", length = 50, nullable = false)
  private String nombreDeUsuario;

  @Column(name = "contrasenia", nullable = false)
  private String contrasenia;

  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  @Column(name = "rol")
  private Set<Rol> roles;

  @Embedded
  private Timestamp timestamp; //Lo agrego para tener Trazabilidad

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles
        .stream()
        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.toString()))
        .collect(Collectors.toSet());
  }

  @Override
  public String getPassword() {
    return this.contrasenia;
  }

  @Override
  public String getUsername() {
    return this.nombreDeUsuario;
  }
}
