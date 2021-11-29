package uet.oop.bomberman.entities.characters;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.graphics.NewSprite;

public class Flame extends Entity {
    public Flame(double xUnit, double yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Flame(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = NewSprite.explosion_horizontal.getFxImage();
    }

    @Override
    public void update() {
        for (Entity bomb : Board.getBombs()) {
            Bomb b = (Bomb) bomb;
            if (bomb.getXUnit() == getXUnit() && bomb.getYUnit() == getYUnit()) {
                if (!b.isExploded()) {
                    b.explode();
                }
            }
        }
    }
}
