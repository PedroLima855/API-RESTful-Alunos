package com.api.alunos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

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

	@ManyToMany
	@JoinTable(name = "aluno_professor", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
	private List<Professor> professores = new ArrayList<Professor>();

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
