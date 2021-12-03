package uet.oop.bomberman.entities.items.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.NewBomber;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;

public class Item extends AnimatedEntity {
    public Item(double xUnit, double yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Item(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = Sprite.powerup_speed.getFxImage();
    }

    @Override
    public void update() {

    }
}
