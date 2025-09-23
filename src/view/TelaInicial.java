package view;

import engine.Jogo;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class TelaInicial extends JFrame {
    public TelaInicial(Jogo jogo) {
        setTitle("JavaBeans - Start");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        try {
            URL imageUrl = getClass().getResource("/assets/cafe_background.png");
            if (imageUrl != null) {
                ImageIcon originalIcon = new ImageIcon(imageUrl);
                Image img = originalIcon.getImage();
                Image scaledImg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
                background.setIcon(new ImageIcon(scaledImg));
            } else {
                System.err.println("Imagem de fundo não encontrada em: /assets/cafe_background.png");
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem de fundo: " + e.getMessage());
        }

        this.setContentPane(background);

        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setOpaque(false);


        JButton btnIniciar = new JButton("<html><div style='text-align: center;'>Iniciar Jogo</div></html>");
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 20));
        btnIniciar.setForeground(new Color(139, 69, 19));
        btnIniciar.setBackground(new Color(255, 255, 255, 150));
        btnIniciar.setBorderPainted(false);
        btnIniciar.setFocusPainted(false);
        
        btnIniciar.addActionListener(e -> {
            dispose();
            jogo.gerarPedido();
            jogo.proximoPedido();
        });

        contentPane.add(btnIniciar);
        background.setLayout(new BorderLayout());
        background.add(contentPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
