package com.api.alunos.api.v1.resource;

import com.api.alunos.dto.AlunoDTO;
import com.api.alunos.model.Aluno;
import com.api.alunos.service.AlunoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@Api("Alunos API REST")
@RequestMapping("api/v1/alunos")
public class AlunoResource {

	private AlunoServiceImpl alunoServiceImpl;

	public AlunoResource(AlunoServiceImpl alunoServiceImpl) {
		super();
		this.alunoServiceImpl = alunoServiceImpl;

	}

	// Listar todos os registros
	@GetMapping
	@ApiOperation(value = "Lista todos os registros")
	public List<AlunoDTO> listar() {
		return alunoServiceImpl.listar();

	}

	// busca um registro atravez do Id
	@GetMapping("/{alunoId}")
	@ApiOperation(value = "Faz uma busca atraves do id")
	public AlunoDTO buscarPorId(@PathVariable Long alunoId) {

		return alunoServiceImpl.listarPorId(alunoId);

	}

	// pesquisa um registro atrvez do email
	@GetMapping("/pesquisa/{email}")
	@ApiOperation(value = "Faz uma pesquisa atravez do email")
	public List<AlunoDTO> pesquisarAluno(@PathVariable String email) {
			return alunoServiceImpl.pesquisar(email);
	}

	// Salva um registro
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Salva um registro")
	public AlunoDTO salvar(@Valid @RequestBody Aluno aluno) {
		return alunoServiceImpl.salvar(aluno);
	}

	// edita um registro
	@PutMapping("/{alunoId}")
	@ApiOperation(value = "Edita um registro")
	@ResponseStatus(HttpStatus.OK)
	public AlunoDTO editarAluno(@Valid @PathVariable Long alunoId, @RequestBody Aluno aluno) {
		return alunoServiceImpl.editar(alunoId, aluno);
	}

	// apaga um registro
	@DeleteMapping("/{alunoId}")
	@ApiOperation(value = "Deleta um registro")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarAluno(@PathVariable Long alunoId) {
		alunoServiceImpl.apagar(alunoId);

	}

}
