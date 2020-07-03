package com.api.alunos.dto;

public class AlunoDTO {
	


	private Long id;
	private String nome;
	private String email;
	private int matricula;
	
	
	
	public AlunoDTO() {
		super();
	}
	public AlunoDTO(Long id, String nome, String email, int matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	

}
