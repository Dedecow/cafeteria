package data;

public class ClienteExigente extends Cliente {
    public ClienteExigente() {
        super(ClienteGen.gerarNome());
    }

    @Override
    public String comportamento(){
        return FrasesClientes.getFrase(TipoDeCliente.EXIGENTE);
    }
}