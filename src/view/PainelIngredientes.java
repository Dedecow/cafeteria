package view;

import data.Cardapio;
import data.Ingrediente;
import data.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class PainelIngredientes extends JPanel {
    private MenuItem pedido;
    private List<JCheckBox> checkBoxes = new ArrayList<>();

    public PainelIngredientes(MenuItem pedido) {
        this.pedido = pedido;
        
        // Altera o layout principal para BorderLayout
        setLayout(new BorderLayout());
        setOpaque(false);

        // Painel para a lista de ingredientes com GridLayout de 2 colunas
        JPanel painelLista = new JPanel();
        painelLista.setLayout(new GridLayout(0, 2));
        painelLista.setOpaque(false);
        
        List<Ingrediente> todos = Cardapio.getTodosIngredientes();

        for (Ingrediente ing : todos) {
            JCheckBox cb = new OutlineCheckBox(ing.getName());
            checkBoxes.add(cb);
            painelLista.add(cb);
        }
        
        // Cria o botão de receitas
        JButton btnReceitas = new JButton("Receitas");
        btnReceitas.addActionListener(e -> {
            // Lógica para mostrar as receitas em uma caixa de diálogo
            String receitas = "<html>" +
                              "<b><u>Receitas do Café:</u></b><br><br>" +
                              "<b>Café preto:</b> Café e Água<br>" +
                              "<b>Café Latte:</b> Café, Água e Leite<br>" +
                              "<b>Cappuccino:</b> Café, Leite e Cacau<br>" +
                              "<b>Matcha:</b> Água e Matcha" +
                              "</html>";
            
            // O componente pai precisa ser uma janela, então usamos SwingUtilities.getWindowAncestor
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), receitas, "Receitas", JOptionPane.INFORMATION_MESSAGE);
        });

        // Adiciona os painéis e o botão ao layout principal
        add(painelLista, BorderLayout.CENTER); // Adiciona a lista de ingredientes no centro
        
        // Cria um painel para centralizar o botão
        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotao.setOpaque(false);
        painelBotao.add(btnReceitas);
        
        add(painelBotao, BorderLayout.SOUTH); // Adiciona o painel do botão na parte de baixo
    }

    public boolean validarSelecao() {
        // ... o restante do código
        List<String> escolhidos = checkBoxes.stream()
                .filter(JCheckBox::isSelected)
                .map(AbstractButton::getText)
                .collect(Collectors.toList());

        List<String> corretos = pedido.getIngredientes().stream()
                .map(Ingrediente::getName)
                .collect(Collectors.toList());

        return new HashSet<>(escolhidos).equals(new HashSet<>(corretos));
    }
}