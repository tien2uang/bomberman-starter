package uet.oop.bomberman.entities.mapMaterials;

import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;


public class Brick extends AnimatedEntity {
    public int deathTime;
    public boolean destroyed;
    public final int ANIMATION_CIRCLE = 150;
    public boolean onFire;

    public Brick(double x, double y) {
        super(x, y);
        img = NewSprite.brick.getFxImage();
        this.layerPower = 3.5;
        destroyed = false;
        onFire = false;

    }

    @Override
    public void update() {

        if (destroyed) {
            img = NewSprite.movingSprite(NewSprite.brickBrokenList, getAnimate(), ANIMATION_CIRCLE).getFxImage();
            animate();
            if (getAnimate() == ANIMATION_CIRCLE) {
                this.status = INVALID;
            }
        }


    }

    public  void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
        this.deathTime = (int) Game.currentGameTime;
        setOnFire(true);
    }

    public boolean isOnFire() {
        return onFire;
    }

    public void setOnFire(boolean onFire) {
        this.onFire = onFire;
    }
}
