package data;
import java.util.Random;


public class ClienteGen {
    Random gerador = new Random();
    private static final String[] nomes = {"Maria", "João", "Ana", "Pedro", "Sofia", "Lucas"};

    private static final Random GERADOR = new Random();

    public static String gerarNome(){
        int indice = GERADOR.nextInt(nomes.length);
        return nomes[indice];
    }

    public static Cliente gerarClienteRandom(){
        int tipo = GERADOR.nextInt(4);
        return switch (tipo){
            case 0 -> new ClienteApressado();
            case 1 -> new ClienteExigente();
            case 2 -> new ClienteCalmo();
            default -> new ClienteIndeciso();
        };
    }
}
