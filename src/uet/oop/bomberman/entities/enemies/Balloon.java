package uet.oop.bomberman.entities.enemies;


import uet.oop.bomberman.graphics.Sprite;


public class Balloon extends Enemy {


    public Balloon(double x, double y) {
        super(x, y, 0.5, 100);
        img = Sprite.balloon_right.getFxImage();
        this.layerPower = 2.5;
        this.animate = 0;
        this.direction = 1;
        this._steps = 0;
    }

    @Override
    public void chooseImg() {
        if (direction == -1) img = Sprite.movingSprite(Sprite.balloonDeadList, getAnimate(), 51).getFxImage();
        if (direction == 0) img = Sprite.movingSprite(Sprite.BalloonLeftList,getAnimate(),30).getFxImage();
        if (direction == 1) img = Sprite.movingSprite(Sprite.BalloonRightList,getAnimate(),30).getFxImage();
        if (direction == 2) img = Sprite.movingSprite(Sprite.BalloonLeftList,getAnimate(),30).getFxImage();
        if (direction == 3) img = Sprite.movingSprite(Sprite.BalloonRightList,getAnimate(),30).getFxImage();
    }


}