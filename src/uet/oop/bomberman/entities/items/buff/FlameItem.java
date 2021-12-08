package uet.oop.bomberman.entities.items.buff;

import javafx.scene.image.Image;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.characters.NewBomber;
import uet.oop.bomberman.entities.items.buff.Item;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.graphics.NewSprite;

public class FlameItem extends Item {

    public FlameItem(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = NewSprite.flame_item.getFxImage();
        this.layerPower = 1;
    }


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
            Audio.playSound(Audio.itemGet);
            destroyed = true;
            Board.flameItem_quantity++;
        }
    }
}
