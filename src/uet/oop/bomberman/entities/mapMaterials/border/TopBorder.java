package uet.oop.bomberman.entities.mapMaterials.border;

import uet.oop.bomberman.graphics.Sprite;

public class TopBorder extends Border {
    public TopBorder(double x, double y){
        super(x,y);
        this.img= Sprite.stage_top.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
