package org.utn.ba.clase1.exceptions;

public class TurnoNotFoundException extends RuntimeException{
  public TurnoNotFoundException(String message){
    super(message);
  }
}
