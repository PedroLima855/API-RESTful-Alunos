package com.api.alunos.dto;

import lombok.*;

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

}
