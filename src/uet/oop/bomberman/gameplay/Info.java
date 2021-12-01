package uet.oop.bomberman.gameplay;

import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import uet.oop.bomberman.graphics.NewSprite;

public class Info extends Game{
    public static final double INFO_WIDTH = 17;
    public static final double INFO_HEIGHT = 1;
    public static double score=0;
    public static double time ;

    public static void update() {
        time=250-Game.currentGameTime;

    }
    public static void render(){

        gc.drawImage(NewSprite.inGameBar.getFxImage(),0,0);
    }
    public static void updateScore(){

    }
    public static void updateTime(){

    }
    public static void reset(){

    }
}
