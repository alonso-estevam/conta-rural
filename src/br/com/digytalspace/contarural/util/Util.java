package br.com.digytalspace.contarural.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import br.com.digytalspace.contarural.entities.Endereco;
import br.com.digytalspace.contarural.entities.Pessoa;

public class Util {
	
	private static String path = "c:\\conta-rural\\conta-rural-fichas-cadastrais.csv";
	private static List<Pessoa> listaClientes;
	private static List<Endereco> listaEnderecos = Arrays.asList(
			new Endereco("62690000", "Estrada Cana Brava", "S/N", "Barrinha", "Em frente à Igreja São João Batista", "Trairí","CE"),
			new Endereco("63705-774", "Rua Joelson Silva Barros", "1200", "Cidade Nova", "-","Crateús","Ceará"),
			new Endereco("48110000", "Fazenda Pindobal", "S/N", "Catu", "Ao lado do bar do Zé","Alagoinhas","Bahia")
			);
	
	public static List<Pessoa> gerarDados() {
		listaClientes = Arrays.asList(
				new Pessoa("Maria Joaquina", LocalDate.of(1968, 11, 17),"012.345.678-10", "101010101",2800.00,0,99998877,"majo@lol.com",listaEnderecos.get(0)),
				new Pessoa("Raimundo Kleverson", LocalDate.of(1985, 8, 2),"999.888.777-00", "98765432103",1950.00,33262901,981001122,"keke@gmail.com",listaEnderecos.get(1)),
				new Pessoa("Antonia Moura", LocalDate.of(1979, 2, 21),"000.111.222-33", "200300400",1800.00,0,99998876,"toinha@gmail.com",listaEnderecos.get(2))
				);
		return listaClientes;
	}
	
	public static PadroesBacen bacen = new PadroesBacen();
	
	public static void salvarRegistroNoArquivoCsv(List<Pessoa> lista) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			bw.newLine();
			for (Pessoa pessoa : lista) {
				bw.append(pessoa.toString());				
				bw.newLine();
			}
			System.out.println("Registro salvo");
			
		} catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public static String extraiDadosDoArquivoCsv() {
		StringBuilder sb = new StringBuilder();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String linha = br.readLine();
			linha = br.readLine();
			
			while(linha != null) {
				String[] campos = linha.split(";");
				
				sb.append(bacen.padronizaDadosTextuais(campos[0], 30) + ";"); //nome
				sb.append(bacen.padronizaDatas(campos[1]) + ";"); 			// dataNascimento
				sb.append(bacen.padronizaDadosNumericos(campos[2], 14) + ";"); //cpf
				sb.append(bacen.padronizaDadosNumericos(campos[3], 10) + ";"); //rg
				sb.append(bacen.padronizaDadosNumericos(campos[4], 10) + ";"); //renda
				sb.append(bacen.padronizaDadosNumericos(campos[5], 10) + ";"); //telefone
				sb.append(bacen.padronizaDadosNumericos(campos[6], 10) + ";"); //celular
				sb.append(bacen.padronizaEmail(campos[7]) + ";");			 //email
				sb.append(bacen.padronizaDadosNumericos(campos[8], 8) + ";");//cep
				sb.append(bacen.padronizaDadosTextuais(campos[9], 60) + ";"); //logradouro
				sb.append(bacen.padronizaDadosNumericos(campos[10], 5) + ";"); //numero
				sb.append(bacen.padronizaDadosTextuais(campos[11], 30) + ";"); //bairro
				sb.append(bacen.padronizaDadosTextuais(campos[12], 20) + ";"); //complemento
				sb.append(bacen.padronizaDadosTextuais(campos[13], 50) + ";"); //municipio
				sb.append(bacen.padronizaDadosTextuais(campos[14], 2) + "\n"); //uf
				
				linha = br.readLine();
			}
		} catch(IOException e) {
			System.out.println("Err: " + e.getMessage());
		}
		return sb.toString();
	}
	
	public static void gerarArquivoPadraoBacen(String registros) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\conta-rural\\conta-rural-fichas-cadastrais-bacen.txt", true))){
			bw.append(registros);
			System.out.println("Registro salvo");
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
