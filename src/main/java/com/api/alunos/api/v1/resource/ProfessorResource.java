package com.api.alunos.api.v1.resource;

import com.api.alunos.dto.ProfessorDTO;
import com.api.alunos.model.Professor;
import com.api.alunos.service.ProfessorServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/professores")
public class ProfessorResource {

    private ProfessorServiceImpl professorServicImpl;

    public ProfessorResource(ProfessorServiceImpl professorServicImpl) {
        this.professorServicImpl = professorServicImpl;
    }

    @GetMapping
    @ApiOperation(value = "Lista todos os professores")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDTO> listar(){
        return professorServicImpl.listar();
    }

    @PostMapping
    @ApiOperation(value = "Salva um registro")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDTO salvar(@Valid @RequestBody Professor professor){
        return professorServicImpl.salvar(professor);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Edita um registro")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDTO editar(@Valid @PathVariable Long id, @RequestBody Professor professor){
        return professorServicImpl.editar(id, professor);
    }
}
