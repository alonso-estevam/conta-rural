package br.com.digytalspace.contarural.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Util {
	private static StringBuilder input = new StringBuilder();
	private static Scanner scanner; 
	
	public static void receberDados() {
		String path = ".\\public\\conta-rural-fichas-cadastrais.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String cabecalho = br.readLine();
			
			String[] vetor = cabecalho.split(";");
			scanner = new Scanner(System.in);
			for(int i = 0; i < vetor.length; i++) {
				System.out.print(vetor[i].replaceAll("_", " ") + ": ");
				input.append(scanner.nextLine() + ";");
				//receberDados(vetor[i]);			
			}
			
			System.out.println(input);
			scanner.close();
			
		} catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}
