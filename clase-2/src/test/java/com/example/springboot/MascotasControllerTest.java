package com.example.springboot;

import com.example.springboot.dtos.input.MascotaInputDTO;
import com.example.springboot.models.entities.users.Usuario;
import com.example.springboot.models.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MascotasControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @BeforeEach
  void setUp(){
    MockitoAnnotations.openMocks(this);
    Usuario usuario = Usuario
        .builder()
        .nombre("Brenda")
        .apellido("Guardines")
        .nombreDeUsuario("bguardines")
        .contrasenia(this.passwordEncoder.encode("123456"))
        .build();

    usuarioRepository.save(usuario);
  }

  @Test
  @WithMockUser(roles = {"ADMIN", "VETERINARIO", "RECEPCIONISTA"}, username = "bguardines", password = "123456")
  void testCrearMascota() throws Exception {
    //Arrange
    MascotaInputDTO mascotaInputDTO = new MascotaInputDTO();
    mascotaInputDTO.setNombre("Firulais");
    mascotaInputDTO.setAnimal("PERRO");
    mascotaInputDTO.setAnios(3);

    String jsonContent = "{\"nombre\":\"Firulais\",\"animal\":\"PERRO\",\"anios\":3}";

    //Act & Assert
    mockMvc.perform(post("/mascotas")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonContent))
        .andExpect(status().isCreated());
  }
}
