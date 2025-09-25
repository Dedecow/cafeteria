package view;

import engine.Jogo;
import java.awt.*;
import javax.swing.*;

public class TelaResultado extends JFrame {
    public TelaResultado(Jogo jogo, boolean acerto, int pontos) {
        setTitle("JavaBeans - Resultado");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Usa imagem específica para tela de resultado
        BackgroundPanel background = new BackgroundPanel("/assets/cafe_telapreparo_e_resultado.jpg");

        background.setLayout(new BorderLayout());

        String msg = acerto ? "☕ Pedido correto! +10 pontos" : "❌ Pedido errado! -5 pontos";
        JLabel lblResultado = new JLabel(msg, SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 20));
        lblResultado.setForeground(acerto ? Color.GREEN : Color.RED);

        JLabel lblPontos = new JLabel("Pontuação atual: " + pontos, SwingConstants.CENTER);
        lblPontos.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPontos.setForeground(Color.WHITE);

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