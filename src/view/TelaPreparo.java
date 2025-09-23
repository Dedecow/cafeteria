package view;
import data.Cliente;
import data.Ingrediente;
import data.MenuItem;
import engine.Jogo;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class TelaPreparo extends  JFrame{
    private int etapaAtual = 0;
    private final List<Ingrediente> ingredientes;
    private final MenuItem item;

    public TelaPreparo(Jogo jogo, Cliente clienteAtual, MenuItem item) {
        this.item = item;
        this.ingredientes = item.getIngredientes();

        setTitle("Preparando: "+ item.getName());
        setSize(600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new BorderLayout());

        JLabel lblEtapa = new JLabel("Pegue "+ ingredientes.get(etapaAtual).getName(),
                SwingConstants.CENTER);
        lblEtapa.setFont(new Font("Arial",Font.BOLD,18));
        painel.add(lblEtapa, BorderLayout.CENTER);

        JButton btnProximo = new JButton("Proxima Etapa");
        btnProximo.setFont(new Font("Arial",Font.BOLD,18));
        painel.add(btnProximo, BorderLayout.SOUTH);

        btnProximo.addActionListener(e -> {
            etapaAtual++;
            if (etapaAtual < ingredientes.size()) {
                lblEtapa.setText("Adicione "+ ingredientes.get(etapaAtual).getName());

            }else {
                JOptionPane.showMessageDialog(this,
                        item.getName() + " Preparado com sucesso!");
                dispose();
                jogo.processarPedido(true);
            }
        });
        
        add(painel);
        setVisible(true);
    }
}