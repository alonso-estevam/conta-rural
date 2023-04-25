package br.com.digitalspace.contarural.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PadronizarConformeBacenService {
    
    public String executar(Path arquivoFonte) {
        StringBuilder conteudoPadronizadoBacen = new StringBuilder("");
        
     // ler o arquivo inicial
        try {
            int i = 0;
            String conteudoExtraido = Files.readString(arquivoFonte);
           
            // separa o conteúdo do arquivo por linhas
            String[] linhas = conteudoExtraido.split(System.lineSeparator());
            
            while (i < linhas.length) {
                
                // separa os dados individuais de cada linha
                String[] dados = linhas[i].split(";");

                // formatar os dados
                conteudoPadronizadoBacen.append(padronizarCampos(dados) + System.lineSeparator());
                i++;
            }
            return conteudoPadronizadoBacen.toString();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e);
        }
        return null;
        
    }
    
    private String padronizarCampos(String[] dados) {
        StringBuilder sb = new StringBuilder();
        sb.append(formatarNome(dados[0]) + ";");      // nome
        sb.append(formatarData(dados[1]) + ";");      // data de nascimento
        sb.append(formatarCpfCnpjRgIe(dados[2]) + ";");   // cpf/cnpj
        sb.append(formatarCpfCnpjRgIe(dados[3]) + ";");   // rg/ie
        sb.append(formatarRendaAtual(dados[4]) + ";");// renda atual
        sb.append(formatarTelefone(dados[5]) + ";");  // telefone
        sb.append(formatarCelular(dados[6]) + ";");   // celular
        sb.append(formatarEmail(dados[7]) + ";");     // email
        sb.append(formatarLogradouro(dados[8]) + ";");// logradouro
        sb.append(formatarNumero(dados[9]) + ";");    // numero
        sb.append(formatarNome(dados[10]) + ";");      // bairro
        sb.append(formatarComplemento(dados[11]) + ";"); // complemento
        sb.append(formatarCidade(dados[12]) + ";"); // cidade
        sb.append(formatarEstado(dados[13]) + ";"); // estado
        sb.append(formatarCep(dados[14]) + ";"); // cep
        
        return sb.toString();
    }
    
    private String formatarNome(String nome) {
        if(nome.length() > 30) {
            return nome.substring(0, 30).toUpperCase();
        }
        return String.format("%30s", nome).toUpperCase();
    }
    
    private String formatarData(String data) {
        return data.replaceAll("[^0-9]", "");
    }
    
    private String formatarCpfCnpjRgIe(String numero) {
        return String.format("%014d", Long.valueOf(numero.replaceAll("[^0-9]","")));
    }
    
    private String formatarRendaAtual(String renda) {
        if(renda.equals("") || renda.equals("null")) { // verificar outro método
            return String.format("%010d", 0);
        }
        return String.format("%010d", Long.valueOf(renda.replaceAll("[^0-9]","")));
    }
    
    private String formatarTelefone(String telefone) {
        if(telefone.equals("null")) {
            return String.format("%010d", 0);
        }
        return String.format("%010d", Long.valueOf(telefone.replaceAll("[^0-9]","")));
    }
    
    private String formatarCelular(String celular) {
        if(celular.equals("null")) {
            return String.format("%011d", 0);
        }
        return String.format("%011d", Long.valueOf(celular.replaceAll("[^0-9]","")));
    }

    private String formatarEmail(String email) {
        return String.format("%70s", email).toLowerCase();
    }
    
    private String formatarLogradouro(String logradouro) {
        if(logradouro.length() > 60) {
            return String.format("%60s", logradouro).toUpperCase();
        }
        return logradouro.toUpperCase();            
    }
    
    private String formatarNumero(String numero) {
        if(numero.equalsIgnoreCase("S/N")) {
            return "00000";
        }
        return String.format("%05d", Integer.valueOf(numero));
    }
    
    private String formatarComplemento(String nome) {
        if(nome.length() > 20) {
            return nome.substring(0, 20).toUpperCase();
        }
        return String.format("%20s", nome).toUpperCase();
    }
    
    private String formatarCidade(String cidade) {
        if(cidade.length() > 50) {
            return cidade.substring(0, 50).toUpperCase();
        }
        return String.format("%50s", cidade).toUpperCase();
    }
    
    private String formatarEstado(String estado) {
        return estado.toUpperCase();
    }
    
    private String formatarCep(String cep) {
        if(cep.equalsIgnoreCase("null")) {
            return "00000000";
        }
        return String.format("%08d", Integer.valueOf(cep));
    }
    
}
