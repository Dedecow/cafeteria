package data;

public class ClienteCalmo extends Cliente {
    public ClienteCalmo(){
        super(ClienteGen.gerarNome());
    }

    @Override
    public String comportamento() {
        return FrasesClientes.getFrase(TipoDeCliente.CALMO);
    }
}