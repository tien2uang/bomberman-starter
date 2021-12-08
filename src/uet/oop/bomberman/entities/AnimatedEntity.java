package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class AnimatedEntity extends Entity {
    protected int animate = 0;
    public AnimatedEntity(double x, double y) {
        super(x, y);
    }

    public void animate() {
        animate++;
    }

    public int getAnimate() {
        return animate;
    }




}
