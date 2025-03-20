package org.utn.ba.clase1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.utn.ba.clase1.exceptions.TurnoNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

  @ExceptionHandler(TurnoNotFoundException.class)
  public ResponseEntity<?> turnoNotFoundExceptionHandler(Exception e){
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(e.getMessage());
  }
}