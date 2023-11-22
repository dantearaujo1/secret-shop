package com.smd.umake.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class EntityAlreadyExistsException extends RuntimeException{
  public EntityAlreadyExistsException(String errorMessage) {
    super(errorMessage);
  }
}
