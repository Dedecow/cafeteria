package data;

import java.util.Random;

public class ClienteApressado extends Cliente {
    private Random rand = new Random();
    public ClienteApressado() {
        super(ClienteGen.gerarNome());
    }

    @Override
    public String comportamento() {
        return FrasesClientes.getFrase("apressado");
    }
}
