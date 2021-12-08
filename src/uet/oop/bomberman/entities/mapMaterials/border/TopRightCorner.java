package uet.oop.bomberman.entities.mapMaterials.border;


import uet.oop.bomberman.graphics.Sprite;

public class TopRightCorner extends Border {
    public TopRightCorner(double x, double y){
        super(x,y);
        this.img= Sprite.stage_top_right.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
