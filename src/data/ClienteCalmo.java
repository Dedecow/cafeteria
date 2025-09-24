package data;

public class ClienteCalmo extends Cliente {
    public ClienteCalmo(String nome, MenuItem pedido){
        super(ClienteGen.gerarNome());
    }

    @Override
    public String comportamento() {
        return FrasesClientes.getFrase(TipoDeCliente.CALMO);
    }
}