package uet.oop.bomberman.entities.mapMaterials.border;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.NewSprite;

public class TopLeftCorner extends Entity {
    public TopLeftCorner(double x, double y){
        super(x,y);
        this.img= NewSprite.stage_top_left.getFxImage();
        this.layerPower=6;
    }

    @Override
    public void update() {

    }
}
