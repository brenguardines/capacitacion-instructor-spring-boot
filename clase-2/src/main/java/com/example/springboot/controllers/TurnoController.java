package com.example.springboot.controllers;

import com.example.springboot.dtos.input.TurnoInputDTO;
import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.services.ITurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnosService turnosService;

    @GetMapping
    public ResponseEntity<List<TurnoOutputDTO>> obtenerTurnos(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.turnosService.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<String> cargarTurno(@AuthenticationPrincipal UserDetails userDetails, @RequestBody TurnoInputDTO turno){
         return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.turnosService.crearTurno(turno, userDetails).toString());

    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoOutputDTO> obtenerTurnoPorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.turnosService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTurno(@PathVariable Long id){
        this.turnosService.eliminarTurno(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoOutputDTO> modificarTurno(@RequestBody TurnoInputDTO turnoNuevo, @PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.turnosService.modificarTurno(turnoNuevo, id));
    }
}