package uet.oop.bomberman.entities.items.bomb;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.characters.Flame;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.ArrayList;
import java.util.Arrays;


public class NewBomb extends AnimatedEntity {
    private ArrayList<NewSprite> bombs;
    private ArrayList<NewFlame> flames;
    private int type;
    private final int ANIMATION_CIRCLE = 90;

    public NewBomb(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = NewSprite.bomb1_1.getFxImage();
        this.layerPower = 2;
        type = 0;
        bombs = NewSprite.normalBomb;
        flames = new ArrayList<NewFlame>(Arrays.asList(
                new NewFlame(this.xUnit, this.yUnit, "central"),
                new NewFlame(this.xUnit + 1, this.yUnit, "horizontal"),
                new NewFlame(this.xUnit - 1, this.yUnit, "horizontal"),
                new NewFlame(this.xUnit + 2, this.yUnit, "rightLast"),
                new NewFlame(this.xUnit - 2, this.yUnit, "leftLast"),
                new NewFlame(this.xUnit, this.yUnit - 1, "vertical"),
                new NewFlame(this.xUnit, this.yUnit + 1, "vertical"),
                new NewFlame(this.xUnit, this.yUnit - 2, "topLast"),
                new NewFlame(this.xUnit, this.yUnit + 2, "botLast")
        ));
    }

    public NewBomb(double xUnit, double yUnit, int type) {
        this(xUnit, yUnit);
        this.type = type;
        if (type == 1) {
            bombs = NewSprite.powerBomb;
        }

    }

    @Override
    public void update() {
        img=NewSprite.movingSprite(bombs,getAnimate(),ANIMATION_CIRCLE).getFxImage();
        animate();
        if(getAnimate()==ANIMATION_CIRCLE){
            this.status=INVALID;
            checkCollisionWithMapForFlames();
            for(NewFlame newFlame: flames ){
                Board.getFlames().add(newFlame);
            }

        }
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
    public void checkCollisionWithMapForFlames(){
            //KIEM TRA VA CHẠM VỚI TƯỜNG
    }
}
