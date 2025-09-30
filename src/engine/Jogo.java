package engine;

import data.model.Cliente;
import data.model.MenuItem;
import data.persistence.IPersistencia;
import data.persistence.PersistenciaLocal;  // Revertido para Local
import data.setup.Cardapio;
import data.setup.ClienteGen;

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
    
    // Aqui começa o código pra música tocar do começo ao fim em loop
    // 1. Variável para controlar a música de fundo
    private MusicPlayer backgroundMusic; 
    
    private Random random = new Random();
    private Queue<Cliente> filaClientes = new LinkedList<>();

    private Map<Cliente, MenuItem> pedidos = new HashMap<>();

    private int pontos = 0;
    private Cliente clienteAtual;
    private MenuItem pedidoAtual;

    private IPersistencia persistencia = new PersistenciaLocal();  // Revertido para Local
    //private IPersistencia persistencia = new PersistenciaTableStorage(System.getenv("STORAGE_CONNECTION_STRING"));

    // Construtor: Ideal para iniciar a música assim que o jogo for instanciado
    public Jogo() {
        // 2. Chama o método de inicialização de áudio com o caminho corrigido.
        // O caminho reflete: [raiz do classpath] + /assets/audio/ + [nome do arquivo]
        String musicPath = "/assets/audio/SSvid.net--no-copyright-music-Dreamy-Mode-cute-background-music_1080.wav";
        iniciarMusicaDeFundo(musicPath);
    }
    
    // Método auxiliar para iniciar a thread da música
    private void iniciarMusicaDeFundo(String filePath) {
        if (backgroundMusic == null) {
            backgroundMusic = new MusicPlayer(filePath);
            // Inicia a música em uma thread separada para não travar o jogo
            Thread musicThread = new Thread(backgroundMusic);
            musicThread.start();
        }
    }
    
    // Método para parar a música e liberar recursos (importante ao fechar o jogo)
    public void pararMusicaDeFundo() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
    }

    public void iniciarJogo() {
        // Carrega a última pontuação ao iniciar o jogo
        this.pontos = persistencia.carregarUltimaPontuacao();
        System.out.println("Jogo iniciado com pontuação carregada: " + pontos);
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
        new TelaPreparo(this, this.pedidoAtual);
    }

    public void processarPedido(boolean correto) {
        if (correto) {
            pontos += 10;
        } else {
            pontos -= 5;
        }

        //Chamada para a interface (agora PersistenciaLocal)
        persistencia.salvarPedido(
            this.clienteAtual.getNome(),
            this.pedidoAtual.getName(),
            correto,
            this.pontos
        );

        if (pontos <= 0) {
            // 3. Para a música ao entrar no Game Over
            pararMusicaDeFundo(); 
            new TelaGameOver(pontos);
        } else {
            new TelaResultado(this, correto, pontos);
        }
    }

    public int getPontos() {
        return pontos;
    }
}