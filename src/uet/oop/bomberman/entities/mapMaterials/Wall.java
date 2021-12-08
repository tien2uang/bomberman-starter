package uet.oop.bomberman.entities.mapMaterials;

import uet.oop.bomberman.entities.StaticEntity;
import uet.oop.bomberman.graphics.Sprite;

public class Wall extends StaticEntity {

    public Wall(double x, double y) {
        super(x, y);
        img= Sprite.wall.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
