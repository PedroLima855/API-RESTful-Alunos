package com.api.alunos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.alunos.assembler.AlunoAssembler;
import com.api.alunos.dto.AlunoDTO;
import com.api.alunos.exception.AlunoNotFoundException;
import com.api.alunos.model.Aluno;
import com.api.alunos.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

	private AlunoAssembler alunoAssembler;
	private AlunoRepository alunoRepository;

	public AlunoServiceImpl(AlunoAssembler alunoAssembler, AlunoRepository alunoRepository) {
		this.alunoAssembler = alunoAssembler;
		this.alunoRepository = alunoRepository;
	}

	@Override
	public List<AlunoDTO> listar() {

		return alunoAssembler.toCollectionDTO(alunoRepository.findAll());
	}

	@Override
	public AlunoDTO listarPorId(Long alunoId) {

		return alunoAssembler
				.toDTO(alunoRepository.findById(alunoId).orElseThrow(() -> new AlunoNotFoundException(alunoId)));
	}

	@Override
	public List<AlunoDTO> pesquisar(String email) {

		return alunoAssembler.toCollectionDTO(alunoRepository.findByEmailStartingWith(email));
	}

	@Override
	public AlunoDTO salvar(Aluno aluno) {

		return alunoAssembler.toDTO(alunoRepository.save(aluno));
	}

	@Override
	public AlunoDTO editar(Long alunoId, Aluno aluno) {

		Aluno aluno1 = alunoRepository.findById(alunoId).orElseThrow(() -> new AlunoNotFoundException(alunoId));

		aluno1.setEmail(aluno.getEmail());
		aluno1.setMatricula(aluno.getMatricula());
		aluno1.setNome(aluno.getNome());

		return alunoAssembler.toDTO(alunoRepository.save(aluno1));
	}

	@Override
	public void apagar(Long alunoId) {
		alunoRepository
				.delete(alunoRepository.findById(alunoId).orElseThrow(() -> new AlunoNotFoundException(alunoId)));

	}

}
