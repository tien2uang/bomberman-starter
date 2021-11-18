package uet.oop.bomberman.entities.mapMaterials.border;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.NewSprite;

public class TopBorder extends Entity {
    public TopBorder(double x, double y){
        super(x,y);
        this.img= NewSprite.stage_top.getFxImage();
        this.layerPower=6;
    }

    @Override
    public void update() {

    }
}
