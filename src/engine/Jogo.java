package engine;

import data.Cardapio;
import data.MenuItem;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import data.Cliente;
import data.ClienteGen;
import view.*;
import java.util.HashMap;
import java.util.Map;


public class Jogo {
    private Random random = new Random();
    private Queue<Cliente> filaClientes = new LinkedList<>();

    private Map<Cliente, MenuItem> pedidos = new HashMap<>();

    private int pontos = 0;
    private Cliente clienteAtual;

    public void iniciarJogo() {
        Cliente clienteAtual = ClienteGen.gerarClienteRandom();
        new TelaInicial(this);
    }

    public MenuItem gerarPedidoRand() {
        List<MenuItem> menu = Cardapio.getMenu();
        int index = random.nextInt(menu.size());
        return menu.get(index);
    }

    public void gerarPedido() {
        clienteAtual = ClienteGen.gerarClienteRandom();
        MenuItem pedido = Cardapio.getMenu().get(random.nextInt(Cardapio.getMenu().size()));

        // associa cliente ao pedido

        System.out.println(clienteAtual.getNome() + "pediu: " + pedido.getName());

        new TelaPreparo(this, clienteAtual, pedido);
    }

    public void proximoPedido(){
        clienteAtual = ClienteGen.gerarClienteRandom();
        new TelaJogo(this,clienteAtual);
    }

    public void processarPedido(boolean correto) {
        if (correto) pontos += 10; else pontos -= 5;

        if (pontos <= 0){
            pontos = 0;
            new TelaGameOver(this);
        }
        else {
            new TelaResultado(this,correto,pontos);
        }
    }

    public int getPontos() {
        return pontos;
    }
}
