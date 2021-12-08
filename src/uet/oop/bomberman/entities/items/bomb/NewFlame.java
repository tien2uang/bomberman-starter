package uet.oop.bomberman.entities.items.bomb;

import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.ArrayList;


public class NewFlame extends AnimatedEntity {
    private ArrayList<NewSprite> flames;
    private final int ANIMATION_CIRCLE=35;
    public NewFlame(double xUnit, double yUnit, String type) {
        super(xUnit, yUnit);
        chooseFlames(type);
        this.layerPower=4;

    }

    @Override
    public void update() {
        img=NewSprite.movingSprite(flames,getAnimate(),ANIMATION_CIRCLE).getFxImage();
        animate();
        if(getAnimate()==ANIMATION_CIRCLE) {
            this.status=INVALID;
        }
    }

    private void chooseFlames(String type) {
        switch (type) {
            case "topLast":
                this.flames = NewSprite.newBombExplosionVerticalTopLast;
                break;
            case "botLast":
                this.flames = NewSprite.newBombExplosionVerticalBotLast;
                break;
            case "vertical":
                this.flames = NewSprite.newBombExplosionVertical;
                break;
            case "leftLast":
                this.flames = NewSprite.newBombExplosionHorizontalLeftLast;
                break;
            case "rightLast":
                this.flames = NewSprite.newBombExplosionHorizontalRightLast;
                break;
            case "horizontal":
                this.flames = NewSprite.newBombExplosionHorizontal;
                break;
            case "central":
                this.flames = NewSprite.newBombExplosionCentral;
                 break;
        }
    }
}
