package uet.oop.bomberman.entities.mapMaterials.border;
import uet.oop.bomberman.graphics.Sprite;

public class BotLeftCorner extends Border {
    public BotLeftCorner(double x, double y){
        super(x,y);
        this.img= Sprite.stage_bot_left.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
