package uet.oop.bomberman.entities.mapMaterials.border;
import uet.oop.bomberman.graphics.Sprite;



public class BotBorder extends Border {
    public BotBorder(double x, double y){
        super(x,y);
        this.img= Sprite.stage_bot.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
