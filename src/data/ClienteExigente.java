package data;

public class ClienteExigente extends Cliente {
    public ClienteExigente(String nome, MenuItem pedido) {
        super(ClienteGen.gerarNome());
    }

    @Override
    public String comportamento(){
        return FrasesClientes.getFrase(TipoDeCliente.EXIGENTE);
    }
}