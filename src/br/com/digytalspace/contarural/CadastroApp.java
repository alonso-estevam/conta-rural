package br.com.digytalspace.contarural;

import br.com.digytalspace.contarural.util.Util;


public class CadastroApp {

	public static void main(String[] args) {
		System.out.println("CONTA RURAL - CADASTRO");

		Util.salvarRegistroNoArquivoCsv(Util.gerarDados());
		Util.gerarArquivoPadraoBacen(Util.extraiDadosDoArquivoCsv());

	}

}
