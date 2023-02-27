package br.com.digytalspace.contarural.entities;

public class Endereco {

	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private String municipio;
	private String uf;
	
	public Endereco() {
	}

	public Endereco(String cep, String logradouro, String numero, String bairro, String complemento, String municipio,
			String uf) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.municipio = municipio;
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setEstado(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append(cep + ";")
				.append(logradouro + ";")
				.append(numero + ";")
				.append(bairro + ";")
				.append(complemento + ";")
				.append(municipio + ";")
				.append(uf)
				.toString();
	}
	
	
}
