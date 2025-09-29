// Código para adicionar borda no texto de todo o jogo

package view;

import java.awt.*;
import javax.swing.*;

public class OutlineLabel extends JLabel {
    private Color outlineColor = Color.BLACK; // Cor padrão da borda
    private Color textColor = Color.WHITE;    // Cor padrão do texto
    
    // Construtor que recebe o texto
    public OutlineLabel(String text) {
        super(text, SwingConstants.CENTER); // Chama o construtor do JLabel
    }
    
    // Construtor sem argumentos
    public OutlineLabel() {
        this("");
    }
    
    // Métodos para definir as cores
    public void setOutlineColor(Color color) {
        this.outlineColor = color;
    }
    
    public void setTextColor(Color color) {
        this.textColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setFont(getFont());
        // Ajuda a suavizar as bordas do texto
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        String text = getText();
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = (getHeight() + fm.getAscent()) / 2 - 2;

        // Desenha a borda preta ao redor do texto
        g2.setColor(outlineColor);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    g2.drawString(text, x + i, y + j);
                }
            }
        }
        
        // Desenha o texto principal por cima da borda
        g2.setColor(textColor);
        g2.drawString(text, x, y);

        g2.dispose();
    }
}
