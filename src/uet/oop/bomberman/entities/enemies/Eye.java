package uet.oop.bomberman.entities.enemies;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.Sprite;

public class Eye extends Enemy {


    public Eye(double x, double y) {
        super(x, y, 2, 300);
        img = Sprite.red_eye.getFxImage();
        this.layerPower = 2.5;
        this.animate = 0;
        this.direction = 1;
        this._steps = 0;
    }

    @Override
    public void chooseImg() {
        if (direction == -1) img = Sprite.movingSprite(Sprite.eye_dead,getAnimate(), 51).getFxImage();
        if (direction == 0 || direction == 1 || direction == 2 || direction == 3) {
            img = Sprite.movingSprite(Sprite.EyeList,getAnimate(),45).getFxImage();
        }
    }


    @Override
    public void render(GraphicsContext gc) {
        double tempX = getXUnitBomber();
        double tempY = getYUnitBomber();
        double a = Math.abs(xUnit - tempX);
        double b = Math.abs(yUnit - tempY);

        chooseImg();
        if (isAlive) {
            if( a <= 4 && b <= 4) {
                gc.drawImage(img, (xUnit ) * 36, (yUnit + Game.INFO_HEIGHT) * 36 );
            }
        }
        else{
            gc.drawImage(img, (xUnit ) * 36, (yUnit + Game.INFO_HEIGHT) * 36 );
        }
    }


}
