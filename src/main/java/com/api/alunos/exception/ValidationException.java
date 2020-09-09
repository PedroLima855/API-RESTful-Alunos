package com.api.alunos.exception;

public class ValidationException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public ValidationException(String message) {
        super(String.format("Ocorreu um erro inesperado no sistema, tente novamente %d", message));
    }

}
