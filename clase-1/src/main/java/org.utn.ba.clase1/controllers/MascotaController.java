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
import org.utn.ba.clase1.dtos.input.MascotaIntputDTO;
import org.utn.ba.clase1.dtos.output.MascotaOutputDTO;
import org.utn.ba.clase1.services.IMascotaService;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

  @Autowired
  private IMascotaService mascotaService;

  @GetMapping
  public ResponseEntity<List<MascotaOutputDTO>> obtenerTodasLasMascotas(){
    return ResponseEntity.ok().body(this.mascotaService.obtenerTodas());
  }

  @GetMapping("/{id}")
  public ResponseEntity<MascotaOutputDTO> obtenerMascotaPorId(@PathVariable Long id){
    return ResponseEntity.ok().body(this.mascotaService.obtenerPorId(id));
  }

  @PostMapping
  public ResponseEntity<Long> crearMascota(@RequestBody MascotaIntputDTO mascotaACrear){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.mascotaService.crearMascota(mascotaACrear));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarMascota(@PathVariable Long id){
    this.mascotaService.eliminarMascota(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<MascotaOutputDTO> modificarMascota(@RequestBody MascotaIntputDTO mascotaNueva, @PathVariable Long id){
    return ResponseEntity.ok().body(this.mascotaService.modificarMascota(mascotaNueva, id));
  }
}
