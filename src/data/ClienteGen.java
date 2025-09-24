package data;
import java.util.Random;



public class ClienteGen {
    private static final Random GERADOR = new Random();

    private static final String[] nomes = {"Maria", "João", "Ana", "Pedro", "Sofia", "Lucas"};


    public static String gerarNome(){
        int indice = GERADOR.nextInt(nomes.length);
        return nomes[indice];
    }
    public static MenuItem gerarPedido() {
        int indice = GERADOR.nextInt(Cardapio.getMenu().size());
        return Cardapio.getMenu().get(indice);
    }


    public static Cliente gerarClienteRandom(){
        int tipo = GERADOR.nextInt(4);
        String nome = gerarNome();
        MenuItem pedido = gerarPedido();
        return switch (tipo){
            case 0 -> new ClienteApressado(nome, pedido);
            case 1 -> new ClienteExigente(nome, pedido);
            case 2 -> new ClienteCalmo(nome, pedido);
            default -> new ClienteIndeciso(nome, pedido);
        };
    }
}
