package uet.oop.bomberman.entities.mapMaterials;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.NewSprite;

public class Ground extends Entity {


    public Ground(double x, double y) {
        super(x, y);
        this.layerPower=0;
        this.img= NewSprite.ground.getFxImage();
    }

    @Override
    public void update() {

    }
}
