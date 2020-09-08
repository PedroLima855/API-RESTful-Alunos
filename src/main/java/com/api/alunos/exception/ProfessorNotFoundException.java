package com.api.alunos.exception;

public class ProfessorNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public ProfessorNotFoundException(String message) {
        super(message);
    }

    public ProfessorNotFoundException(Long id){
        this(String.format("Não existe Curso com id %d", id));
    }
}
