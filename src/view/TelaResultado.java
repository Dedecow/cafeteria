package view;

import engine.Jogo;
import javax.swing.*;
import java.awt.*;

public class TelaResultado extends JFrame {
    public TelaResultado(Jogo jogo, boolean correto, int pontos) {
        setTitle("Resultado");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblMensagem = new JLabel(correto ? "✅ Sucesso!" : "❌ Errou!");
        JLabel lblPontos = new JLabel("Pontuação: " + pontos);

        JButton btnProximo = new JButton("Próximo Cliente");
        btnProximo.addActionListener(e -> {
            dispose();
            jogo.gerarPedido();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.add(lblMensagem);
        panel.add(lblPontos);
        panel.add(btnProximo);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
