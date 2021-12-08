package uet.oop.bomberman.gameplay;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Digit;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.gameplay.Board.speedItemTime;

public class Info extends Game {
    public static final double INFO_WIDTH = 17;
    public static final double INFO_HEIGHT = 2;
    public static int score = 0;
    public static int time;
    public static int bombItem = 0;
    public static int flameItem = 0;
    public static int speedItem = 8;
    public static int lives = 2;
    public static int animate;
    private static Image img = Sprite.startBar.getFxImage();

    public static void update() {

        updateLives();
        updateScore();
        updateTime();
        updateItems();
        if (Game.isIsInGame()) {
            animate = 0;
            img = Sprite.inGameBar.getFxImage();
        } else {
            img = Sprite.movingSprite(Sprite.startBarList, animate, 75).getFxImage();
            animate++;
        }


    }

    public static void render() {
        gc.drawImage(img, 0, 0);
        if (Game.isIsInGame()) {
            preRender();
            renderScore();
            renderTime();
            renderLives();
            renderItems();
        } else {
            renderLives();
        }

    }

    private static void updateScore() {
        score = Game.gameScore + Board.levelScore;
    }

    private static void updateTime() {
        time = (int) Board.levelTime;
    }
    private static void updateLives() {
        lives =  Board.lives;
    }
    private static void updateItems(){
        bombItem=Board.bombItem_quantity;
        flameItem=Board.flameItem_quantity;
        speedItem= speedItemTime;
    }

    public static void reset() {

    }

    public static void renderScore() {
        String temp = Integer.toString(score);
        for (int i = temp.length() - 1; i >= 0; i--) {
            Digit digit = new Digit(temp.charAt(i));
            digit.render(gc, Digit.LAST_DIGIT_OF_SCORE_X - (double) (temp.length() - 1 - i) * Digit.WIDTH);
        }
    }

    public static void renderTime() {
        int min = time / 60;
        int seconds = time % 60;
        String temp = Integer.toString(min);
        Digit digit = new Digit(temp.charAt(0));
        digit.render(gc, Digit.MINUTE_X);
        temp = Integer.toString(seconds);
        if (temp.length() == 2) {
            Digit firstSecondDigit = new Digit(temp.charAt(0));
            Digit secondSecondDigit = new Digit(temp.charAt(1));
            firstSecondDigit.render(gc, Digit.FIRST_DIGIT_OF_SECOND_X);
            secondSecondDigit.render(gc, Digit.SECOND_DIGIT_OF_SECOND_X);
        } else if (temp.length() == 1) {
            Digit firstSecondDigit = new Digit('0');
            Digit secondSecondDigit = new Digit(temp.charAt(0));
            firstSecondDigit.render(gc, Digit.FIRST_DIGIT_OF_SECOND_X);
            secondSecondDigit.render(gc, Digit.SECOND_DIGIT_OF_SECOND_X);
        }
    }

    public static void preRender() {
        Digit digit = new Digit('p');
        digit.render(gc, Digit.LIVES_X);

        for (int i = 7; i >= 0; i--) {
            digit.render(gc, Digit.LAST_DIGIT_OF_SCORE_X - (double) (7 - i) * Digit.WIDTH);
        }
        gc.drawImage(Sprite.clock.getFxImage(),
                Digit.MINUTE_X * Sprite.SCALED_FACTOR, Digit.Y * Sprite.SCALED_FACTOR);

        digit.render(gc, Digit.MINUTE_X);
        digit.render(gc, Digit.FIRST_DIGIT_OF_SECOND_X);
        digit.render(gc, Digit.SECOND_DIGIT_OF_SECOND_X);

        digit.render(gc, Digit.FLAME_X);
        digit.render(gc, Digit.BOMB_X);

        digit.render(gc, Digit.FIRST_DIGIT_OF_SPEED_X);
        digit.render(gc, Digit.SECOND_DIGIT_OF_SPEED_X);
    }

    public static void renderLives() {
        String temp = Integer.toString(lives);
        Digit digit = new Digit(temp.charAt(0));
        digit.render(gc, Digit.LIVES_X);
    }

    public static void renderItems() {
        String temp = Integer.toString(flameItem);
        Digit digit = new Digit(temp.charAt(0));
        digit.render(gc, Digit.FLAME_X);

        temp = Integer.toString(bombItem);
        digit = new Digit(temp.charAt(0));
        digit.render(gc, Digit.BOMB_X);

        temp = Integer.toString(speedItem);
        if (temp.length() == 1) {
            digit = new Digit('0');
            digit.render(gc, Digit.FIRST_DIGIT_OF_SPEED_X);
            digit = new Digit(temp.charAt(0));
            digit.render(gc, Digit.SECOND_DIGIT_OF_SPEED_X);
        } else {
            digit = new Digit(temp.charAt(0));
            digit.render(gc, Digit.FIRST_DIGIT_OF_SPEED_X);
            digit = new Digit(temp.charAt(1));
            digit.render(gc, Digit.SECOND_DIGIT_OF_SPEED_X);
        }

    }

}
