package com.api.alunos.exception;

public class AlunoNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public AlunoNotFoundException(String message) {
		super(message);
	}

	public AlunoNotFoundException(Long alunoId) {
		this(String.format("não existe aluno com id %d", alunoId));
	}

}
