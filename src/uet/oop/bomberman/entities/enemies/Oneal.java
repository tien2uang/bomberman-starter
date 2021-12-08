package uet.oop.bomberman.entities.enemies;

import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.Sprite;

public class Oneal extends Enemy {

    public boolean OnealMove = true;


    public Oneal(double x, double y) {
        super(x, y, 1, 200);
        img = Sprite.oneal_left.getFxImage();
        this.layerPower = 2.5;
        this.animate = 0;
        this.direction = 1;
        this._steps = 0;
    }

    @Override
    public void chooseImg() {
        if (direction == -1) img = Sprite.movingSprite(Sprite.oneal_dead, getAnimate(), 51).getFxImage();
        if(direction == 0 || direction == 1 || direction == 2 || direction == 3) {
            if(OnealMove) {
                img = Sprite.movingSprite(Sprite.OnealList,getAnimate(),30).getFxImage();
            } else {
                img = Sprite.oneal_left.getFxImage();
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

    @Override
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

    @Override
    public void up() {
        if (step_Up <= 0) {
            isMovingUP = false;
            step_Up = MAX_UP;
        } else isMovingUP = true;

        if (canUp(xUnit, yUnit - temp) && isMovingUP) {
            direction = 3;
            move(0, -speed);
            step_Up--;
            OnealMove = true;
        } else {
            isMovingUP = false;
            OnealMove = false;
            if (Math.abs(yUnit - Math.round(yUnit)) <= temp) {
                yUnit = Math.round(yUnit);
                this.y = (yUnit + Game.INFO_HEIGHT) * Sprite.SCALED_SIZE;
            }
        }
    }

    @Override
    public void down() {
        if (step_Down <= 0) {
            isMovingDOWN = false;
            step_Down = MAX_DOWN;
        } else isMovingDOWN = true;

        if (canDown(xUnit, yUnit + 1 + temp) && isMovingDOWN) {
            direction = 2;
            move(0, speed);
            step_Down--;
            OnealMove = true;
        } else {
            isMovingDOWN = false;
            OnealMove = false;
            if (Math.abs(yUnit - Math.round(yUnit)) <= temp) {
                yUnit = Math.round(yUnit);
                this.y = (yUnit + Game.INFO_HEIGHT) * Sprite.SCALED_SIZE;
            }
        }
    }

}
