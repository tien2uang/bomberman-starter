package uet.oop.bomberman.entities.mapMaterials;

import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;


public class Brick extends AnimatedEntity {
    public static int deathTime;
    public static boolean destroyed;
    public static final int ANIMATION_CIRCLE = 150;

    public Brick(double x, double y) {
        super(x, y);
        img = NewSprite.brick.getFxImage();
        this.layerPower = 3.5;
        destroyed = false;


    }

    @Override
    public void update() {
        /*if(Game.currentGameTime == 50) {
            setDestroyed(true);
        }*/
        if (destroyed) {
            img = NewSprite.movingSprite(NewSprite.brickBrokenList, getAnimate(), ANIMATION_CIRCLE).getFxImage();
            animate();
            if(getAnimate()==ANIMATION_CIRCLE){
                this.status=INVALID;
            }
        }


    }

    public static void setDestroyed(boolean destroyed) {
        Brick.destroyed = destroyed;
        Brick.deathTime= (int)Game.currentGameTime;
    }
}
