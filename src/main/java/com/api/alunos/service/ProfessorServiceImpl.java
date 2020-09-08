package com.api.alunos.service;

import com.api.alunos.assembler.ProfessorAssembler;
import com.api.alunos.dto.ProfessorDTO;
import com.api.alunos.exception.ProfessorNotFoundException;
import com.api.alunos.model.Professor;
import com.api.alunos.repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessorServiceImpl {

    private ProfessorRepository professorRepository;
    private ProfessorAssembler professorAssembler;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, ProfessorAssembler professorAssembler) {
        this.professorRepository = professorRepository;
        this.professorAssembler = professorAssembler;
    }

    public List<ProfessorDTO> listar(){
        return professorAssembler.toCollectionDTO(professorRepository.findAll());
    }

    public ProfessorDTO editar(Long id, Professor professor){

       Professor prof = professorRepository.findById(id).orElseThrow(() -> new ProfessorNotFoundException(id));

       prof.setNome(professor.getNome());
       prof.setAlunos(professor.getAlunos());
       prof.setMateria(professor.getMateria());

       return professorAssembler.toDTO(professorRepository.save(prof));
    }


    public ProfessorDTO salvar(Professor professor){
        return professorAssembler.toDTO(professorRepository.save(professor));
    }
}
