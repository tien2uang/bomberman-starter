package uet.oop.bomberman.entities.enemies;

import uet.oop.bomberman.graphics.Sprite;

public class Bat extends Enemy {
    public Bat(double x, double y) {
        super(x, y, 1, 200);
        img = Sprite.balloon_right.getFxImage();
        this.layerPower = 3;
        this.animate = 0;
        this.direction = 1;
        this._steps = 0;
    }

    @Override
    public void chooseImg() {
        if (direction == -1) img = Sprite.movingSprite(Sprite.bat_dead, getAnimate(), 51).getFxImage();
        if (direction == 0) img = Sprite.movingSprite(Sprite.BatLeftList,getAnimate(),30).getFxImage();
        if (direction == 1) img = Sprite.movingSprite(Sprite.BatRightList,getAnimate(),30).getFxImage();
        if (direction == 2) img = Sprite.movingSprite(Sprite.BatDownList,getAnimate(),30).getFxImage();
        if (direction == 3) img = Sprite.movingSprite(Sprite.BatUpList,getAnimate(),30).getFxImage();
    }

}
