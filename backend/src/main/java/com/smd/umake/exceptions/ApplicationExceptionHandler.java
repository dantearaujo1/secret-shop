package com.smd.umake.exceptions;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody Map<String,String> handleNotFound(EntityNotFoundException ex){
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put("statusCode", String.valueOf(HttpStatus.NOT_FOUND.value()));
    errorMap.put("message", ex.getMessage());

    return errorMap;
  }

  @ExceptionHandler(ArgumentInvalidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public @ResponseBody Map<String,String> handleArgumentInvalid(ArgumentInvalidException ex){
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put("statusCode", String.valueOf(HttpStatus.BAD_REQUEST.value()));
    errorMap.put("message", ex.getMessage());
    return errorMap;

  }
}
