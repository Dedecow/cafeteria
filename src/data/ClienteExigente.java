package data;

public class ClienteExigente extends ClienteApressado {
    public ClienteExigente() {
        super();
    }

    @Override
    public String comportamento(){
        return FrasesClientes.getFrase("exigente");
    }
}
