package br.com.digytalspace.contarural.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.digytalspace.contarural.entities.Endereco;
import br.com.digytalspace.contarural.entities.Pessoa;

public class Util {
	private static StringBuilder input = new StringBuilder();
	private static Scanner scanner; 
	private static String path = ".\\public\\conta-rural-fichas-cadastrais.csv";
	private static List<Pessoa> listaClientes;
	private static List<Endereco> listaEnderecos = Arrays.asList(
			new Endereco("62690000", "Estrada Cana Brava", "S/N", "Barrinha", "Em frente à Igreja São João Batista", "Trairí","CE"),
			new Endereco("63705-774", "Rua Joelson Silva Barros", "1200", "Cidade Nova", "-","Crateús","Ceará"),
			new Endereco("48110000", "Fazenda Pindobal", "S/N", "Catu", "Ao lado do bar do Zé","Alagoinhas","Bahia")
			);
	
	public static List<Pessoa> gerarDados() {
		listaClientes = Arrays.asList(
				new Pessoa("Maria Joaquina", LocalDate.of(1968, 11, 17),"012.345.678-10", "101010101",'f',"Leidilaura Kelly","solteira",2800.00,0,99998877,"majo@lol.com",listaEnderecos.get(0)),
				new Pessoa("Raimundo Kleverson", LocalDate.of(1985, 8, 2),"999.888.777-00", "98765432103",'m',"Francisquinha Silva","casado",1950.00,33262901,981001122,"keke@gmail.com",listaEnderecos.get(1)),
				new Pessoa("Antonia Moura", LocalDate.of(1979, 2, 21),"000.111.222-33", "200300400",'f',"Jovita Moura","viúva",1800.00,0,99998876,"toinha@gmail.com",listaEnderecos.get(2))
				);
		return listaClientes;
	}
	
	
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
}
