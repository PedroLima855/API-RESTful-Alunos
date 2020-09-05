package com.api.alunos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Email
	@NotBlank
	private String email;
	
	@NotNull
	private int matricula;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Aluno)) return false;
		Aluno aluno = (Aluno) o;
		return getId().equals(aluno.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
