package engine;

import data.Cardapio;
import data.Cliente;
import data.ClienteGen;
import data.MenuItem;
import data.IPersistencia;
import data.PersistenciaLocal;

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

    private IPersistencia persistencia = new PersistenciaLocal(); 
    
    // LINHA PARA FUTURA MIGRAÇÃO PARA AZURE (COMENTADA POR ENQUANTO):
    // private IPersistencia persistencia = new PersistenciaAzure("SUA_CONNECTION_STRING_AQUI"); 


    public void iniciarJogo() {
        new TelaInicial(this);
    }

    public void gerarProximoCliente() {
        this.clienteAtual = ClienteGen.gerarClienteRandom();
        this.pedidoAtual = Cardapio.getMenu().get(random.nextInt(Cardapio.getMenu().size()));
        this.clienteAtual.setPedido(this.pedidoAtual);

        // CORRIGIDO: Passando o pedidoAtual para TelaJogo
        new TelaJogo(this, this.clienteAtual, this.pedidoAtual);
    }
    
    public void iniciarPreparo() {
        // CORRIGIDO: O método TelaPreparo precisa apenas do nome do pedido
        new TelaPreparo(this, this.pedidoAtual.getName());
    }

    public void processarPedido(boolean correto) {
        if (correto) {
            pontos += 10;
        } else {
            pontos -= 5;
        }

        //Chamada para a interface (PersistenciaLocal)
        persistencia.salvarPedido(
            this.clienteAtual.getNome(),
            this.pedidoAtual.getName(),
            correto,
            this.pontos
        );

        if (pontos <= 0) {
            new TelaGameOver(pontos);
        } else {
            new TelaResultado(this, correto, pontos);
        }
    }

    public int getPontos() {
        return pontos;
    }
}