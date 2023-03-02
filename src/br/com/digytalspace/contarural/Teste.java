package br.com.digytalspace.contarural;

import br.com.digytalspace.contarural.util.PadroesBacen;

public class Teste {

	public static void main(String[] args) {
		String nome = "Raimundo Nonato Loureiro Castelo Branco";
		String renda = "1.275,30";
		String data = "16/04/1986";
		String tel = "(11) 94565-2353";
		String numero = "123";
		String bairro = "Vila Nazare";
		String cep = "";
		
		PadroesBacen bacen = new PadroesBacen();
		System.out.println(bacen.padronizaDadosTextuais(nome, 30));
		System.out.println(bacen.padronizaDatas(data));
		System.out.println(bacen.padronizaDadosTextuais(bairro, 30));
		System.out.println(bacen.padronizaDadosNumericos(renda, 10));
		System.out.println(bacen.padronizaDadosNumericos(tel, 11));
		System.out.println(bacen.padronizaDadosNumericos(numero, 5));
		System.out.println(bacen.padronizaDadosNumericos(cep, 8));

	}

}
