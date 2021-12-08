package uet.oop.bomberman.entities.enemies;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.Random;

public class Ghost extends Enemy {



    public Ghost(double x, double y) {
        super(x, y, 1, 400);
        img = NewSprite.ghost_down.getFxImage();
        this.layerPower = 5;
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
        if( xUnit >= 1 && xUnit <= 8 && yUnit >= 1 && yUnit <= 5
                || xUnit >= 11 && xUnit <= 14 && yUnit >= 1 && yUnit <= 5
                || xUnit >= 5 && xUnit <= 11 && yUnit >= 8 && yUnit <= 11
                || a <= 3 && b <= 3) {
            gc.drawImage(img, (xUnit ) * 36, (yUnit + Game.INFO_HEIGHT) * 36 );
        }
    }

    @Override
    public void chooseImg() {
        if (direction == -1) img = NewSprite.movingSprite(NewSprite.ghost_dead, getAnimate(),200).getFxImage();
        if (direction == 0) img = NewSprite.movingSprite(NewSprite.GhostLeftList,getAnimate(),20).getFxImage();
        if (direction == 1) img = NewSprite.movingSprite(NewSprite.GhostRightList,getAnimate(),30).getFxImage();
        if (direction == 2) img = NewSprite.movingSprite(NewSprite.GhostDownList,getAnimate(),30).getFxImage();
        if (direction == 3) img = NewSprite.movingSprite(NewSprite.GhostUpList,getAnimate(),30).getFxImage();
    }

    @Override
    public int random1() {
        return new Random().nextInt(4);
    }


    @Override
    public void calculateMove() {
        int xa = 0, ya = 0;
        if(_steps <= 0){
            rand = random1();
            _steps = MAX_STEPS;
        }

        if(rand == 2) ya++;  // 2 down
        if(rand == 3) ya--; // 3 up
        if(rand == 0) xa--; // 0 left
        if(rand == 1) xa++; // 1 right

        if(canMove(rand)) {
            _steps -= speed;
            direction = rand;
            move(xa, ya);
        } else {
            _steps = 0;
        }
    }

    @Override
    public boolean canMove(int rand) {

        //left
        if (rand == 0) {
            if (xUnit < 2) return false;
        }

        //right
        if (rand == 1) {
            if (xUnit > 14) return false;
        }

        //down
        if (rand == 2) {
            if (yUnit > 11) return false;
        }

        //up
        if (rand == 3) {
            if (yUnit < 1) return false;
        }

        return true;
    }
}
