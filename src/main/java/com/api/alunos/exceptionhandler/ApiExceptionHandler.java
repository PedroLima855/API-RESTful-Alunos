package com.api.alunos.exceptionhandler;

import com.api.alunos.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handlerEntityNotFoundException(EntityNotFoundException ex){

        Problema problema = Problema.builder()
                .hora(LocalDateTime.now()).mensagem(ex.getMessage()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problema);
    }


}
