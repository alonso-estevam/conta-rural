package br.com.digitalspace.contarural.models;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nome;
    private Date dataNascimento;
    private String cpfCnpj;
    private String rgIe;
    private Double rendaAtual;
    private Long telefone;
    private Long celular;
    private String email;
    private Endereco endereco;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
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
    public Double getRendaAtual() {
        return rendaAtual;
    }
    public void setRendaAtual(Double rendaAtual) {
        this.rendaAtual = rendaAtual;
    }
    public Long getTelefone() {
        return telefone;
    }
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
    public Long getCelular() {
        return celular;
    }
    public void setCelular(Long celular) {
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
        return "Pessoa {nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpfCnpj=" + cpfCnpj + ", rgIe=" + rgIe
                + ", rendaAtual=" + rendaAtual + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email
                + ", endereco=" + endereco + "}";
    }
    
    

}
