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
    public void update() {
        if (!isAlive) {
            die();
        } else {
            //System.out.println(xUnit + " " + yUnit + " ");
            animate();
            collide();
            int ra = new Random().nextInt(600);
            if (ra == 100 || ra == 200) calculateMove();

        }

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
        if (direction == -1) img = NewSprite.movingSprite(NewSprite.eye_dead,getAnimate(), 200).getFxImage();
        if (direction == 1) img = NewSprite.movingSprite(NewSprite.EyeList,getAnimate(),45).getFxImage();
    }

    @Override
    public int random1() {
        return new Random().nextInt(4);
    }


    @Override
    public void calculateMove() {
        int xa = 0, ya = 0;
        rand = random1();

        System.out.println(rand);
        if(rand == 2) ya += 2;  // 2 down
        if(rand == 3) ya -= 2; // 3 up
        if(rand == 0) xa -= 2; // 0 left
        if(rand == 1) xa += 2; // 1 right

        if(canMove(rand)) {
            move(xa, ya);
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
