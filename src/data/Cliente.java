package data;

public abstract class Cliente {
    private String nome;
    private MenuItem pedido;


    public Cliente(String nome) {
        this.nome = nome;
        this.pedido = pedido;
    }


    public String getNome() {
        return nome;
    }
    public MenuItem getPedido() {
        return pedido;
    }

    public abstract String comportamento();
}
