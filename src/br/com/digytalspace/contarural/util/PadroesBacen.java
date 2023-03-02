package br.com.digytalspace.contarural.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	 * @return String representando textos em geral padronizados conforme BACEN
	 */
	public String padronizaString(String campo, Integer tamanhoMaximoDeCaracteres){
		if(campo.length() > tamanhoMaximoDeCaracteres){
			campoPadronizado = campo.substring(0, tamanhoMaximoDeCaracteres);
		} 
		
		if(campo.length() < tamanhoMaximoDeCaracteres) {
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < tamanhoMaximoDeCaracteres; i++) {
				builder.append(" ");
			}
			campoPadronizado = builder.insert(builder.length() - campo.length(), campo).toString().stripTrailing();
		}
		
		return campoPadronizado.toUpperCase();
	}
	/**
	 * Padroniza datas, retirando quaisquer caracteres que não sejam números
	 * e colocando nesta ordem: ano, mês, dia.
	 * @param data
	 * @return String representando a data padronizada conforme BACEN
	 */
	public String padronizaData(String data) {
		String[] numerosData = data.split("/");
		Integer dia = Integer.parseInt(numerosData[0]);
		Integer mes = Integer.parseInt(numerosData[1]);
		Integer ano = Integer.parseInt(numerosData[2]);
		
		LocalDate dataPadronizada = LocalDate.of(ano, mes, dia);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return dataPadronizada.format(dateTimeFormatter);
	}
	
	public String padronizaRendaAtual(String rendaAtual) {
		String rendaPadronizada = "";
		if(rendaAtual == null || rendaAtual == "") {
			rendaPadronizada = "0000000000";
		}
		String semPonto = rendaAtual.replace(".", "");
		String semVirgula = semPonto.replace(",", "");
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 10 - semVirgula.length(); i++) {
			builder.append("0");
		}
		rendaPadronizada = builder.append(semVirgula).toString();
		return rendaPadronizada;
	}
	
	
}
