package uet.oop.bomberman.entities.items.buff;

import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Item extends AnimatedEntity {

    protected boolean destroyed;
    public Item(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        destroyed=false;
    }

    @Override
    public void update() {

    }
    public abstract void collideBomber();

}
