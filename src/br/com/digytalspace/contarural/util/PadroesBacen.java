package br.com.digytalspace.contarural.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PadroesBacen {
	String campoPadronizado = "";
	
	/**
	 * Padroniza nomes em geral. Se o valor for superior ao tamanho máximo de caracteres,
	 * corta o final do nome; caso seja inferior, completa com espaços à esquerda. 
	 * <p>Aplica-se a:
	 * 	<ul>
	 * 		<li>nome (30)</li>
	 * 		<li>logradouro (60)</li>
	 * 		<li>bairro (30)</li>
	 * 		<li>complemento (20)</li>
	 * 		<li>cidade (50)</li>
	 * 	</ul>
	 * </p>
	 * @param dado
	 * @param tamanhoMaximo
	 * @return String representando textos em geral padronizados conforme BACEN
	 */
	public String padronizaDadosTextuais(String dado, Integer tamanhoMaximo){
		if(dado.length() > tamanhoMaximo){
			return dado.substring(0, tamanhoMaximo).toUpperCase();
		} else {
			return preencheCampo(dado, tamanhoMaximo, ' ').toUpperCase();					
		}
	}
	
	/**
	 * Padroniza datas, retirando quaisquer caracteres que não sejam números
	 * e colocando nesta ordem: ano, mês, dia.
	 * @param data
	 * @return String representando a data padronizada conforme BACEN
	 */
	public String padronizaDatas(String data) {
		String[] numerosData = data.split("/");
		Integer dia = Integer.parseInt(numerosData[0]);
		Integer mes = Integer.parseInt(numerosData[1]);
		Integer ano = Integer.parseInt(numerosData[2]);
		
		LocalDate dataPadronizada = LocalDate.of(ano, mes, dia);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return dataPadronizada.format(dateTimeFormatter);
	}
	
	/***
	 * Padroniza strings de números, retirando caracteres como ponto, vírgula, traços etc.
	 * Deixa somente os números e preenche o espaço restante com 0 (zero). 
	 * <p>Aplica-se a:
	 * 	<ul>
	 * 		<li>renda atual (10)</li>
	 * 		<li>telefone (10)</li>
	 * 		<li>celular (11)</li>
	 * 		<li>número (5)</li>
	 * 		<li>cep (8)</li>
	 * 	</ul>
	 * </p> 
	 * @param dado
	 * @param tamanhoMaximo
	 * @return
	 */
	public String padronizaDadosNumericos(String dado, int tamanhoMaximo) {
		String dadoFiltrado = filtraCaracteresNaoNumericos(dado);
		return preencheCampo(dadoFiltrado, tamanhoMaximo, '0');
	}
	
	private String preencheCampo(String dado, int tamanhoMaximo, char caractere) {
		if(tamanhoMaximo < dado.length()) {
			throw new IllegalArgumentException();
		}
		
		StringBuilder sb = new StringBuilder(dado);
		
		for(int i = 0; i < tamanhoMaximo - dado.length(); i++) {
			sb.insert(0, caractere);
		}
		
		return sb.toString();
	}
	
	private String filtraCaracteresNaoNumericos(String dado) {
		return dado.replaceAll("[^0-9]", "");
	}
	
}
