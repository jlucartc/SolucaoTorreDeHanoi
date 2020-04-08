/*
	Autor: João Luca Ripardo Teixeira Costa
	github: github.com/jlucartc

	Uma vez que se sabe que o numero de operações para mover
	uma pilha de N peças é dado pela expressão exponencial:

	C(N) = 2^(N) - 1,

	Então basta aplicar a fórmula diretamente, sem precisar utilizar recursão.

*/

import java.lang.Math;
import java.util.Scanner;


class AlgoritmoTorreHanoiDireto{


	// Calcula os passos aplicando a formula direta, recebendo a quantidade N de peças.
	public static long calcularPassos(long quantidadePecas){

		return ((long)Math.pow(2,quantidadePecas))-1;

	}

	public static void main(String[] args){

		// Variável que recebe o número de peças
		long quantidadePecas;

		// Recebe a quantidade de peças e guarda na variável 'quantidadePecas'
		System.out.println("Digite a quantidade de peças: ");
		Scanner in = new Scanner(System.in);
		quantidadePecas = in.nextInt();

		// Imprime o resultado no console
		System.out.println("Número mínimo de passos para "+Long.toString(quantidadePecas)+" peças: "+Long.toString(calcularPassos(quantidadePecas)));



	}


}
