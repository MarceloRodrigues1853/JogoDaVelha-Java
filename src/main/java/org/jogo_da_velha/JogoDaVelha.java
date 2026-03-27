package org.jogo_da_velha;

public class JogoDaVelha {
    private char[][] tabuleiro = new char[3][3];
    private char jogadorAtual = 'X';

    public JogoDaVelha() {
        // Preenche o tabuleiro com espaços vazios
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void exibirTabuleiro() {
        System.out.println("\n      0     1     2  ");
        System.out.println("   +-----+-----+-----+");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  |  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + "  |  ");
            }
            System.out.println();
            System.out.println("   +-----+-----+-----+");
        }
    }

    // Método que valida e lança exceções se a jogada for impossível
    public void realizarJogada(int linha, int coluna) throws JogadaInvalidaException {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            throw new JogadaInvalidaException("Coordenada fora do limite! Use apenas 0, 1 ou 2.");
        }
        if (tabuleiro[linha][coluna] != ' ') {
            throw new JogadaInvalidaException("Essa posicao ja esta ocupada!");
        }
        tabuleiro[linha][coluna] = jogadorAtual;
    }

    public boolean verificarVencedor() {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) return true;
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) return true;
        }
        // Diagonais
        return (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
                (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual);
    }

    public void alternarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    public char getJogadorAtual() {
        return jogadorAtual;
    }
}