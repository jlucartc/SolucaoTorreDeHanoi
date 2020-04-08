/*
	Autor: João Luca Ripardo Teixeira Costa
	github: github.com/jlucartc

	Uma vez que se sabe que a o numero de operações para mover
	uma pilha de N peças é dada pela expressão exponencial:

	Passos(N) = 2^(N) - 1,

	Então basta aplicar a formula diretamente, sem precisar utilizar recursão.

*/

import java.lang.Math;
import java.util.Scanner;

// Calcula os passos aplicando a formula direta, recebendo a quantidade N de peças.
public static int calcularPassos(int quantidadePecas){

	return Math.pow(2,quantidadePecas)-1;

}

class AlgoritmoTorreHanoiDireto{


	// Variável que recebe o número de peças
	int quantidadePecas;

	// Recebe a quantidade de peças e guarda na variável 'quantidadePecas'
	System.out.println("Digite a quantidade de peças: ");
	Scanner in = new Scanner(System.in);
    quantidadePecas = in.nextInt();

    // Imprime o resultado no console
	System.out.println("Número mínimo de passo para "+Integer.toString(quantidadePecas)+" peças: "+Integer.toString(calcularPassos(quantidadePecas)));
	


}