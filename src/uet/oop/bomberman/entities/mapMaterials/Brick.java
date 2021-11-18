package uet.oop.bomberman.entities.mapMaterials;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.NewSprite;

public class Brick extends Entity {
    public Brick(double x, double y) {
        super(x,y);
        img = NewSprite.brick.getFxImage();
        this.layerPower=4;
    }

    @Override
    public void update() {

    }
}
