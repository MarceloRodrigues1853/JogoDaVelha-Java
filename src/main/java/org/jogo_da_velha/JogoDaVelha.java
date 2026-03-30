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
        // Códigos ANSI para as cores
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";  // Cor para o X
        String ANSI_RED = "\u001B[31m";   // Cor para o O
        String ANSI_CYAN = "\u001B[36m";  // Cor para as bordas/números (opcional)

        System.out.println("\n      0     1     2  ");
        System.out.println("   +-----+-----+-----+");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  |  ");
            for (int j = 0; j < 3; j++) {
                char peca = tabuleiro[i][j];
                String corPeca;

                // Define a cor baseada na peça
                if (peca == 'X') {
                    corPeca = ANSI_BLUE;
                } else if (peca == 'O') {
                    corPeca = ANSI_RED;
                } else {
                    corPeca = ANSI_RESET;
                }

                // Imprime a peça colorida e reseta a cor logo em seguida
                System.out.print(corPeca + peca + ANSI_RESET + "  |  ");
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