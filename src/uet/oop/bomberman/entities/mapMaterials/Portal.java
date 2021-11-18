package uet.oop.bomberman.entities.mapMaterials;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.NewSprite;

public class Portal extends Entity {
    public Portal(double x, double y){
        super(x, y);
        img= NewSprite.portal_1.getFxImage();
        this.layerPower=1;
    }

    @Override
    public void update() {

    }
}
