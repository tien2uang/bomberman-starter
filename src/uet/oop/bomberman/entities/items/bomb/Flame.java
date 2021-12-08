package uet.oop.bomberman.entities.items.bomb;

import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;


public class Flame extends AnimatedEntity {
    private ArrayList<Sprite> flames;
    private final int ANIMATION_CIRCLE=35;
    public Flame(double xUnit, double yUnit, String type) {
        super(xUnit, yUnit);
        chooseFlames(type);
        this.layerPower=4;

    }

    @Override
    public void update() {
        img= Sprite.movingSprite(flames,getAnimate(),ANIMATION_CIRCLE).getFxImage();
        animate();
        if(getAnimate()==ANIMATION_CIRCLE) {
            this.status=INVALID;
        }
    }

    private void chooseFlames(String type) {
        switch (type) {
            case "topLast":
                this.flames = Sprite.newBombExplosionVerticalTopLast;
                break;
            case "botLast":
                this.flames = Sprite.newBombExplosionVerticalBotLast;
                break;
            case "vertical":
                this.flames = Sprite.newBombExplosionVertical;
                break;
            case "leftLast":
                this.flames = Sprite.newBombExplosionHorizontalLeftLast;
                break;
            case "rightLast":
                this.flames = Sprite.newBombExplosionHorizontalRightLast;
                break;
            case "horizontal":
                this.flames = Sprite.newBombExplosionHorizontal;
                break;
            case "central":
                this.flames = Sprite.newBombExplosionCentral;
                 break;
        }
    }
}
