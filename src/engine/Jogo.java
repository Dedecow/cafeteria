package engine;

import data.Cardapio;
import data.Cliente;
import data.ClienteGen;
import data.MenuItem;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import view.TelaGameOver;
import view.TelaInicial;
import view.TelaJogo;
import view.TelaPreparo;
import view.TelaResultado;


public class Jogo {
    private Random random = new Random();
    private Queue<Cliente> filaClientes = new LinkedList<>();

    private Map<Cliente, MenuItem> pedidos = new HashMap<>();

    private int pontos = 0;
    private Cliente clienteAtual;
    private MenuItem pedidoAtual;

    public void iniciarJogo() {
        new TelaInicial(this);
    }

    public void gerarProximoCliente() {
        this.clienteAtual = ClienteGen.gerarClienteRandom();
        this.pedidoAtual = Cardapio.getMenu().get(random.nextInt(Cardapio.getMenu().size()));
        this.clienteAtual.setPedido(this.pedidoAtual);

        new TelaJogo(this, this.clienteAtual);
    }
    
    public void iniciarPreparo() {
        new TelaPreparo(this, this.clienteAtual, this.pedidoAtual);
    }

    public void processarPedido(boolean correto) {
        if (correto) {
            pontos += 10;
        } else {
            pontos -= 5;
        }

        if (pontos <= 0){
            pontos = 0;
            new TelaGameOver(this);
        } else {
            new TelaResultado(this, correto, pontos);
        }
    }

    public int getPontos() {
        return pontos;
    }
}