package uet.oop.bomberman.entities.enemies;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.characters.NewBomber;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.Random;

public class Enemy4 extends Enemy {


    public Enemy4(double x, double y) {
        super(x, y, 2, 300);
        img = NewSprite.balloon_right.getFxImage();
        this.layerPower = 2.5;
        this.animate = 0;
        this.direction = 0;
        this._steps = 0;
    }



    @Override
    public void update() {
        animate();
        /**
         double tempX = getXUnitBomber();
         double tempY = getYUnitBomber();

         if (Math.abs(tempX - (int) tempX) <= temp && Math.abs(tempY - (int) tempY) <= temp) {
         int a = (int) tempX;
         int b = (int) tempY;
         if (a == 4 || a == 6|| a == 10 || a == 12) {
         if (b == 1 || b == 5 || b == 9) {
         calculateMove();
         }
         }
         } */
        int ra = new Random().nextInt(500);
        if(ra == 100 || ra == 200) calculateMove();
    }

    public void move(double xa, double ya) {
        x += xa * 36;
        y += ya * 36;
        xUnit += xa ;
        yUnit += ya ;
    }

    @Override
    public void render(GraphicsContext gc) {

        chooseImg();
        gc.drawImage(img, (xUnit ) * 36, (yUnit + Game.INFO_HEIGHT) * 36 );
    }

    @Override
    public void chooseImg() {
        if (direction == 0) img = NewSprite.movingSprite(NewSprite.frog_Dead,getAnimate(),200).getFxImage();
        if (direction == 0) img = NewSprite.movingSprite(NewSprite.frogList,getAnimate(),45).getFxImage();
        if (direction == 1) img = NewSprite.movingSprite(NewSprite.frogMove,getAnimate(),45).getFxImage();
    }

    @Override
    public int random_() {
        return new Random().nextInt(4);
    }


    @Override
    public void calculateMove() {
        int xa = 0, ya = 0;
        rand = random_();

        System.out.println(rand);
        if(rand == 2) ya += 2;  // 2 down
        if(rand == 3) ya -= 2; // 3 up
        if(rand == 0) xa -= 2; // 0 left
        if(rand == 1) xa += 2; // 1 right

        if(canMove(rand)) {
            move(xa, ya);
            direction = 1;
        }
    }

    @Override
    public boolean canMove(int rand) {

        //left
        if (rand == 0) {
            return getAt(xUnit - 2, yUnit);
        }

        //right
        if (rand == 1) {
            return getAt(xUnit + 2, yUnit);
        }

        //down
        if (rand == 2) {
            return getAt(xUnit, yUnit + 2);
        }

        //up
        if (rand == 3) {
            return getAt(xUnit, yUnit - 2);
        }

        return false;
    }
}
