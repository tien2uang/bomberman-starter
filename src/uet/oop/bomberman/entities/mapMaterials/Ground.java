package uet.oop.bomberman.entities.mapMaterials;

import uet.oop.bomberman.entities.StaticEntity;
import uet.oop.bomberman.graphics.Sprite;

public class Ground extends StaticEntity {


    public Ground(double x, double y) {
        super(x, y);
        this.layerPower=1;
        this.img= Sprite.ground.getFxImage();
    }

    @Override
    public void update() {

    }
}
