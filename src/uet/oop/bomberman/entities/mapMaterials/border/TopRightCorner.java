package uet.oop.bomberman.entities.mapMaterials.border;


import uet.oop.bomberman.graphics.NewSprite;

public class TopRightCorner extends Border {
    public TopRightCorner(double x, double y){
        super(x,y);
        this.img= NewSprite.stage_top_right.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
