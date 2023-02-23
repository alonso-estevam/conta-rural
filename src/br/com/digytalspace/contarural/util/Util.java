package br.com.digytalspace.contarural.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {
	private static StringBuilder input = new StringBuilder();
	private static Scanner scanner; 
	private static String path = ".\\public\\conta-rural-fichas-cadastrais.csv";
	
	public static String receberDados() {
		String registro = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String cabecalho = br.readLine();
			
			String[] vetor = cabecalho.split(";");
			scanner = new Scanner(System.in);
			for(int i = 0; i < vetor.length; i++) {
				System.out.print(vetor[i].replaceAll("_", " ") + ": ");
				input.append(scanner.nextLine() + ";");
							
			}
			
			registro = input.toString();			
			scanner.close();
			
		} catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return registro;
	}
	
	
	public static void salvarRegistroNoArquivoCsv(String registro) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			bw.newLine();
			bw.append(registro);
			System.out.println("Registro salvo");
			
		} catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
