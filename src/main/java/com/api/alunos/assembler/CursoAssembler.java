package com.api.alunos.assembler;

import com.api.alunos.dto.CursoDTO;
import com.api.alunos.model.Curso;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CursoAssembler {

    private ModelMapper modelMapper;

    public CursoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CursoDTO toDTO(Curso curso){
        return modelMapper.map(curso, CursoDTO.class);
    }

    public List<CursoDTO> toCollectionDTO(List<Curso> cursos){
        return cursos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
