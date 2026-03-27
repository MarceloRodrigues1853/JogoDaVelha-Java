package org.jogo_da_velha;

// Exceção personalizada para o jogo
public class JogadaInvalidaException extends Exception {
    public JogadaInvalidaException(String mensagem) {
        super(mensagem);
    }
}