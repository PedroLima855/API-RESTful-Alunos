package com.api.alunos.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

	private Long id;
	private String nome;
	private String email;
	private int matricula;

	private CursoDTO curso;
	private List<ProfessorDTO> professores;

}
