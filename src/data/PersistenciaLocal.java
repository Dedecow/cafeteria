package data;

import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Implementação da IPersistencia que salva os dados em um arquivo CSV local.
 */
public class PersistenciaLocal implements IPersistencia {
    
    private static final String PASTA_DADOS = "storage";
    private static final String NOME_ARQUIVO = "historico_pedidos.csv";
    private static final String CAMINHO_COMPLETO = PASTA_DADOS + File.separator + NOME_ARQUIVO;

    private void garantirPastaDados() {
        File pasta = new File(PASTA_DADOS);
        if (!pasta.exists()) {
            if (pasta.mkdirs()) {
                System.out.println("Pasta de dados criada: " + PASTA_DADOS);
            } else {
                System.err.println("Erro: Não foi possível criar a pasta de dados: " + PASTA_DADOS);
            }
        }
    }

    @Override
    public void salvarPedido(String nomeCliente, String pedido, boolean acerto, int pontuacao) {
        garantirPastaDados();
        
        String linha = String.format("%s, %s, %s, %b, %d, %s\n",
            UUID.randomUUID().toString(),
            nomeCliente,
            pedido,
            acerto,
            pontuacao,
            new Date().toString()
        );

        try (FileWriter fw = new FileWriter(CAMINHO_COMPLETO, true)) {
            fw.write(linha);
            System.out.println("Pedido salvo localmente em: " + CAMINHO_COMPLETO);
        } catch (IOException e) {
            System.err.println("Erro ao salvar pedido localmente: " + e.getMessage());
        }
    }
}