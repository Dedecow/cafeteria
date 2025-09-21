package util;

import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorDeDados {
    public static void salvar(String caminho, String conteudo) {
        try (FileWriter writer = new FileWriter(caminho, true)) {
            writer.write(conteudo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
