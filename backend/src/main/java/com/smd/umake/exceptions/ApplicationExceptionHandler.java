package com.smd.umake.exceptions;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler{

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
    Map<String, String> errorMap = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach( error -> {
      errorMap.put(error.getField(), error.getDefaultMessage());
    } );

    return errorMap;
  }
}
