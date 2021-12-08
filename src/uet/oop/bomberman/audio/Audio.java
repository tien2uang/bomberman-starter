package uet.oop.bomberman.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class Audio {
    //public static MediaPlayer sound;
    public static String bombExplosion = "res/audio16bit/Bomb Explodes.wav";
    public static String bomberDied = "res/audio16bit/Bomberman Dies.wav";
    public static String enemyDied = "res/audio16bit/Enemy Dies.wav";
    public static String itemGet = "res/audio16bit/Item Get.wav";
    public static String placeBomb = "res/audio16bit/Place Bomb-1.wav";
    public static String soundEndGame = "res/audioMP3/05_Stage Complete.mp3";
    static MediaPlayer soundBackground = new MediaPlayer(new Media(new File("res/audioMP3/Background.mp3").toURI().toString()));

    public static void playSound(String path)
    {
        try {
            MediaPlayer sound = new MediaPlayer(new Media(new File(path).toURI().toString()));
            sound.setVolume(0.8);
            sound.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void playBackground() {
        soundBackground.setVolume(0.5);
        soundBackground.play();
    }

    public static void stopBackground() {
        soundBackground.stop();
    }







}
