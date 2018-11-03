# Trabalho-02-SO
Segundo trabalho da disciplina Sistemas Operacionais, do curso Sistemas de Informação, da Universidade Federal de Santa Catarina (UFSC).

## Descrição do Problema
O objetivo deste trabalho é que o estudante aplique os conceitos de threads, exclusão mútua e coordenação de processos por meio do projeto e implementação de um jogo simples.

O jogo consiste de um tabuleiro 10 X 10 casas (posições). Nesse tabuleiro, inicialmente são distribuídas  cinco fichas aleatoriamente em qualquer uma das 100 casas, conforme a figura abaixo:

![alt text](https://github.com/SadiJr/Trabalho-SO-02/blob/master/.imagens/jogo.png)

Após disparado o jogo, as fichas movimentam-se simultaneamente para qualquer posição do tabuleiro. O objetivo do jogo é que o jogador elimine todas as fichas dentro de um tempo máximo t. Para eliminar uma ficha, o jogador tem que clicar com o cursor posicionado em qualquer posição da casa na qual a ficha encontra-se.

O jogo tem cinco níveis de dificuldade: fácil, intermediário e difícil. No fácil, as fichas movem-se mais lentamente e o tempo t é maior; no difícil, as fichas movem-se mais rapidamente e o tempo t é menor; no intermediário o tempo de movimentação e t ficam entre os níveis fácil e difícil.

## Objetivo do trabalho

O objetivo deste trabalho é implementar o jogo em Java ou em C.
