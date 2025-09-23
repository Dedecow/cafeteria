package view;

import data.Cliente;
import engine.Jogo;
import java.awt.*;
import javax.swing.*;

public class TelaJogo extends JFrame {
    public TelaJogo(Jogo jogo, Cliente cliente) {
        setTitle("JavaBeans - Pedido do Cliente");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblPedido = new JLabel(cliente.getNome() + " diz: " + cliente.comportamento());
        JButton btnAcertar = new JButton("Escolher ingredientes corretos");
        JButton btnErrar = new JButton("Errar ingredientes");

        btnAcertar.addActionListener(e -> {
            dispose();
            jogo.processarPedido(true);
        });

        btnErrar.addActionListener(e -> {
            dispose();
            jogo.processarPedido(false);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.add(lblPedido);
        panel.add(btnAcertar);
        panel.add(btnErrar);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
