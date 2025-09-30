package data.persistence;
/* 
import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableServiceClient;
import com.azure.data.tables.TableServiceClientBuilder;
import com.azure.data.tables.models.TableEntity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class PersistenciaTableStorage implements IPersistencia {
    private final TableClient tableClient;

    public PersistenciaTableStorage(String connectionString) {
        TableServiceClient serviceClient = new TableServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
        this.tableClient = serviceClient.getTableClient("Pedidos");
        tableClient.createTableIfNotExists();
        System.out.println("Conectado ao Azure Table Storage!");
    }

    @Override
    public void salvarPedido(String nomeCliente, String pedido, boolean acerto, int pontuacao) {
        TableEntity entity = new TableEntity(nomeCliente, UUID.randomUUID().toString());
        entity.addProperty("Pedido", pedido);
        entity.addProperty("Acerto", acerto);
        entity.addProperty("Pontuacao", pontuacao);
        entity.addProperty("Data", OffsetDateTime.now().toString());

        tableClient.upsertEntity(entity);
        System.out.println("Pedido salvo no Azure: Cliente=" + nomeCliente + ", Pontos=" + pontuacao);
    }
}

*/