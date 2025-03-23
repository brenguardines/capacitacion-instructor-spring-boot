package com.example.springboot.config;

import com.example.springboot.models.entities.users.Rol;
import com.example.springboot.services.imp.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  private final CustomUserDetailsService userDetailsService;

  public SecurityConfig(CustomUserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf().disable()
        .authorizeHttpRequests(
            auth ->
                auth

                    .requestMatchers("/public/**")
                    .permitAll()
                    .requestMatchers(HttpMethod.POST, "/usuarios")
                    .permitAll()
                    .requestMatchers(HttpMethod.POST, "/mascotas")
                    .hasAnyRole(Rol.ADMIN.toString(), Rol.VETERINARIO.toString(), Rol.RECEPCIONISTA.toString())
                    .requestMatchers("/mascotas/**")
                    .authenticated()
                    .requestMatchers(HttpMethod.POST, "/turnos")
                    .hasAnyRole("ADMIN", "RECEPCIONISTA")
                    .requestMatchers("/turnos/**")
                    .hasAnyRole("ADMIN", "RECEPCIONISTA")
                    .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());
    return httpSecurity.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }
}