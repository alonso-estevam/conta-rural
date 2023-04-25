package br.com.digitalspace.contarural.models;

import java.io.Serializable;

public class Endereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String municipio;
    private String uf;
    
    public Integer getCep() {
        return cep;
    }
    
    public void setCep(Integer cep) {
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
    
    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco {cep=" + cep + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro
                + ", complemento=" + complemento + ", municipio=" + municipio + ", uf=" + uf + "}";
    }
    
}
