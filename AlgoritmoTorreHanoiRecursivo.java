/*

Autor: João Luca Ripardo Teixeira Costa
github: github.com/jlucartc

Idéia geral do algoritmo para resolver o problema das torres de Hanoi:

Dado uma quantidade N de peças, o problema pode ser resolvido em 3 etapas:

1 - Desempilhar N-1 peças da pilha inicial;
2 - Mover a N-ésima peça para a pilha desejada;
3 - Empilhar as N-1 peças em cima da N-ésima peça, na pilha desejada;

Sabendo que os passos 1 e 2 envolvem empilhar N-1 peças, o numero
de passos para resolver um problema de tamanho N, dado pela função C(N), é:

C(N) = 2*C(N-1)+1

Com base nisso, podemos resolver esse problema de forma recursiva.

Para ver a demonstração de que esse algoritmo é ótimo, e fornece sempre o menor número de
passos possível, além de outros detalhes, consulte o README.md em https://github.com/jlucartc/SolucaoTorreDeHanoi

*/

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class AlgoritmoTorreHanoiRecursivo {

	// Função recursiva que calcula o número de passos para resolver o problema, dado 
	// a quantidade de peças.

	public static long calcularPassos(long quantidadePecas){

		if(quantidadePecas == 1){

			/* Caso base do problema. Sabemos que quando a torre possui apenas 1 peça, o custo
			   de reempilhar é de 1, pois basta mover a peça para a pilha desejada.
			*/

			return 1;

		}else if(quantidadePecas == 0){

			/* Caso base do problema. Sabemos que quando a torre não possui peças, o custo
			   de reempilhar é de 0, pois o problema já está trivialmente resolvido.
			*/

			return 0;

		}else{

			/* Como foi demonstrado no README.md, essa expressão é a forma recursiva da função
			   que fornece a quantidade de passos para resolver o problema da torre de Hanoi de 
			   N peças.
			*/

			return  2*calcularPassos(quantidadePecas-1)+1;

		}

	}

	public static void main(String[] args){

		// Variável que recebe o número de peças
		long quantidadePecas;

		// Recebe a quantidade de peças e guarda na variável 'quantidadePecas'
		System.out.println("Digite a quantidade de peças: ");
		Scanner in = new Scanner(System.in);
        quantidadePecas = in.nextInt();

        // Imprime o resultado no console
		System.out.println("Número mínimo de passo para "+Long.toString(quantidadePecas)+" peças: "+Long.toString(calcularPassos(quantidadePecas)));
		

	}



}