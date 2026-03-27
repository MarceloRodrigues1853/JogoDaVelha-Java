package org.jogo_da_velha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        int rodadas = 0;

        System.out.println("=== BEM-VINDO AO JOGO DA VELHA ===");

        try {
            while (true) {
                jogo.exibirTabuleiro();
                System.out.println("Vez do Jogador: " + jogo.getJogadorAtual());

                try {
                    System.out.print("Escolha a LINHA (0, 1 ou 2): ");
                    int linha = leitor.nextInt();
                    System.out.print("Escolha a COLUNA (0, 1 ou 2): ");
                    int coluna = leitor.nextInt();

                    jogo.realizarJogada(linha, coluna);
                    rodadas++;

                    if (jogo.verificarVencedor()) {
                        jogo.exibirTabuleiro();
                        System.out.println("\nFIM DE JOGO! O Jogador " + jogo.getJogadorAtual() + " venceu!");
                        break;
                    }

                    if (rodadas == 9) {
                        jogo.exibirTabuleiro();
                        System.out.println("\nEMPATE! Deu velha.");
                        break;
                    }

                    jogo.alternarJogador();

                } catch (JogadaInvalidaException e) {
                    System.out.println("\n[AVISO] " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("\n[ERRO] Use apenas NUMEROS (0, 1 ou 2) para as coordenadas.");
                    leitor.nextLine(); // Limpa o buffer do teclado para evitar loop
                }
            }
        } finally {
            // O ÚNICO FINALLY NECESSÁRIO:
            // Ele garante que o leitor será fechado quando o 'while' quebrar (vitoria/empate)
            // ou se ocorrer um erro inesperado no sistema.
            leitor.close();
            System.out.println("\nSistema encerrado com sucesso.");
        }
    }
}