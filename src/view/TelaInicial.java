package view;

import engine.Jogo;
import java.awt.*;
import javax.swing.*;

public class TelaInicial extends JFrame {
    public TelaInicial(Jogo jogo) {
        setTitle("JavaBeans - Tela Inicial");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnIniciar = new JButton("Bem vindo ao JavaBeans! Clique para iniciar.");
        btnIniciar.addActionListener(e -> {
            dispose();
            jogo.gerarPedido();
            jogo.proximoPedido();

        });

        add(btnIniciar, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
