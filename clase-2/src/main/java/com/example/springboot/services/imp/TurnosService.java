package com.example.springboot.services.imp;

import com.example.springboot.dtos.input.TurnoInputDTO;
import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.mappers.TurnoMapper;
import com.example.springboot.models.entities.Timestamp;
import com.example.springboot.models.entities.Turno;
import com.example.springboot.models.repositories.MascotaRepository;
import com.example.springboot.models.repositories.TurnoRepository;
import com.example.springboot.models.repositories.UsuarioRepository;
import com.example.springboot.services.ITurnosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TurnosService implements ITurnosService {
    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<TurnoOutputDTO> obtenerTodos() {
        return this.turnoRepository.findAll().stream().map(TurnoMapper::crearAPartirDe).toList();
    }

    @Override
    public TurnoOutputDTO obtenerPorId(Long id) {
        Optional<Turno> turno = this.turnoRepository.findById(id);
        return turno.map(TurnoMapper::crearAPartirDe).orElse(null);
    }

    @Override
    public Long crearTurno(TurnoInputDTO turno, UserDetails userDetails) {
        Turno nuevoTurno = Turno
            .builder()
            .fecha(turno.getFecha())
            .usuario(this.usuarioRepository.findByNombreDeUsuario(userDetails.getUsername()).get())
            .mascota(this.mascotaRepository.findById(UUID.fromString(turno.getMascotaId())).get())
            .timestamp(new Timestamp())
            .build();
        this.turnoRepository.save(nuevoTurno);
        return nuevoTurno.getId();
    }

    public TurnoOutputDTO modificarTurno(TurnoInputDTO turno, Long id) {

        Turno turnoAModificar = new ObjectMapper().convertValue(turno, Turno.class);

        if (turnoRepository.existsById(id)) {
            this.turnoRepository.save(turnoAModificar);
            return TurnoMapper.crearAPartirDe(turnoAModificar);
        }

        return null;
    }

    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    public TurnoOutputDTO buscarPorId(Long id) {
        Optional<Turno> turno = this.turnoRepository.findById(id);

        return turno.map(TurnoMapper::crearAPartirDe).orElse(null);
    }
}
