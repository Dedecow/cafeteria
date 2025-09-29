package view;

import java.awt.*;
import javax.swing.*;

public class TelaResultado extends JFrame {
    public TelaResultado(engine.Jogo jogo, boolean acerto, int pontos) {
        setTitle("JavaBeans - Resultado");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BackgroundPanel background = new BackgroundPanel("/assets/cafe_telapreparo_e_resultado.jpg");
        background.setLayout(new BorderLayout());

        String msg = acerto ? "☕ Pedido correto! +10 pontos" : "❌ Pedido errado! -5 pontos";
        
        // Substituindo os JLabels por OutlineLabels
        OutlineLabel lblResultado = new OutlineLabel(msg);
        
        // Fonte alterada para suportar emojis
        lblResultado.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        lblResultado.setTextColor(acerto ? Color.GREEN : Color.RED);

        OutlineLabel lblPontos = new OutlineLabel("Pontuação atual: " + pontos);
        lblPontos.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPontos.setTextColor(Color.WHITE);

        JButton btnProximo = new JButton("Próximo Cliente");
        btnProximo.addActionListener(e -> {
            dispose();
            jogo.gerarProximoCliente();
        });

        JPanel painel = new JPanel(new GridLayout(3, 1));
        painel.setOpaque(false);
        painel.add(lblResultado);
        painel.add(lblPontos);
        painel.add(btnProximo);

        background.add(painel, BorderLayout.CENTER);

        setContentPane(background);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}