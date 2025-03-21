package org.utn.ba.clase1.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mascota {
  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String nombre;

  @Column
  private String raza;
}
