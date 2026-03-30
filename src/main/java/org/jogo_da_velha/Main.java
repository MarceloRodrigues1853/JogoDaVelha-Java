package org.jogo_da_velha;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);


    Locale.setDefault(new Locale("pt", "BR"));
    int vitoriasX = 0;
    int vitoriasO = 0;
    boolean querJogarNovamente = true;
    //int rodadas = 0;

    System.out.println("=== BEM-VINDO AO JOGO DA VELHA ===");

    try {
      while (querJogarNovamente) {
        JogoDaVelha jogo = new JogoDaVelha();
        int rodadas = 0;
        boolean partidaAtiva = true;


        while (partidaAtiva) {
          try {
            jogo.exibirTabuleiro();
            System.out.println("Vez do Jogador: " + jogo.getJogadorAtual());
            System.out.print("Escolha a LINHA (0, 1 ou 2): ");
            int linha = leitor.nextInt();
            System.out.print("Escolha a COLUNA (0, 1 ou 2): ");
            int coluna = leitor.nextInt();

            jogo.realizarJogada(linha, coluna);
            rodadas++;

            if (jogo.verificarVencedor()) {
              jogo.exibirTabuleiro();
              System.out.println("\nFIM DE JOGO! O Jogador " + jogo.getJogadorAtual() + " venceu!");
              if (jogo.getJogadorAtual() == 'X') vitoriasX++;
              else vitoriasO++;
              partidaAtiva = false;

            }

            if (rodadas == 9) {
              jogo.exibirTabuleiro();
              System.out.println("\nEMPATE! Deu velha.");
              partidaAtiva = false;

            }

            if (partidaAtiva && jogo.verificarQuaseVitoria()) {
              System.out.println("[ALERTA] Jogador " + jogo.getJogadorAtual() + " esta em QUASE VITORIA!");
            }

            if (partidaAtiva) {
              jogo.alternarJogador();
            }

          } catch (JogadaInvalidaException e) {
            System.out.println("\n[AVISO] " + e.getMessage());
          } catch (InputMismatchException e) {
            System.out.println("\n[ERRO] Use apenas NUMEROS (0, 1 ou 2) para as coordenadas.");
            leitor.nextLine(); // Limpa o buffer do teclado para evitar loop
          }
        }
        System.out.print("\nDeseja jogar novamente? (S/N): ");
        String resposta = leitor.next();

        if (resposta.equalsIgnoreCase("N")) {
          querJogarNovamente = false;
        }
      }


    } finally {
      // O ÚNICO FINALLY NECESSÁRIO:
      // Ele garante que o leitor será fechado quando o 'while' quebrar (vitoria/empate)
      // ou se ocorrer um erro inesperado no sistema.
      leitor.close();
      System.out.println("\nSistema encerrado com sucesso.");
      System.out.println("\n===============================");
      System.out.println("      RESULTADO FINAL");
      System.out.println("      X: " + vitoriasX + " vitorias");
      System.out.println("      O: " + vitoriasO + " vitorias");
      System.out.println("===============================");
      System.out.println("Sistema encerrado. Obrigado por jogar!");
    }
  }
}