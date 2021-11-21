package uet.oop.bomberman.entities.characters;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.Keyboard;

import  uet.oop.bomberman.entities.AnimatedEntity;


public class Bomber extends AnimatedEntity{

    public int direction;
    public static double speed;

    public Bomber(double x, double y) {
        super(x, y);
        speed = 1;
        this.img  = Sprite.player_left.getFxImage();
        this.layerPower = 0;
    }

    public void move(double p, double q) {

        if (p < 0) {
            direction = 1;
        }
        if (p > 0) {
            direction = 2;
        }
        if (q < 0) {
            direction = 3;
        }
        if (q > 0) {
            direction = 4;
        }

        if (canMove(x,y + q)) {
            y += q;
        }

        if (canMove(x + p,y)) {
            x += p;
        }
    }

    public void calculateMove() {
        double X = 0, Y = 0;
        if (Keyboard.isLeft()) {
            X = -1.6 * speed;
            animate();
        }
        if (Keyboard.isRight()) {
            X = 1.6 * speed;
            animate();
        }
        if (Keyboard.isUp()) {
            Y = -1.6 * speed;
            animate();
        }
        if (Keyboard.isDown()) {
            Y = 1.6 * speed;
            animate();
        }

        if (X != 0 || Y != 0) {
            move(X, Y);
        }
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
                return NewSprite.movingSprite(NewSprite.playerLeftList,animate,24).getFxImage();
            case 2:
                return NewSprite.movingSprite(NewSprite.playerRightList,animate,30).getFxImage();
            case 3:
                return NewSprite.movingSprite(NewSprite.playerUpList,animate,24).getFxImage();
            default:
                return NewSprite.movingSprite(NewSprite.playerDownList,animate,24).getFxImage();
        }
    }

    @Override
    public void update() {
        calculateMove();
        img = chooseImage(direction);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x,y);
    }
}
