package br.com.digytalspace.contarural;

import br.com.digytalspace.contarural.entities.Pessoa;
import br.com.digytalspace.contarural.util.Util;

public class CadastroApp {

	public static void main(String[] args) {
		System.out.println("CONTA RURAL - CADASTRO");	
		
		//Util.salvarRegistroNoArquivoCsv(Util.gerarDados().toString());
		
		for (int i = 0; i < Util.gerarDados().size(); i++) {
			System.out.println(Util.gerarDados().get(i).getNome());
		}
		
		
	}

}
