package com.api.alunos.exception;

import javax.persistence.EntityNotFoundException;

public class AlunoNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public AlunoNotFoundException(String message) {
		super(message);
	}

	public AlunoNotFoundException(Long alunoId) {
		this(String.format("não existe carro com id %d", alunoId));
	}

}
