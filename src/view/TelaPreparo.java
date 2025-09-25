package view;

import engine.Jogo;
import java.awt.*;
import javax.swing.*;

public class TelaPreparo extends JFrame {
    public TelaPreparo(Jogo jogo, String pedido) {
        setTitle("JavaBeans - Preparando " + pedido);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Usa imagem específica para tela de preparo
        BackgroundPanel background = new BackgroundPanel("/assets/cafe_telapreparo_e_resultado.jpg");

        background.setLayout(new BorderLayout());

        JLabel lblPedido = new JLabel("Preparando: " + pedido, SwingConstants.CENTER);
        lblPedido.setFont(new Font("Arial", Font.BOLD, 18));
        lblPedido.setForeground(Color.WHITE);

        JButton btnFinalizar = new JButton("Finalizar Preparo");
        btnFinalizar.addActionListener(e -> {
            dispose();
            jogo.processarPedido(true);
        });

        JButton btnErrar = new JButton("Errar Preparo");
        btnErrar.addActionListener(e -> {
            dispose();
            jogo.processarPedido(false);
        });

        JPanel botoes = new JPanel();
        botoes.setOpaque(false);
        botoes.add(btnFinalizar);
        botoes.add(btnErrar);

        background.add(lblPedido, BorderLayout.CENTER);
        background.add(botoes, BorderLayout.SOUTH);

        setContentPane(background);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}