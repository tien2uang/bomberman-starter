package uet.oop.bomberman.entities.items.buff;

import javafx.scene.image.Image;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.NewBomber;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Item extends AnimatedEntity {

    protected boolean destroyed;
    public Item(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = Sprite.powerup_speed.getFxImage();
        destroyed=false;
    }

    @Override
    public void update() {

    }
    public abstract void collideBomber();

}
