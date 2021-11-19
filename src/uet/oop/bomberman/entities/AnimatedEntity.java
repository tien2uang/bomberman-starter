package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class AnimatedEntity extends Entity {
    protected static int animate = 0;
    public final int MAX_ANIMATE = 6000;
    public AnimatedEntity(double x, double y, Image image) {
        super(x, y, image);
    }
    public AnimatedEntity(double x, double y){
        super(x,y);
    }
    public static void animate()
    {
        animate++;
    }

    public static int getAnimate() {
        return animate;
    }

    @Override
    public void update() {

    }
}
