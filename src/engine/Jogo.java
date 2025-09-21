package engine;

import java.util.LinkedList;
import java.util.Queue;
import data.Cliente;
import data.ClienteGen;
import view.*;

public class Jogo {
    private Queue<Cliente> filaClientes = new LinkedList<>();
    private int pontos = 0;
    private Cliente clienteAtual;

    public void iniciarJogo() {
        new TelaInicial(this);
    }

    public void gerarPedido() {
        clienteAtual = ClienteGen.gerarClienteRandom();
        new TelaJogo(this, clienteAtual);
    }
    public void proximoPedido(){
        clienteAtual = ClienteGen.gerarClienteRandom();
        new TelaJogo(this,clienteAtual);
    }

    public void processarPedido(boolean correto) {
        if (correto) pontos += 10; else pontos -= 5;
        new TelaResultado(this, correto, pontos);
    }

    public int getPontos() {
        return pontos;
    }
}
