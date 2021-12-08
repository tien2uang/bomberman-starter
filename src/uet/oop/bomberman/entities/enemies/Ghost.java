package uet.oop.bomberman.entities.enemies;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.Sprite;

public class Ghost extends Enemy {



    public Ghost(double x, double y) {
        super(x, y, 1, 400);
        img = Sprite.ghost_down.getFxImage();
        this.layerPower = 3;
        this.animate = 0;
        this.direction = 1;
        this._steps = 0;
    }

    @Override
    public void render(GraphicsContext gc) {
        double tempX = getXUnitBomber();
        double tempY = getYUnitBomber();
        double a = Math.abs(xUnit - tempX);
        double b = Math.abs(yUnit - tempY);

        chooseImg();

        if (isAlive) {
            if( xUnit >= 1 && xUnit <= 8 && yUnit >= 1 && yUnit <= 5
                    || xUnit >= 11 && xUnit <= 14 && yUnit >= 1 && yUnit <= 5
                    || xUnit >= 5 && xUnit <= 11 && yUnit >= 8 && yUnit <= 11
                    || a <= 3 && b <= 3) {
                gc.drawImage(img, (xUnit ) * 36, (yUnit + Game.INFO_HEIGHT) * 36 );
            }
        }
        else{
            gc.drawImage(img, (xUnit ) * 36, (yUnit + Game.INFO_HEIGHT) * 36 );
        }
    }

    @Override
    public void chooseImg() {
        if (direction == -1) img = Sprite.movingSprite(Sprite.ghost_dead, getAnimate(),51).getFxImage();
        if (direction == 0) img = Sprite.movingSprite(Sprite.GhostLeftList,getAnimate(),20).getFxImage();
        if (direction == 1) img = Sprite.movingSprite(Sprite.GhostRightList,getAnimate(),30).getFxImage();
        if (direction == 2) img = Sprite.movingSprite(Sprite.GhostDownList,getAnimate(),30).getFxImage();
        if (direction == 3) img = Sprite.movingSprite(Sprite.GhostUpList,getAnimate(),30).getFxImage();
    }


}
