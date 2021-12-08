package uet.oop.bomberman.entities.items.buff;

import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.characters.Bomber;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.graphics.Sprite;

public class BombItem extends Item {



    public BombItem(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = Sprite.bomb_item.getFxImage();
        this.layerPower = 1;
    }

    @Override
    public void update() {
        img = Sprite.movingSprite(Sprite.bombItem, getAnimate(), 33).getFxImage();
        animate();
        collideBomber();
        if (destroyed) {
            this.status = INVALID;
        }
    }

    public void collideBomber() {
        if (Board.getMostPoweredEntityAt(xUnit, yUnit) instanceof Bomber) {
            Audio.playSound(Audio.itemGet);
            destroyed = true;
            Board.bombQuantity++;
            Board.bombItem_quantity++;
        }
    }
}
