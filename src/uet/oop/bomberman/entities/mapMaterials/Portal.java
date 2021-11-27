package uet.oop.bomberman.entities.mapMaterials;

import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.graphics.NewSprite;

public class Portal extends AnimatedEntity {

    public Portal(double x, double y) {
        super(x, y);
        img = NewSprite.portal_1.getFxImage();
        this.layerPower = 1;
    }

    @Override
    public void update() {
        img = NewSprite.movingSprite(NewSprite.portalList, animate, 160).getFxImage();
        animate();
    }
}
