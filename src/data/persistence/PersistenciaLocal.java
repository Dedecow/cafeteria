package data.persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class PersistenciaLocal implements IPersistencia {
    
    private static final String ARQUIVO = "historico_pedidos.csv"; 

    @Override
    public void salvarPedido(String nomeCliente, String pedido, boolean acerto, int pontuacao) {
        String linha = String.format("%s, %s, %s, %b, %d, %s\n",
            UUID.randomUUID().toString(), // ID único para cada registro
            nomeCliente,
            pedido,
            acerto,
            pontuacao,
            new Date().toString()
        );

        try (FileWriter fw = new FileWriter(ARQUIVO, true)) {
            fw.write(linha);
            System.out.println("Pedido salvo localmente em: " + ARQUIVO);
        } catch (IOException e) {
            System.err.println("Erro ao salvar pedido localmente: " + e.getMessage());
        }
    }

    @Override
    public int carregarUltimaPontuacao() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            String ultimaLinha = null;
            while ((linha = br.readLine()) != null) {
                ultimaLinha = linha;  // Mantém a última linha lida
            }
            if (ultimaLinha != null) {
                // Parse da última linha: formato "id, nomeCliente, pedido, acerto, pontuacao, data"
                String[] partes = ultimaLinha.split(",");
                if (partes.length >= 5) {
                    int ultimaPontuacao = Integer.parseInt(partes[4].trim());  // Índice 4 é pontuacao
                    System.out.println("Última pontuação carregada do CSV: " + ultimaPontuacao);
                    return ultimaPontuacao;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao carregar pontuação do CSV: " + e.getMessage() + ". Iniciando com 0.");
        }
        System.out.println("Nenhum dado no CSV. Iniciando com pontuação 0.");
        return 0;
    }
}