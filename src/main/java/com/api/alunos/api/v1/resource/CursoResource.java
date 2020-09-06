package com.api.alunos.api.v1.resource;

import com.api.alunos.dto.CursoDTO;
import com.api.alunos.model.Curso;
import com.api.alunos.service.CursoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
@Api("Alunos API REST")
public class CursoResource {

    private CursoServiceImpl cursoServiceImpl;

    public CursoResource(CursoServiceImpl cursoServiceImpl) {
        this.cursoServiceImpl = cursoServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Lista todos os cursos")
    public List<CursoDTO> listar(){
        return cursoServiceImpl.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salva um curso")
    public CursoDTO salvarCurso(@RequestBody Curso curso){
        return cursoServiceImpl.salvar(curso);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Pesquisa um curso pelo id")
    public CursoDTO bucarId(@PathVariable Long id){
        return cursoServiceImpl.buscarId(id);
    }
}
