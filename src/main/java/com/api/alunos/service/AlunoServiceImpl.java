package com.api.alunos.service;

import com.api.alunos.assembler.AlunoAssembler;
import com.api.alunos.dto.AlunoDTO;
import com.api.alunos.exception.AlunoNotFoundException;
import com.api.alunos.model.Aluno;
import com.api.alunos.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl {

	private AlunoAssembler alunoAssembler;
	private AlunoRepository alunoRepository;

	public AlunoServiceImpl(AlunoAssembler alunoAssembler, AlunoRepository alunoRepository) {
		this.alunoAssembler = alunoAssembler;
		this.alunoRepository = alunoRepository;
	}


	public List<AlunoDTO> listar() {
		return alunoAssembler.toCollectionDTO(alunoRepository.findAll());
	}


	public AlunoDTO listarPorId(Long alunoId) {

		return alunoAssembler
				.toDTO(alunoRepository.findById(alunoId).orElseThrow(()
						-> new AlunoNotFoundException(alunoId)));
	}


	public List<AlunoDTO> pesquisar(String email) {

		return alunoAssembler.toCollectionDTO(alunoRepository.findByEmailStartingWith(email));
	}

	public AlunoDTO salvar(Aluno aluno) {

		return alunoAssembler.toDTO(alunoRepository.save(aluno));
	}


	public AlunoDTO editar(Long alunoId, Aluno aluno) {

		Aluno aluno1 = alunoRepository.findById(alunoId).orElseThrow(()
				-> new AlunoNotFoundException(alunoId));

		aluno1.setNome(aluno.getNome());
		aluno1.setEmail(aluno.getEmail());
		aluno1.setMatricula(aluno.getMatricula());
		aluno1.setCurso(aluno.getCurso());
		aluno1.setProfessores(aluno.getProfessores());

		return alunoAssembler.toDTO(alunoRepository.save(aluno1));
	}

	public void apagar(Long alunoId) {
		alunoRepository
				.delete(alunoRepository.findById(alunoId).orElseThrow(()
						-> new AlunoNotFoundException(alunoId)));

	}

}
