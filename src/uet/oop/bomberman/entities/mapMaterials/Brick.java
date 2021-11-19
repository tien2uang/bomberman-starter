package uet.oop.bomberman.entities.mapMaterials;

import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.graphics.NewSprite;




public class Brick extends AnimatedEntity {



    public Brick(double x, double y) {
        super(x, y);
        img = NewSprite.brick.getFxImage();
        this.layerPower = 4;

    }

    @Override
    public void update() {
        img=NewSprite.movingSprite(NewSprite.brickBrokenList,animate,70).getFxImage();

    }
}
