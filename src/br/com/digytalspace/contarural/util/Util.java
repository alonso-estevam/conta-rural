package br.com.digytalspace.contarural.util;

import java.util.Scanner;

public class Util {
	static StringBuilder input = new StringBuilder();

	public static void receberDados() {
		if(input.length() > 0) {
			input = input.replace(0, input.length() - 1, "");
		}
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nome: ");
		input.append(scanner.next() + ";");
		System.out.print("Data de nascimento: ");
		input.append(scanner.next() + ";");
		System.out.print("CPF ou CNPJ: ");
		input.append(scanner.next() + ";");
		System.out.print("RG ou IE: ");
		input.append(scanner.next() + ";");
		System.out.print("Sexo: ");
		input.append(scanner.next() + ";");
		System.out.print("Nome da mãe: ");
		input.append(scanner.next() + ";");
		System.out.print("Estado civil: ");
		input.append(scanner.next() + ";");
		System.out.print("Renda atual: ");
		input.append(scanner.next() + ";");
		System.out.print("Telefone: ");
		input.append(scanner.next() + ";");
		System.out.print("Celular: ");
		input.append(scanner.next() + ";");
		System.out.print("Email: ");
		input.append(scanner.next() + ";");
		
		System.out.print("CEP: ");
		input.append(scanner.next() + ";");
		System.out.print("Logradouro: ");
		input.append(scanner.next() + ";");
		System.out.print("Número: ");		
		input.append(scanner.next() + ";");
		System.out.print("Bairro: ");
		input.append(scanner.next() + ";");
		System.out.print("Complemento: ");
		input.append(scanner.next() + ";");
		System.out.print("Municipio: ");
		input.append(scanner.next() + ";");
		System.out.print("Estado: ");
		input.append(scanner.next() + ";");
		
		scanner.close();
		System.out.println(input);
	}
}
