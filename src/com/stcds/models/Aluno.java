package com.stcds.models;

/**
 * Class representing the Entity Student.
 * 
 * @author Samuel T. C. Santos
 * @version 1.0
 */
public class Aluno {
	
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private int idade;
	
	/**
	 * The Constructor
	 */
	public Aluno(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
