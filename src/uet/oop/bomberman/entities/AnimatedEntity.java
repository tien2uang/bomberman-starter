package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class AnimatedEntity extends Entity {
    protected  int animate = 0;
    public static final int MAX_ANIMATE = 6000;
    public AnimatedEntity(double x, double y, Image image) {
        super(x, y, image);
    }
    public AnimatedEntity(double x, double y){
        super(x,y);
    }
    public void animate() {
        if (animate < MAX_ANIMATE) {
            animate++;
        } else {
            animate = 0;
        }
    }

    public  int getAnimate() {
        return animate;
    }

    @Override
    public void update() {

    }
}
