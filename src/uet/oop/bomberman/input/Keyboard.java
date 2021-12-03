package uet.oop.bomberman.input;

import javafx.scene.Scene;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;

public class Keyboard {
    private static boolean up = false, down = false, left = false, right = false;
    private static boolean placeBomb;
    private static long press_last = 0;

    public static void keyboardHandle(Scene s) {
        s.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP:
                    up = true;
                    break;
                case DOWN:
                    down = true;
                    break;
                case LEFT:
                    left = true;
                    break;
                case RIGHT:
                    right = true;
                    break;
                case SPACE:
                    if(Game.isIsInGame()){
                        if (System.currentTimeMillis() - press_last > 200) {
                            placeBomb = true;
                            press_last = System.currentTimeMillis();
                        }
                    }
                    else{
                        Game.setIsInGame(true);
                        Board.startTime=Game.currentGameTime;
                    }

                    break;
            }
        });
        s.setOnKeyReleased(keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP:
                    up = false;
                    break;
                case DOWN:
                    down = false;
                    break;
                case LEFT:
                    left = false;
                    break;
                case RIGHT:
                    right = false;
                    break;
            }
        });
    }

    public static boolean isPlaceBomb() {
        return placeBomb;
    }

    public static void setNotPlaceBomb() {
        placeBomb = false;
    }

    public static void setPlaceBomb() {
        placeBomb = true;
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


}
