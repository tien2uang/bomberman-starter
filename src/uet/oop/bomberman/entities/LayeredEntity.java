package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;

import java.util.Stack;

public class LayeredEntity extends Entity {
    private Stack<Entity> stackEntities;

    public LayeredEntity(double x, double y, Stack<Entity> stackEntities) {
        super(x, y);
        this.stackEntities = stackEntities;
    }

    @Override
    public void update() {
        stackEntities.peek().update();
        
    }

    @Override
    public void render(GraphicsContext gc) {
        stackEntities.peek().render(gc);
    }
}
