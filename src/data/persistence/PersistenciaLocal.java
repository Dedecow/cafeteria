package data.persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

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
}