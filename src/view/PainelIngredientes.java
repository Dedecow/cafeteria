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
        setLayout(new GridLayout(0, 2));
        setOpaque(false);

        // Lista com todos os ingredientes possíveis
        List<Ingrediente> todos = Cardapio.getTodosIngredientes();

        for (Ingrediente ing : todos) {
            JCheckBox cb = new JCheckBox(ing.getName());
            cb.setOpaque(false);
            checkBoxes.add(cb);
            add(cb);
        }
    }

    /**
     * Retorna true se o jogador escolheu exatamente os ingredientes corretos.
     */
    public boolean validarSelecao() {
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
