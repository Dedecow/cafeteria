package view;

import engine.Jogo;
import java.awt.*;
import javax.swing.*;

public class TelaInicial extends JFrame {
    public TelaInicial(Jogo jogo) {
        setTitle("JavaBeans - Tela Inicial");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Usa imagem específica para tela inicial
        BackgroundPanel background = new BackgroundPanel("/assets/cafe_background.png");

        background.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("☕ JavaBeans Cafeteria", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);

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