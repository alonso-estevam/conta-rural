package br.com.digytalspace.contarural.util;

public class PadroesBacen {
	String campoPadronizado = "";
	
	/**
	 * Padroniza nomes em geral. Se o valor for superior ao tamanho máximo de caracteres,
	 * corta o final do nome; caso seja inferior, completa com espaços à esquerda. Aplica-se a:
	 * nome (30),
	 * logradouro (60),
	 * bairro (30),
	 * complemento (20),
	 * cidade (50)
	 * @param campo
	 * @param tamanhoMaximoDeCaracteres
	 * @return a String padronizada conforme BACEN
	 */
	public String padronizaString(String campo, Integer tamanhoMaximoDeCaracteres){
		if(campo.length() > tamanhoMaximoDeCaracteres){
			campoPadronizado = campo.substring(0, tamanhoMaximoDeCaracteres);
		} else if(campo.length() < tamanhoMaximoDeCaracteres) {
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < tamanhoMaximoDeCaracteres; i++) {
				builder.append(" ");
			}
			campoPadronizado = builder.insert(builder.length() - campo.length(), campo).toString().stripTrailing();
		}
		return campoPadronizado.toUpperCase();
	 }
}
