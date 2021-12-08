package uet.oop.bomberman.entities.enemies;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.Random;

public class Eye extends Enemy {


    public Eye(double x, double y) {
        super(x, y, 2, 300);
        img = NewSprite.red_eye.getFxImage();
        this.layerPower = 2.5;
        this.animate = 0;
        this.direction = 1;
        this._steps = 0;
    }

    @Override
    public void chooseImg() {
        if (direction == -1) img = NewSprite.movingSprite(NewSprite.eye_dead,getAnimate(), 200).getFxImage();
        if (direction == 0 || direction == 1 || direction == 2 || direction == 3) {
            img = NewSprite.movingSprite(NewSprite.EyeList,getAnimate(),45).getFxImage();
        }
    }


    @Override
    public void render(GraphicsContext gc) {
        double tempX = getXUnitBomber();
        double tempY = getYUnitBomber();
        double a = Math.abs(xUnit - tempX);
        double b = Math.abs(yUnit - tempY);

        chooseImg();
        if( a <= 4 && b <= 4) {
            gc.drawImage(img, (xUnit ) * 36, (yUnit + Game.INFO_HEIGHT) * 36 );
        }
    }


}
