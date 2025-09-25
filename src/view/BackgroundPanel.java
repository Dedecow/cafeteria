package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;

    public BackgroundPanel(String imagePath) {
        carregarImagem(imagePath);
    }

    private void carregarImagem(String imagePath) {
        try {
            // Primeiro tenta pelo classpath (dentro do JAR)
            URL imageUrl = getClass().getResource(imagePath);
            if (imageUrl != null) {
                backgroundImage = ImageIO.read(imageUrl);
                System.out.println("Imagem carregada do classpath: " + imagePath);
            } else {
                // Tenta pelo sistema de arquivos (desenvolvimento)
                File file = new File(imagePath);
                if (file.exists()) {
                    backgroundImage = ImageIO.read(file);
                    System.out.println("Imagem carregada do filesystem: " + imagePath);
                } else {
                    // Tenta na pasta assets (fallback)
                    File assetsFile = new File("assets/" + imagePath);
                    if (assetsFile.exists()) {
                        backgroundImage = ImageIO.read(assetsFile);
                        System.out.println("Imagem carregada da pasta assets: " + imagePath);
                    } else {
                        System.err.println("Imagem não encontrada: " + imagePath);
                        // Cria uma imagem padrão para evitar erro
                        backgroundImage = criarImagemPadrao();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar imagem: " + imagePath + " -> " + e.getMessage());
            backgroundImage = criarImagemPadrao();
        }
    }

    private BufferedImage criarImagemPadrao() {
        // Cria uma imagem colorida padrão caso a imagem não seja encontrada
        BufferedImage img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(new Color(240, 240, 240));
        g2d.fillRect(0, 0, 800, 600);
        g2d.setColor(Color.BLUE);
        g2d.drawString("Imagem não encontrada", 50, 50);
        g2d.dispose();
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}