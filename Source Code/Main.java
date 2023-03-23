import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

class PlayMusic {
    static void playMusic(String filename, boolean repeat) {
        try {
            ClassLoader classLoader = PlayMusic.class.getClassLoader();
            File soundFile = new File(classLoader.getResource(filename).getFile());
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            if (repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            clip.start();

            while (!clip.isRunning())
                Thread.sleep(10);
            while (clip.isRunning())
                Thread.sleep(10);

            clip.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}