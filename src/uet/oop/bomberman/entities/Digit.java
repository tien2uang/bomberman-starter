package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.graphics.Sprite.SCALED_FACTOR;

public class Digit {
    protected Image img;
    public static final double WIDTH = 8;
    public static final double LAST_DIGIT_OF_SCORE_X = 104;
    public static final double LIVES_X=24;
    public static final double MINUTE_X = 141;
    public static final double FIRST_DIGIT_OF_SECOND_X = 157;
    public static final double SECOND_DIGIT_OF_SECOND_X = 165;
    public static final double FLAME_X = 193;
    public static final double BOMB_X = 221;
    public static final double FIRST_DIGIT_OF_SPEED_X =249;
    public static final double SECOND_DIGIT_OF_SPEED_X=257;
    public static final double Y=9;
    public Digit(char a) {
        switch (a) {
            case 'p':
                img= Sprite.digit_10.getFxImage();
                break;
            case '0':
                img = Sprite.digit_0.getFxImage();
                break;
            case '1':
                img = Sprite.digit_1.getFxImage();
                break;
            case '2':
                img = Sprite.digit_2.getFxImage();
                break;
            case '3':
                img = Sprite.digit_3.getFxImage();
                break;
            case '4':
                img = Sprite.digit_4.getFxImage();
                break;
            case '5':
                img = Sprite.digit_5.getFxImage();
                break;
            case '6':
                img = Sprite.digit_6.getFxImage();
                break;
            case '7':
                img = Sprite.digit_7.getFxImage();
                break;
            case '8':
                img = Sprite.digit_8.getFxImage();
                break;
            case '9':
                img = Sprite.digit_9.getFxImage();
                break;
        }


    }

    public void render(GraphicsContext gc, double x) {
        gc.drawImage(img, (x) * Sprite.SCALED_FACTOR, Y * SCALED_FACTOR);
    }
}
