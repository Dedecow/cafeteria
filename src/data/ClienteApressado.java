package data;

public class ClienteApressado extends Cliente {
    public ClienteApressado() {
        super(ClienteGen.gerarNome());
    }

    @Override
    public String comportamento() {
        return FrasesClientes.getFrase(TipoDeCliente.APRESSADO);
    }
}