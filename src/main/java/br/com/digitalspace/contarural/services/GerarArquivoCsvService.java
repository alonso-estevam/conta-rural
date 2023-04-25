package br.com.digitalspace.contarural.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class GerarArquivoCsvService {
    
    public void executar(Path pastaDestino, Path arquivoDestino, String conteudo) {
        try {
            if (Files.notExists(pastaDestino)) {
                Files.createDirectory(pastaDestino);
            } 
            Files.write(arquivoDestino, conteudo.getBytes(StandardCharsets.UTF_8), 
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao criar arquivo: " + e.getMessage());
        } 
    }
}
