package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.AnimatedEntity;

public abstract class Character extends AnimatedEntity {
    public static final int ANIMATION_CIRCLE = 70;
    protected boolean isAlive;
    public Character(double x, double y){
        super(x, y);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext gc) {
    super.render(gc);
    }
}
