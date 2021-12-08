package uet.oop.bomberman.entities.mapMaterials.border;
import uet.oop.bomberman.graphics.Sprite;

public class TopLeftCorner extends Border{
    public TopLeftCorner(double x, double y){
        super(x,y);
        this.img= Sprite.stage_top_left.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
