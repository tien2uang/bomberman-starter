package uet.oop.bomberman.entities.mapMaterials.border;
import uet.oop.bomberman.graphics.Sprite;

public class BotRightCorner extends Border {
    public BotRightCorner(double x, double y)
    {
        super(x, y);
        this.img= Sprite.stage_bot_right.getFxImage();
        this.layerPower=5;
    }

    @Override
    public void update() {

    }
}
