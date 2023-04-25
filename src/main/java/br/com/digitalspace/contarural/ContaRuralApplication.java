package br.com.digitalspace.contarural;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.digitalspace.contarural.models.Endereco;
import br.com.digitalspace.contarural.models.Pessoa;
import br.com.digitalspace.contarural.services.GerarArquivoCsvService;
import br.com.digitalspace.contarural.services.PadronizarConformeBacenService;

public class ContaRuralApplication {

    public static void main(String[] args) {
        Path pastaDestino = Paths.get("C:\\conta-rural");
        Path arquivoDestino = Paths.get(pastaDestino + "\\conta-rural-fichas-cadastrais.csv");
        Path arquivoPadronizadoDestino = Paths.get(pastaDestino + "\\conta-rural-fichas-cadastrais-bacen.csv");

        var gerarArquivoCsvService = new GerarArquivoCsvService();
        var padronizarConformeBacenService = new PadronizarConformeBacenService();

        Pessoa p1 = new Pessoa();
        p1.setNome("João Avelino");
        p1.setDataNascimento(new Date());
        p1.setCpfCnpj("12345678910");
        p1.setRgIe("11122233");
        p1.setRendaAtual(3500.90);
        p1.setCelular(85999887765L);
        p1.setEmail("joao_avelino@gmail.com");

        Endereco e1 = new Endereco();
        e1.setCep(62690000);
        e1.setLogradouro("Estrada Cana Brava");
        e1.setNumero("100");
        e1.setBairro("Barrinha");
        e1.setComplemento("em frente à igreja");
        e1.setMunicipio("Trairí");
        e1.setUf("ce");
        p1.setEndereco(e1);

        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formatador.format(p1.getDataNascimento());

        StringBuilder conteudoAGravar = new StringBuilder();
        conteudoAGravar.append(p1.getNome() + ";");
        conteudoAGravar.append(dataFormatada + ";");
        conteudoAGravar.append(p1.getCpfCnpj() + ";");
        conteudoAGravar.append(p1.getRgIe() + ";");
        conteudoAGravar.append(p1.getRendaAtual() + ";");
        conteudoAGravar.append(p1.getTelefone() + ";");
        conteudoAGravar.append(p1.getCelular() + ";");
        conteudoAGravar.append(p1.getEmail() + ";");
        conteudoAGravar.append(p1.getEndereco().getLogradouro() + ";");
        conteudoAGravar.append(p1.getEndereco().getNumero() + ";");
        conteudoAGravar.append(p1.getEndereco().getBairro() + ";");
        conteudoAGravar.append(p1.getEndereco().getComplemento() + ";");
        conteudoAGravar.append(p1.getEndereco().getMunicipio() + ";");
        conteudoAGravar.append(p1.getEndereco().getUf() + ";");
        conteudoAGravar.append(p1.getEndereco().getCep() + ";");
        
        //conteudoAGravar.append(System.lineSeparator()+"Maria Joaquina;1968-08-17;012.345.678-10;101010101;2800.00;null;99998877;majo@lol.com;"
          //      + "Fazenda Pindobal;s/n;Catu;Ao lado do bar do Zé;Alagoinhas;Bahia;48110000;");

        // criar e escrever no arquivo o conteúdo sem formatação
        gerarArquivoCsvService.executar(pastaDestino, arquivoDestino, conteudoAGravar.toString());

        // extrair o conteudo do arquivo inicial e padronizar
        String conteudoPadronizadoBacen = padronizarConformeBacenService.executar(arquivoDestino);
        
        // salvar o conteúdo padronizado em um novo arquivo csv
        gerarArquivoCsvService.executar(pastaDestino, arquivoPadronizadoDestino, conteudoPadronizadoBacen.toString());

    }

}
