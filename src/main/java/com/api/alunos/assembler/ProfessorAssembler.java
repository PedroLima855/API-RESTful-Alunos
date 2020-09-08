package com.api.alunos.assembler;

import com.api.alunos.dto.ProfessorDTO;
import com.api.alunos.model.Professor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProfessorAssembler {

    private ModelMapper modelMapper;

    public ProfessorAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProfessorDTO toDTO(Professor professor){
        return modelMapper.map(professor, ProfessorDTO.class);
    }

    public List<ProfessorDTO> toCollectionDTO(List<Professor> professores){
        return professores.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


}
