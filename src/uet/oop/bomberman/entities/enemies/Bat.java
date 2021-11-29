package uet.oop.bomberman.entities.enemies;

import uet.oop.bomberman.graphics.NewSprite;

public class Bat extends Enemy {
    public Bat(double x, double y) {
        super(x, y);
        img = NewSprite.balloon_right.getFxImage();
        this.layerPower = 3;
        this.animate = 0;
        this.direction = 1;
        this._steps = 0;
    }

    @Override
    public void chooseImg() {
        if (direction == 0) img = NewSprite.movingSprite(NewSprite.BatLeftList,getAnimate(),30).getFxImage();
        if (direction == 1) img = NewSprite.movingSprite(NewSprite.BatRightList,getAnimate(),30).getFxImage();
        if (direction == 2) img = NewSprite.movingSprite(NewSprite.BatDownList,getAnimate(),30).getFxImage();
        if (direction == 3) img = NewSprite.movingSprite(NewSprite.BatUpList,getAnimate(),30).getFxImage();
    }
}
