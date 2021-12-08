package uet.oop.bomberman.entities.enemies;

import uet.oop.bomberman.graphics.NewSprite;

import java.util.Random;

public class Oneal extends Enemy {



    public Oneal(double x, double y) {
        super(x, y, 1, 200);
        img = NewSprite.oneal_left.getFxImage();
        this.layerPower = 2.5;
        this.animate = 0;
        this.direction = 1;
        this._steps = 0;
    }

    @Override
    public void chooseImg() {
        if (direction == -1) img = NewSprite.movingSprite(NewSprite.oneal_dead, getAnimate(), 200).getFxImage();
        if(direction == 0 || direction == 1 || direction == 2 || direction == 3) {
            if(OnealMove) {
                img = NewSprite.movingSprite(NewSprite.OnealList,getAnimate(),30).getFxImage();
            } else {
                img = NewSprite.oneal_left.getFxImage();
            }
        }
    }

    @Override
    public int random1() {
        double tempX = getXUnitBomber();
        if(tempX < xUnit)
            return 0;
        else if(tempX > xUnit)
            return 1;

        return -2;
    }

    @Override
    public int random2() {
        double tempY = getYUnitBomber();
        if(tempY < yUnit)
            return 0;
        else if (tempY > yUnit)
            return 1;
        return -2;
    }

    public void calculateMove() {

        double xa = 0, ya = 0;
        if(_steps <= 0){
            rand = random1();
            _steps = MAX_STEPS;
        }

        if(rand == 0) xa -= speed; // left
        if(rand == 1) xa += speed; // right

        if(canMove(rand)) {
            _steps -= speed;
            direction = rand;
            move(xa, ya);
            OnealMove  = true;
        } else {
            _steps = 0;
            OnealMove = false;
        }


        if (Math.abs(xUnit - Math.round(xUnit)) <= temp) {
            double tempX = Math.round(xUnit);
            a = random2();

            if (tempX % 2 == 0 && a == 0) {
                up();
            }
            if (tempX % 2 == 0 && a == 1) {
                down();
            }
        }

    }

}
