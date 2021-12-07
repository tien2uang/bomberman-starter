package uet.oop.bomberman.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Audio {
    public static String bombExplosion = "res/audio16bit/Bomb Explodes.wav";
    public static String bomberDied = "res/audio16bit/Bomberman Dies.wav";
    public static String enemyDied = "res/audio16bit/Enemy Dies.wav";
    public static String itemGet = "res/audio16bit/Item Get.wav";
    public static String placeBomb = "res/audio16bit/Place Bomb.wav";

    public static void playSound(String sound) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(sound));
            AudioStream audioStream = new AudioStream(fileInputStream);
            AudioPlayer.player.start(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
