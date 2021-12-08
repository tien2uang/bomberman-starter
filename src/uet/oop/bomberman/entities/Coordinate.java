package uet.oop.bomberman.entities;

import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.Sprite;

public class Coordinate {
    public static double pixelToTile(double i){
        return i/ Sprite.SCALED_SIZE;
    }
    public static double tileToPixel(double i){
        return i* Sprite.SCALED_SIZE;
    }
    public static double canvasToBoardTileY(double i){
        return i- Game.INFO_HEIGHT;
    }
}
