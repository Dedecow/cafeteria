package data.model;

import data.setup.ClienteGen;
import data.setup.FrasesClientes;
import data.setup.TipoDeCliente;

public class ClienteCalmo extends Cliente {
    public ClienteCalmo(String nome, MenuItem pedido){
        super(ClienteGen.gerarNome());
    }

    @Override
    public String comportamento() {
        return FrasesClientes.getFrase(TipoDeCliente.CALMO);
    }
}