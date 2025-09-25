package view;

import java.awt.*;
import javax.swing.*;

public class TelaGameOver extends JFrame {
    public TelaGameOver(int pontos) {
        setTitle("Game Over");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Usa imagem específica para tela de game over
        BackgroundPanel background = new BackgroundPanel("/assets/cafe_telagameover.jpg");

        background.setLayout(new BorderLayout());

        JLabel lblFim = new JLabel("☠️ Fim de jogo!", SwingConstants.CENTER);
        JLabel lblPontos = new JLabel("Pontuação final: " + pontos, SwingConstants.CENTER);

        lblFim.setFont(new Font("Arial", Font.BOLD, 24));
        lblFim.setForeground(Color.RED);
        lblPontos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPontos.setForeground(Color.WHITE);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setOpaque(false);
        panel.add(lblFim);
        panel.add(lblPontos);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> System.exit(0));

        background.add(panel, BorderLayout.CENTER);
        background.add(btnSair, BorderLayout.SOUTH);

        setContentPane(background);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}