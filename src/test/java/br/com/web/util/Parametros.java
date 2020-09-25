package br.com.web.util;

import java.util.Random;

public class Parametros {

	static Random aleatorio = new Random();
	static int valor = aleatorio.nextInt(100000);

	public static String criarNome = "Automa" + valor;
	public static String criarSenha = "" + valor;
	public static String usuarioCadastrado = "fillipe10";
	public static String senhaCadastrada = "321564";
	public static String sexo = "Masculino";
	public static String admissao = "01/01/2010";
	public static String cargo = "Analista de Teste";
	public static String salario = "1000000";
}