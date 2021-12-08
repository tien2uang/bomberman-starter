package uet.oop.bomberman.entities.mapMaterials.border;
import uet.oop.bomberman.graphics.Sprite;

public class RightBorder extends Border {
    public RightBorder(double x, double y){
        super(x, y);
        this.img= Sprite.stage_right_1.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
