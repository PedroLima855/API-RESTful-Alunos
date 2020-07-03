package com.api.alunos.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.api.alunos.dto.AlunoDTO;
import com.api.alunos.model.Aluno;

@Component
public class AlunoAssembler {
	
	private ModelMapper modelMapper;

	public AlunoAssembler(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public AlunoDTO toDTO(Aluno aluno) {
		return modelMapper.map(aluno, AlunoDTO.class);
	}

	public List<AlunoDTO> toCollectionDTO(List<Aluno> alunos) {
		return alunos.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}
}
