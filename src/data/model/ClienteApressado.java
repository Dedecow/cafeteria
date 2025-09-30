package data.model;

import data.setup.ClienteGen;
import data.setup.FrasesClientes;
import data.setup.TipoDeCliente;

public class ClienteApressado extends Cliente {
    public ClienteApressado(String nome, MenuItem pedido) {
        super(ClienteGen.gerarNome());
    }

    @Override
    public String comportamento() {
        return FrasesClientes.getFrase(TipoDeCliente.APRESSADO);
    }
}