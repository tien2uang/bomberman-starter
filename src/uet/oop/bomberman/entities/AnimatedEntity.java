package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AnimatedEntity extends Entity {
    protected int animate = 0;
    public AnimatedEntity(double x, double y, Image image) {
        super(x, y, image);
    }

    public AnimatedEntity(double x, double y) {
        super(x, y);
    }

    public void animate() {
        animate++;
    }

    public int getAnimate() {
        return animate;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
}
