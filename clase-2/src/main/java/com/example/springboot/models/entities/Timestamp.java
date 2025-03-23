package com.example.springboot.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@Embeddable
@Getter
public class Timestamp { //Esta entidad embebida se va a encargar de mantener la consistencia de estas columnas
  @Column
  private LocalDateTime fechaCreado;
  @Column
  private LocalDateTime fechaActualizado;

  @PrePersist
  protected void onCreated() {
    this.fechaCreado = LocalDateTime.now();
    this.fechaActualizado = LocalDateTime.now();
  }

  @PreUpdate
  protected void unUpdate() {
    this.fechaActualizado = LocalDateTime.now();
  }
}
