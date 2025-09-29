package view;

import data.MenuItem;
import engine.Jogo;

import javax.swing.*;
import java.awt.*;

public class TelaPreparo extends JFrame {
    public TelaPreparo(Jogo jogo, MenuItem pedido) {
        setTitle("JavaBeans - Preparando " + pedido.getName());
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BackgroundPanel background = new BackgroundPanel("/assets/cafe_telapreparo_e_resultado.jpg");
        background.setLayout(new BorderLayout());

        // JLabel alterada pelo OutlineLabel
        OutlineLabel lblPedido = new OutlineLabel("Escolha os ingredientes para: " + pedido.getName());
        lblPedido.setFont(new Font("Arial", Font.BOLD, 18));
        lblPedido.setTextColor(Color.WHITE); // Use o método setTextColor

        // Painel modularizado de ingredientes
        PainelIngredientes painelIngredientes = new PainelIngredientes(pedido);

        JButton btnFinalizar = new JButton("Confirmar Preparo");
        btnFinalizar.addActionListener(e -> {
            dispose();
            boolean correto = painelIngredientes.validarSelecao();
            jogo.processarPedido(correto);
        });

        JPanel botoes = new JPanel();
        botoes.setOpaque(false);
        botoes.add(btnFinalizar);

        background.add(lblPedido, BorderLayout.NORTH);
        background.add(painelIngredientes, BorderLayout.CENTER);
        background.add(botoes, BorderLayout.SOUTH);

        setContentPane(background);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}