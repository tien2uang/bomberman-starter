package uet.oop.bomberman.entities.mapMaterials;

import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;


public class Brick extends AnimatedEntity {
    protected int deathTime;
    protected boolean destroy;
    public static final int ANIMATION_CIRCLE = 70;

    public Brick(double x, double y) {
        super(x, y);
        img = NewSprite.brick.getFxImage();
        this.layerPower = 3.5;
        destroy = false;


    }

    @Override
    public void update() {
        if(Game.currentGameTime==50){
            setDestroy(true);
        }
        if (destroy) {
           destroy();
        }


    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
        this.deathTime= (int)Game.currentGameTime;
    }
    private void destroy() {
        img = NewSprite.movingSprite(NewSprite.brickBrokenList, getAnimate(), ANIMATION_CIRCLE).getFxImage();
        animate();
        if(getAnimate()==ANIMATION_CIRCLE){
            this.status=INVALID;
        }
    }
}
