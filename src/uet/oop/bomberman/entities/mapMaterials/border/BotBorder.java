package uet.oop.bomberman.entities.mapMaterials.border;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.NewSprite;



public class BotBorder extends Border {
    public BotBorder(double x, double y){
        super(x,y);
        this.img= NewSprite.stage_bot.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
