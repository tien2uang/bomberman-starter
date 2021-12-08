package uet.oop.bomberman.entities.mapMaterials.border;

import uet.oop.bomberman.graphics.Sprite;

public class LeftBorder extends Border {
    public LeftBorder(double x, double y){
        super(x, y);
        this.img= Sprite.stage_left_1.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
