package uet.oop.bomberman.entities.items.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.NewBomber;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;

public class FlameItem extends Item {
    public boolean destroyed;
    public FlameItem(double xUnit, double yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public FlameItem(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = NewSprite.flame_item.getFxImage();
        this.layerPower = 1;
    }

    @Override
    public void update() {
        img = NewSprite.movingSprite(NewSprite.flameItem, getAnimate(), 33).getFxImage();
        animate();
        collideBomber();
        if (destroyed) {
            this.status = INVALID;
        }
    }

    public void collideBomber() {
        if (Board.getMostPoweredEntityAt(xUnit, yUnit) instanceof NewBomber) {
            destroyed = true;
            Board.flameItem_quantity++;
        }
    }
}
