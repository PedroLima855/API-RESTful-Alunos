package com.api.alunos.api.v1.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.alunos.dto.AlunoDTO;
import com.api.alunos.model.Aluno;
import com.api.alunos.service.AlunoServiceImpl;

@RestController
@RequestMapping("api/v1/alunos")
public class AlunoResource {

	private AlunoServiceImpl alunoServiceImpl;

	public AlunoResource(AlunoServiceImpl alunoServiceImpl) {
		super();
		this.alunoServiceImpl = alunoServiceImpl;

	}

	// Listar todos os registros
	@GetMapping
	public List<AlunoDTO> listar() {
		return alunoServiceImpl.listar();

	}

	// busca um registro atravez do Id
	@GetMapping("/{alunoId}")
	public AlunoDTO buscarPorId(@PathVariable Long alunoId) {

		return alunoServiceImpl.listarPorId(alunoId);

	}

	// pesquisa um registro atrvez do email
	@GetMapping("/pesquisa/{email}")
	public List<AlunoDTO> pesquisarAluno(@PathVariable String email) {
		return alunoServiceImpl.pesquisar(email);

	}

	// Salva um registro
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AlunoDTO salvar(@Valid @RequestBody Aluno aluno) {
		return alunoServiceImpl.salvar(aluno);

	}

	// edita um registro
	@PutMapping("/{alunoId}")
	public AlunoDTO editarAluno(@Valid @PathVariable Long alunoId, @RequestBody Aluno aluno) {
		return alunoServiceImpl.editar(alunoId, aluno);
	}

	// apaga um registro
	@DeleteMapping("/{alunoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarAluno(@PathVariable Long alunoId) {
		alunoServiceImpl.apagar(alunoId);

	}

}