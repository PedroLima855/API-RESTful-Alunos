package com.api.alunos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.alunos.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	List<Aluno>findByEmailStartingWith(String nome);
}
