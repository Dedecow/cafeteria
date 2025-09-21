package data;

public class ClienteApressado extends Cliente {
    public ClienteApressado(String nome) {
        super(nome);
    }

    @Override
    public String comportamento() {
        return "Vai demorar muito? Preciso rápido!";
    }
}
