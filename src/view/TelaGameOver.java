package view;

import engine.Jogo;
import java.awt.*;
import javax.swing.*;

public class TelaGameOver extends JFrame {
    public TelaGameOver(int pontos) {
        setTitle("Game Over");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BackgroundPanel background = new BackgroundPanel("/assets/cafe_telagameover.jpg");
        background.setLayout(new BorderLayout());

        // OutlineLabel aqui
        OutlineLabel lblFim = new OutlineLabel("☠️ Fim de jogo!");
        OutlineLabel lblPontos = new OutlineLabel("Pontuação final: " + pontos);
        
        // Fonte alterada para suportar emojis
        // O nome da fonte deve estar de acordo com o sistema operacional
        lblFim.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
        lblFim.setTextColor(Color.RED); 
        
        lblPontos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPontos.setTextColor(Color.WHITE); 

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

    public TelaGameOver(Jogo jogo, int pontos) {
    }
}