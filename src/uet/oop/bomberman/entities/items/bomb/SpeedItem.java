package uet.oop.bomberman.entities.items.bomb;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.characters.NewBomber;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;

public class SpeedItem extends Item {
    public boolean destroyed;
    public boolean isActive;
    public static int speed_quantity = 0;
    public SpeedItem(double xUnit, double yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public SpeedItem(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = Sprite.powerup_speed.getFxImage();
        this.layerPower = 1;
    }

    @Override
    public void update() {
        collideBomber();
        if (destroyed) {
            this.status = INVALID;
        }
    }

    public void collideBomber() {
        if (Board.getMostPoweredEntityAt(xUnit, yUnit) instanceof NewBomber) {
            destroyed = true;
            speed_quantity++;
            Board.increaseSpeed(1.6);
        }
    }
}
