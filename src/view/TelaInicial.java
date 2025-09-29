package view;

import engine.Jogo;
import java.awt.*;
import javax.swing.*;

public class TelaInicial extends JFrame {
    public TelaInicial(Jogo jogo) {
        setTitle("JavaBeans - Tela Inicial");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BackgroundPanel background = new BackgroundPanel("/assets/cafe_background.png");
        background.setLayout(new BorderLayout());

        // Trocando a JLabel pelo OutlineLabel
        OutlineLabel lblTitulo = new OutlineLabel("☕ JavaBeans Cafeteria");
        // Fonte alterada para suportar os emojis
        lblTitulo.setFont(new Font("Segoe UI Emoji", Font.BOLD, 28));
        lblTitulo.setTextColor(Color.WHITE); // Use the method from your custom class

        JButton btnIniciar = new JButton("Iniciar Jogo");
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 16));
        btnIniciar.addActionListener(e -> {
            dispose();
            jogo.gerarProximoCliente();
        });

        JPanel centro = new JPanel(new BorderLayout());
        centro.setOpaque(false);
        centro.add(lblTitulo, BorderLayout.CENTER);

        background.add(centro, BorderLayout.CENTER);
        background.add(btnIniciar, BorderLayout.SOUTH);

        setContentPane(background);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}