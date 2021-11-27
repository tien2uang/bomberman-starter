package uet.oop.bomberman.input;

import javafx.scene.Scene;

public class Keyboard {
    private static boolean up = false, down = false, left = false, right = false, placeBomb = false;

    private static boolean inverted = false;

    public static void keyboardHandle(Scene s) {
        s.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP:
                    if (!inverted){
                        up = true;
                    } else {
                        down = true;
                    }
                    break;
                case DOWN:
                    if (!inverted) {
                        down = true;
                    } else {
                        up = true;
                    }
                    break;
                case LEFT:
                    if (!inverted) {
                        left = true;
                    } else {
                        right = true;
                    }
                    break;
                case RIGHT:
                    if (!inverted) {
                        right = true;
                    } else {
                        left = true;
                    }
                    break;
                case SPACE:
                    placeBomb = true;
                    break;
            }
        });
        s.setOnKeyReleased(keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP:
                    if (!inverted){
                        up = false;
                    } else {
                        down = false;
                    }
                    break;
                case DOWN:
                    if (!inverted) {
                        down = false;
                    } else {
                        up = false;
                    }
                    break;
                case LEFT:
                    if (!inverted) {
                        left = false;
                    } else {
                        right = false;
                    }
                    break;
                case RIGHT:
                    if (!inverted) {
                        right = false;
                    } else {
                        left = false;
                    }
                    break;
            }
        });
    }


    public static boolean isUp() {
        return up;
    }

    public static boolean isDown() {
        return down;
    }

    public static boolean isLeft() {
        return left;
    }

    public static boolean isRight() {
        return right;
    }

    public static boolean isPlaceBomb() {
        return placeBomb;
    }
    public static void setPlaceBomb() {
        placeBomb = false;
    }
}
