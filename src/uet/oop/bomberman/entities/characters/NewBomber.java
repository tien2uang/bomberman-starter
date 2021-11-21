package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.Keyboard;

public class NewBomber extends Character {

    public int direction;
    private boolean isMoving;
    public static double speed;
    private NewSprite currentSprite;

    public NewBomber(double x, double y) {
        super(x, y);
        this.direction = 4;
        this.img = NewSprite.player_down_1.getFxImage();
        this.currentSprite = NewSprite.player_down_1;
        this.animate = 0;
        this.isMoving = false;
    }

    public void move(double p, double q) {


        if (canMove(x, y + q)) {
            y += q;
        }

        if (canMove(x + p, y)) {
            x += p;
        }
    }

    public void calculateMove() {
        double X = 0, Y = 0;
        if (Keyboard.isLeft()) {
            direction = 1;
            X = -1.6 ;
         //   System.out.println("X:" + X);
            animate();
        }
        if (Keyboard.isRight()) {
            direction = 2;
            X = 1.6 ;
          //  System.out.println("X:" + X);
            animate();
        }
        if (Keyboard.isUp()) {
            direction = 3;
            Y = -1.6 ;
        //    System.out.println("Y: " + Y);
            animate();
        }
        if (Keyboard.isDown()) {
            direction = 4;
            Y = 1.6 ;
          //  System.out.println("Y: " + Y);
            animate();
        }

        if (X != 0 || Y != 0) {
           // System.out.println("YES");
            move(X, Y);
        }

    }

    public boolean isMoving() {
        if (Keyboard.isLeft() || Keyboard.isRight() || Keyboard.isDown() || Keyboard.isUp()) {
            return true;
        }
        return false;
    }

    public boolean canMove(double xx, double yy) {
        return true;
    }

    public Image chooseImage(int direction) {
        switch (direction) {
            case -1:

                return NewSprite.getMoveSprite(Sprite.player_dead1.getFxImage(), Sprite.player_dead2.getFxImage(),
                        Sprite.player_dead3.getFxImage(), getAnimate(), 70);
            case 1:
                currentSprite = NewSprite.movingSprite(NewSprite.playerLeftList, animate, 33);
                return NewSprite.movingSprite(NewSprite.playerLeftList, animate, 33).getFxImage();
            case 2:
                currentSprite = NewSprite.movingSprite(NewSprite.playerRightList, animate, 33);
                return NewSprite.movingSprite(NewSprite.playerRightList, animate, 33).getFxImage();
            case 3:
                currentSprite = NewSprite.movingSprite(NewSprite.playerUpList, animate, 33);
                return NewSprite.movingSprite(NewSprite.playerUpList, animate, 33).getFxImage();
            case 4:
                currentSprite = NewSprite.movingSprite(NewSprite.playerDownList, animate, 33);
                return NewSprite.movingSprite(NewSprite.playerDownList, animate, 33).getFxImage();
        }
        return null;
    }

    @Override
    public void update() {
        if (!isMoving()) {
            animate = 0;
        }
        calculateMove();
        img = chooseImage(direction);


    }

    @Override
    public void render(GraphicsContext gc) {


        double x = this.x - (double) (currentSprite.getDistanceToTopLeftX()) * NewSprite.SCALED_FACTOR;
        double y = this.y - (double) (currentSprite.getDistanceToTopLeftY()) * NewSprite.SCALED_FACTOR;
        // System.out.println(this.x + " " + this.y +  ":"+currentSprite.getName());
        gc.drawImage(img, x, y);
    }

}
