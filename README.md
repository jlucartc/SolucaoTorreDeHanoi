# Solução do problema das torres de Hanoi

Autor: João Luca Ripardo Teixeira Costa

Esse projeto possui dois algoritmos, um recursivo e outro direto, para resolver 
o problema das torres de Hanoi.

## Termos utilizados

- Pilha inicial: pilha onde todas as peças se encontram inicialmente
- Pilha final: pilha para onde eu desejo mover a pilha de peças
- Pilha auxiliar: pilha que não é inicial nem final

## Explicação do algoritmo

A idéia do algoritmo vem da noção de que, para uma torre com N peças, 3 passos são sempre
necessários para resolver o problema. Esses passos são:

1. Desempilhar as N-1 primeiras peças da pilha inicial

2. Mover a N-ésima peça da pilha inicial para a pilha final

3. Empilhar as N-1 peças restantes na pilha final, em cima da N-ésima peça

Dado esse algoritmo inicial, é possivel concluir que:

1. Os passos 1 e 3 possuem o mesmo número de movimentos

2. Para resolver um problema com N peças, é preciso primeiro resolver um problema de N-1 peças

A conclusão 1 pode ser demonstrada da seguinte forma:

No momento imediatamente anterior ao passo 2, como só existem 3 pilhas, a pilha inicial estará ocupada com a peça N, e a pilha final precisa necessariamente estar vazia para que a peça N possa ocupá-la, então chegamos à conclusão que o único arranjo possível para as N-1 peças menores é de estarem empilhadas na pilha auxiliar. Como sabemos que as N-1 peças menores estão empilhadas na pilha inicial no começo do problema, então o que queremos fazer é equivalente a mover N-1 peças para a pilha auxiliar. Representamos o custo dessa operação por C(N-1).

No momento imediatamente posterior ao passo 2, sabemos que a pilha auxiliar permanece inalterada, pois o passo anterior não a modificou. Logo, o que devemos fazer em seguida segundo o passo 3 é empilhar a pillha das N-1 menores peças na pilha final. Portanto, como 1 e 3 se reduzem ao mesmo problema de empilhar N-1 peças, podemos afirmar que ambos possuem o mesmo custo.

Partindo dessas conclusões, temos que a expressão do custo C(N) para N peças é dado por:

`C(N) = 2*C(N-1) + 1`, 

que é o custo dos passos 1 e 3 mais o custo de mover uma peça no passo 2.

Expandindo a expressão do custo na forma de uma série, temos o seguinte:


	C(0) = 0
	C(1) = 2*(0) + 1 = 1
	C(2) = 2*(2*(0) + 1) + 1 = 2*0 + 2 + 1 = 2*1 + 1
	C(3) = 2*(2 + 1) + 1 = 2*2 + 2*1 + 1
	C(4) = 2*(2*2 + 2*1 + 1) + 1 = 2*2*2 + 2*2 + 2 + 1
	C(5) = 2*(2*2*2 + 2*2 + 2 + 1) + 1 = 2*2*2*2 + 2*2*2 + 2*2 + 2 + 1
	.
	.
	.
	C(N) = Soma de uma P.G. onde o primeiro termo é 1 e a razão é 2.

	Logo, a expressão que define o número de operações para uma torre com N peças é:

	C(N) = (1 - 2^(N))/(1 - 2)  = 2^(N) – 1 ▄
	
## Provando que a expressão do custo é ótima

Para provar que a expressão é ótima precisamos primeiro provar que o modelo é ótimo. O modelo proposto diz que qualquer problema pode ser resolvido com 3 operações, que são:

1. Desempilhar as N-1 primeiras peças na pilha auxiliar
2. Mover a peça N da pilha inicial para a pilha final
3. Empilhar as N-1 primeiras peças na pilha final

Note que é impossível mover as N peças da pilha inicial até a pilha final sem obedecer os 3 passos em sequência, pois a ordem dos passos influencia no estado final da pilha. Analizando os passos, podemos concluir que:

- O passo 1 não pode ocorrer depois do passo 2, pois a N-ésima peça só pode sair quando as de cima saírem.
- O passo 1 não pode ocorrer depois do passo 3, pois a essa altura as N-1 peças já teriam sido desempilhadas.
- O passo 1 não pode ser substituido pelo passo 3 e seguido por pelo passo 2, pois isso implicaria em por a N-ésima peça em cima das outras.
- O passo 2 não pode ocorrer depois do passo 3, pois a N-ésima peça não pode ficar acima das outras.

Além disso, não é possível omitir nenhum dos 3 passos sem comprometer o resultado final:

- Ao omitir apenas o passo 1, fica impossível mover a N-ésima peça, tornando impossível empilhar as N peças na pilha final.
- Ao omitir apenas o passo 2, a pilha final não terá todas as N peças empilhadas.
- Ao omitir apenas o passo 3, a pilha final ainda estará sem as N-1 peças restantes, implicando na não resolução do problema.

O mesmo ocorre caso sejam omitidas dois passos quaisquer:

- Se omitirmos 1 e 2, a N-ésima peça não estará na pilha final.
- Se omitirmos 1 e 3, 2 torna-se impossível e as N peças não poderão estar na pilha final.
- Se omitirmos 2 e 3, pelo menos uma peça ainda estará fora da pilha final.

Obviamente, se todos os passos forem omitidos, então o problema segue inalterado.

Qualquer outra solução precisa, portanto, utilizar ao menos esses 3 passos para poder resolver o problema.

Logo, provamos que o problema só se resolve se os 3 passos forem executados em sequência(condição necessária). ▄

Também podemos observar que os 3 passos são suficientes para resolver o problema para qualquer quantidade de peças, pois:

Ao executar o passo I, temos N-1 peças na pilha auxiliar e a N-ésima peça na pilha original.

Ao executar o passo II, temos a N-ésima peça na pilha final.

Ao executar o passo 3, estamos apenas empillhando as N-1 peças  em cima da N-ésima peça, resultando em uma pilha com N peças empilhadas corretamente na pilha final, que é a solução procurada.

Logo, como sabemos que os 3 passos são condições necessárias e suficientes, sabemos que qualquer movimentação adicional de peças é um custo desnecessário. Portanto, provamos que os 3 passos são a maneira menos custosa de resolver o problema das torres de Hanoi.  ▄
