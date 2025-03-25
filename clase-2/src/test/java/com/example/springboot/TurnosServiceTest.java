package com.example.springboot;

import com.example.springboot.dtos.output.TurnoOutputDTO;
import com.example.springboot.mappers.TurnoMapper;
import com.example.springboot.models.entities.Animal;
import com.example.springboot.models.entities.Mascota;
import com.example.springboot.models.entities.Turno;
import com.example.springboot.models.repositories.TurnoRepository;
import com.example.springboot.services.imp.TurnosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TurnosServiceTest {

  @Mock
  private TurnoRepository turnoRepository;

  @InjectMocks
  private TurnosService turnosService;

  @BeforeEach
  void setUp(){
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testObtenerTodos(){
    //Arrange
    Mascota mascota = Mascota
        .builder()
        .nombre("Ramon")
        .animal(Animal.GATO)
        .build();

    Turno turno = Turno
        .builder()
        .mascota(mascota)
        .build();

    when(turnoRepository.findAll()).thenReturn(Collections.singletonList(turno));

    //Act
    List<TurnoOutputDTO> turnos = turnosService.obtenerTodos();

    //Assert
    assertEquals(1,turnos.size());
    assertEquals(TurnoMapper.crearAPartirDe(turno), turnos.get(0));
  }
}
