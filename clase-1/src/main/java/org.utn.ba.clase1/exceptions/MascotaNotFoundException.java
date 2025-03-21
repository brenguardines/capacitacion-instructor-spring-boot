package org.utn.ba.clase1.exceptions;

public class MascotaNotFoundException extends RuntimeException{
  public MascotaNotFoundException(String message){
    super(message);
  }
}
