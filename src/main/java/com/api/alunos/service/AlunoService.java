package com.api.alunos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.alunos.dto.AlunoDTO;
import com.api.alunos.model.Aluno;

@Service
public interface AlunoService {

	List<AlunoDTO> listar();
	AlunoDTO listarPorId(Long alunoId);
	List<AlunoDTO> pesquisar(String email);
	AlunoDTO salvar(Aluno aluno);
	AlunoDTO editar(Long alunoId, Aluno aluno);
	void apagar(Long alunoId);
}
