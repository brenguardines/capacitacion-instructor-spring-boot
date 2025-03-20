package org.utn.ba.clase1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utn.ba.clase1.dtos.input.TurnoIntputDTO;
import org.utn.ba.clase1.dtos.output.TurnoOutputDTO;
import org.utn.ba.clase1.services.ITurnosService;

import java.util.List;

@RestController
@RequestMapping("/turnos")

public class TurnoController {

  @Autowired
  private ITurnosService turnosService;

  @GetMapping
  public ResponseEntity<List<TurnoOutputDTO>> obtenerTodosLosTurnos(){
    return ResponseEntity.ok().body(this.turnosService.obtenerTodos());
  }

  @GetMapping("/{id}")
  public ResponseEntity<TurnoOutputDTO> obtenerTurnoPorId(@PathVariable Long id){
    return ResponseEntity.ok().body(this.turnosService.obtenerPorId(id));
  }

  @PostMapping
  public ResponseEntity<Long> crearTurno(@RequestBody TurnoIntputDTO turnoACrear){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.turnosService.crearTurno(turnoACrear));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarTurno(@PathVariable Long id){
    this.turnosService.eliminarTurno(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<TurnoOutputDTO> modificarTurno(@RequestBody TurnoIntputDTO turnoNuevo, @PathVariable Long id){
    return ResponseEntity.ok().body(this.turnosService.modificarTurno(turnoNuevo, id));
  }
}
