package com.example.demo.v2.switchexpression;

public class Teste {

	public static void main(String[] args) {
		String nome = "Jo�o";
		switch (nome) {
		case "Renata": {
			System.out.println("Acertou: " + nome);
			break;
		}
		case "Jo�o": {
			System.out.println("Acertou: " + nome);
			break;
		}
		default: {
			System.out.println("Nenhum nome encontrado!!");
		}
		}
	}
}
