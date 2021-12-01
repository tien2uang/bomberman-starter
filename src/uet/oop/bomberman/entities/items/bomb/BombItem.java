package uet.oop.bomberman.entities.items.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class BombItem extends Item {
    public BombItem(double xUnit, double yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public BombItem(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = Sprite.powerup_bombs.getFxImage();
        this.layerPower = 1;
    }

    @Override
    public void update() {

    }
}
