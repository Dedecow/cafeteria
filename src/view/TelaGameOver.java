package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import engine.Jogo;

public class TelaGameOver extends JFrame{

    public TelaGameOver(Jogo jogo) {
        setTitle("Fim de Jogo");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel mensagem = new JLabel("Game Over! Seus pontos chegaram a 0");
        mensagem.setFont(new Font("Arial",Font.BOLD,16));
        add(mensagem, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        JButton btnReiniciar = new JButton("Reiniciar");
        JButton btnSair = new JButton("Sair");

        botoes.add(btnReiniciar);
        botoes.add(btnSair);
        add(botoes,BorderLayout.SOUTH);

        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                jogo.iniciarJogo();
            }
        });
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
