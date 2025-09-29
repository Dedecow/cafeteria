// pacote para controlar a musica do jogo

package engine;

import java.io.IOException;
import javax.sound.sampled.*;

public class MusicPlayer implements Runnable {

    private String filePath;
    private Clip clip;
    private boolean isLooping = true; 

    public MusicPlayer(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            // Usa getClass().getResourceAsStream() para carregar o arquivo 
            // como um recurso, ideal se o arquivo estiver dentro do JAR.
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                getClass().getResourceAsStream(filePath)
            );
            
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);

            // Inicia o loop da música
            if (isLooping) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | NullPointerException e) {
            // Adicionei NullPointerException para capturar falha ao encontrar o recurso
            System.err.println("Erro ao carregar ou tocar o áudio. Verifique o caminho do arquivo: " + filePath);
            e.printStackTrace();
        }
    }
    
    // Método para parar a música
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}