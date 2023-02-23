package br.com.digytalspace.contarural.entities;

import java.time.LocalDate;

public class Pessoa {
	
	private String nome;
	private LocalDate dataNascimento;
	private String cpfOuCnpj;
	private String rgOuIe;
	private Character sexo;
	private String nomeDaMae;
	private Character estadoCivil;
	private Double rendaAtual;
	private String telefone;
	private String celular;
	private String email;
	private Endereco endereco;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	
	public String getRgOuIe() {
		return rgOuIe;
	}
	
	public void setRgOuIe(String rgOuIe) {
		this.rgOuIe = rgOuIe;
	}
	
	public Character getSexo() {
		return sexo;
	}
	
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	
	public String getNomeDaMae() {
		return nomeDaMae;
	}
	
	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}
	
	public Character getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(Character estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Double getRendaAtual() {
		return rendaAtual;
	}
	
	public void setRendaAtual(Double rendaAtual) {
		this.rendaAtual = rendaAtual;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
