package uet.oop.bomberman.entities.mapMaterials;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.NewSprite;

public class Wall extends Entity {

    public Wall(double x, double y) {
        super(x, y);
        img= NewSprite.wall.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
