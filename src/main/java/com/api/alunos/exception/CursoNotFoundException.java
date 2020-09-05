package com.api.alunos.exception;

public class CursoNotFoundException extends EntityNotFoundException {


    public CursoNotFoundException(String message) {
        super(message);
    }

    public CursoNotFoundException(Long id){
        this(String.format("não existe curso com id %d", id));
    }
}
