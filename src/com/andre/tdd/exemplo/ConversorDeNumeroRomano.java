package com.andre.tdd.exemplo;
import java.util.HashMap;
import java.util.Map;

public class ConversorDeNumeroRomano {

	// Passo 1: Falha
	// public int converte(String numeroEmRomano) {
	// return 0;
	// }

	// Passo 2: Funciona apenas um caso
	// public int converte(String numeroEmRomano) {
	// return 1;
	// }

	// Passo 3: Resolve problema do 5
	// public int converte(String numeroEmRomano) {
	// if (numeroEmRomano.equals("I"))
	// return 1;
	// else if (numeroEmRomano.equals("V"))
	// return 5;
	// return 0;
	// }

	// private static Map<String, Integer> tabela = new HashMap<String,
	// Integer>() {
	// {
	// put("I", 1);
	//
	// put("II", 2);
	//
	// put("V", 5);
	// put("X", 10);
	// put("L", 50);
	// put("C", 100);
	// put("D", 500);
	// put("M", 1000);
	// }
	// };

	private static Map<Character, Integer> tabela = new HashMap<Character, Integer>() {
		{
			put('I', 1);

			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);

		}
	};

	// public int converte(String numeroEmRomano) {
	// return tabela.get(numeroEmRomano);
	// }

	// public int converte(String numeroEmRomano) {
	// int acumulador = 0;
	// for (int i = 0; i < numeroEmRomano.length(); i++) {
	// acumulador += tabela.get(numeroEmRomano.charAt(i));
	// }
	// return acumulador;
	// }

	public int converte(String numeroEmRomano) {
		int acumulador = 0;
		int ultimoVizinhoDaDireita = 0;
		for (int i = numeroEmRomano.length() - 1; i >= 0; i--) {
			// pega o inteiro referente ao simbolo atual
			int atual = tabela.get(numeroEmRomano.charAt(i));
			// se o da direita for menor, o multiplicaremos
			// por -1 para torna-lo negativo
			int multiplicador = 1;
			if (atual < ultimoVizinhoDaDireita)
				multiplicador = -1;
			acumulador += tabela.get(numeroEmRomano.charAt(i)) * multiplicador;
			// atualiza o vizinho da direita
			ultimoVizinhoDaDireita = atual;
		}
		return acumulador;
	}

}
