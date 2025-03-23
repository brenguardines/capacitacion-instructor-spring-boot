package com.example.springboot.models.entities;

import com.example.springboot.models.entities.users.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "mascota")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "nombre", length = 50, nullable = false)
  private String nombre;

  @Enumerated(EnumType.STRING)
  private Animal animal;

  @Column(name = "anios")
  private Integer anios;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario; //Lo agrego para tener Auditoria (quien dio de alta a la mascota)

  @Embedded
  private Timestamp timestamp; //Lo agrego para tener Trazabilidad
}
