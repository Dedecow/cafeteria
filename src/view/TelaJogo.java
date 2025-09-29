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

        // USE A CLASSE OutlineLabel AQUI para os dois textos
        
        OutlineLabel lblCliente = new OutlineLabel(cliente.getNome() + " pediu: " + pedido.getName());
        lblCliente.setFont(new Font("Arial", Font.BOLD, 18));
        
        OutlineLabel lblComportamento = new OutlineLabel(cliente.comportamento());
        lblComportamento.setFont(new Font("Arial", Font.PLAIN, 20));

        // As linhas para adicionar os botões e os rótulos no painel continuam as mesmas
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
