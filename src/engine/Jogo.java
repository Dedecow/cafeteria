package engine;

import data.Cliente;
import data.ClienteApressado;
import view.*;

public class Jogo {
    private int pontos = 0;
    private Cliente clienteAtual;

    public void iniciarJogo() {
        new TelaInicial(this);
    }

    public void gerarPedido() {
        clienteAtual = new ClienteApressado("Carlos");
        new TelaJogo(this, clienteAtual);
    }

    public void processarPedido(boolean correto) {
        if (correto) pontos += 10; else pontos -= 5;
        new TelaResultado(this, correto, pontos);
    }

    public int getPontos() {
        return pontos;
    }
}
