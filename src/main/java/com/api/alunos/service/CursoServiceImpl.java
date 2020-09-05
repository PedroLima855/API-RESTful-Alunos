package com.api.alunos.service;

import com.api.alunos.assembler.CursoAssembler;
import com.api.alunos.dto.CursoDTO;
import com.api.alunos.model.Curso;
import com.api.alunos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl {

    private CursoAssembler cursoAssembler;
    private CursoRepository cursoRepository;


    public CursoServiceImpl(CursoAssembler cursoAssembler, CursoRepository cursoRepository) {
        this.cursoAssembler = cursoAssembler;
        this.cursoRepository = cursoRepository;
    }

    public List<CursoDTO> listar(){
        return cursoAssembler.toCollectionDTO(cursoRepository.findAll());
    }

    public CursoDTO salvar(Curso curso){
        return cursoAssembler.toDTO(cursoRepository.save(curso));
    }
}
