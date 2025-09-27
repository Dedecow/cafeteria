package view;

import data.Cliente;
import data.MenuItem;
import engine.Jogo;
import java.awt.*;
import javax.swing.*;

public class TelaJogo extends JFrame {
    
    public TelaJogo(Jogo jogo, Cliente cliente, MenuItem pedido) {
        setTitle("JavaBeans - Atendendo Cliente");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BackgroundPanel background = new BackgroundPanel("/assets/cafe_telajogo.jpg");
        background.setLayout(new BorderLayout());

        JLabel lblCliente = new JLabel(cliente.getNome() + " pediu: " + pedido.getName(), SwingConstants.CENTER);
        lblCliente.setFont(new Font("Arial", Font.BOLD, 18));
        lblCliente.setForeground(Color.WHITE);
        
        JLabel lblComportamento = new JLabel(cliente.comportamento(), SwingConstants.CENTER);
        lblComportamento.setFont(new Font("Arial", Font.ITALIC, 14));
        lblComportamento.setForeground(Color.YELLOW);

        JPanel botoes = new JPanel();
        botoes.setOpaque(false);
        
        JButton btnPreparo = new JButton("Iniciar Preparo");
        btnPreparo.addActionListener(e -> {
            dispose();

            jogo.iniciarPreparo();
        });
        
        JButton btnErrar = new JButton("Errar Pedido");
        btnErrar.addActionListener(e -> {
            dispose();
            jogo.processarPedido(false);
        });
        
        botoes.add(btnPreparo);
        botoes.add(btnErrar);

        JPanel centro = new JPanel(new GridLayout(2, 1));
        centro.setOpaque(false);
        centro.add(lblCliente);
        centro.add(lblComportamento);

        background.add(centro, BorderLayout.CENTER);
        background.add(botoes, BorderLayout.SOUTH);

        setContentPane(background);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}