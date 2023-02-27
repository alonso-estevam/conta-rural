package br.com.digytalspace.contarural.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private LocalDate dataNascimento;
	private String cpfCnpj;
	private String rgIe;
	private Character sexo;
	private String nomeMae;
	private String estadoCivil;
	private Double rendaAtual;
	private Integer telefone;
	private Integer celular;
	private String email;
	private Endereco endereco;
	
	public Pessoa() {
	}

	public Pessoa(String nome, LocalDate dataNascimento, String cpfCnpj, String rgIe, Character sexo, String nomeMae,
			String estadoCivil, Double rendaAtual, Integer telefone, Integer celular, String email, Endereco endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpfCnpj = cpfCnpj;
		this.rgIe = rgIe;
		this.sexo = sexo;
		this.nomeMae = nomeMae;
		this.estadoCivil = estadoCivil;
		this.rendaAtual = rendaAtual;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
	}

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
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	public String getRgIe() {
		return rgIe;
	}
	
	public void setRgIe(String rgIe) {
		this.rgIe = rgIe;
	}
	
	public Character getSexo() {
		return sexo;
	}
	
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	
	public String getNomeMae() {
		return nomeMae;
	}
	
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Double getRendaAtual() {
		return rendaAtual;
	}
	
	public void setRendaAtual(Double rendaAtual) {
		this.rendaAtual = rendaAtual;
	}
	
	public Integer getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
	public Integer getCelular() {
		return celular;
	}
	
	public void setCelular(Integer celular) {
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

	@Override
	public String toString() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return new StringBuilder()
				.append(nome + ";")
				.append(dataNascimento.format(dateTimeFormatter)+ ";")
				.append(cpfCnpj + ";")
				.append(rgIe + ";")
				.append(rendaAtual + ";")
				.append(telefone + ";")
				.append(celular + ";")	
				.append(email + ";")
				.append(endereco)
				.toString();
	}
	
		

}
