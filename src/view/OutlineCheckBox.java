// Código para adicionar borda no texto da lista de ingredientes na preparação

package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicGraphicsUtils;

public class OutlineCheckBox extends JCheckBox {

    public OutlineCheckBox(String text) {
        super(text);
        setOpaque(false);
        setForeground(Color.WHITE);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setFont(getFont());
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // A PARTIR DAQUI, DESENHAMOS TUDO MANUALMENTE
        // Não usamos super.paintComponent(g) para evitar o desenho duplicado do texto

        // 1. Desenha o ícone da caixa de seleção
        Icon icon = UIManager.getIcon("CheckBox.icon");
        if (icon != null) {
            icon.paintIcon(this, g, 0, (getHeight() - icon.getIconHeight()) / 2);
        }

        // 2. Obtém o texto para desenhar
        String text = getText();
        FontMetrics fm = g2.getFontMetrics();

        // 3. Calcula a posição do texto
        int textX = getIconTextGap();
        if (icon != null) {
            textX += icon.getIconWidth();
        }
        int textY = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

        // 4. Desenha a borda preta
        g2.setColor(Color.BLACK);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    g2.drawString(text, textX + i, textY + j);
                }
            }
        }
        
        // 5. Desenha o texto principal
        g2.setColor(getForeground());
        g2.drawString(text, textX, textY);
        
        g2.dispose();
    }
}