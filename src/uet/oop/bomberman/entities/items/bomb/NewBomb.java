package uet.oop.bomberman.entities.items.bomb;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.mapMaterials.Brick;
import uet.oop.bomberman.entities.mapMaterials.Wall;
import uet.oop.bomberman.entities.mapMaterials.border.Border;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class NewBomb extends AnimatedEntity {
    private ArrayList<NewSprite> bombs;
    private ArrayList<NewFlame> flames;
    private int type;
    private int range;
    private final int ANIMATION_CIRCLE = 90;

    public NewBomb(double xUnit, double yUnit) {
        super(xUnit, yUnit+ Game.INFO_HEIGHT);
        this.img = NewSprite.bomb1_1.getFxImage();
        this.layerPower = 2;
        type = 0;
        range = 2;
        bombs = NewSprite.normalBomb;
        flames = new ArrayList<NewFlame>(Arrays.asList(
                new NewFlame(this.xUnit, yUnit+ Game.INFO_HEIGHT, "central"),
                new NewFlame(this.xUnit + 1, yUnit+ Game.INFO_HEIGHT, "horizontal"),
                new NewFlame(this.xUnit - 1, yUnit+ Game.INFO_HEIGHT, "horizontal"),
                new NewFlame(this.xUnit + 2, yUnit+ Game.INFO_HEIGHT, "rightLast"),
                new NewFlame(this.xUnit - 2, yUnit+ Game.INFO_HEIGHT, "leftLast"),
                new NewFlame(this.xUnit, yUnit+ Game.INFO_HEIGHT - 1, "vertical"),
                new NewFlame(this.xUnit, yUnit+ Game.INFO_HEIGHT + 1, "vertical"),
                new NewFlame(this.xUnit, yUnit+ Game.INFO_HEIGHT - 2, "topLast"),
                new NewFlame(this.xUnit, yUnit+ Game.INFO_HEIGHT + 2, "botLast")
        ));
    }

    public NewBomb(double xUnit, double yUnit, int type) {
        this(xUnit, yUnit);
        this.type = type;
        if (type == 1) {
            bombs = NewSprite.powerBomb;
            range = 3;
        }

    }

    @Override
    public void update() {
        img = NewSprite.movingSprite(bombs, getAnimate(), ANIMATION_CIRCLE).getFxImage();
        animate();
        if (getAnimate() == ANIMATION_CIRCLE) {
            checkCollisionWithMapForFlames();
            for (NewFlame newFlame : flames) {
                Board.getFlames().add(newFlame);
            }
            this.status = INVALID;

        }
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    private void checkCollisionWithMapForFlames() {
        //kiểm tra chạm tường
        // nếu va chạm với brick thì cho nổ brick, setOnFire ở brick

        //top
        for (int i = 1; i <= range; i++) {
            if (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() - i) instanceof Wall
                    || Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() - i) instanceof Border) {
                Iterator<NewFlame> it = flames.iterator();
                System.out.println(flames.size() + "");
                while (it.hasNext()) {
                    NewFlame flame = it.next();
                    if(flame.getYUnit()<= this.getYUnit() - i){
                        it.remove();
                    }
                }

                break;
            } else if (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() - i) instanceof Brick) {
                Brick brick = (Brick) (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() - i));
                brick.setDestroyed(true);
                Iterator<NewFlame> it = flames.iterator();
                System.out.println(flames.size() + "");
                while (it.hasNext()) {
                    NewFlame flame = it.next();
                    if(flame.getYUnit()<= this.getYUnit() - i){
                        it.remove();
                    }
                }
                break;
            }
        }
        //bot
        for (int i = 1; i <= range; i++) {
            if (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() + i) instanceof Wall
                    || Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() + i) instanceof Border) {
                System.out.println(flames.size() );
                Iterator<NewFlame> it = flames.iterator();
                while (it.hasNext()) {
                    NewFlame flame = it.next();
                    if(flame.getYUnit()>= this.getYUnit() + i){
                        it.remove();
                    }
                }
                break;
            } else if (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() + i) instanceof Brick) {
                Brick brick = (Brick) (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() + i));
                brick.setDestroyed(true);
                Iterator<NewFlame> it = flames.iterator();
                while (it.hasNext()) {
                    NewFlame flame = it.next();
                    if(flame.getYUnit()<= this.getYUnit() - i){
                        it.remove();
                    }
                }
                break;
            }
        }
        //right
        for (int i = 1; i <= range; i++) {
            if (Board.getMostPoweredEntityAt(this.getXUnit() + i, this.getYUnit()) instanceof Wall
                    || Board.getMostPoweredEntityAt(this.getXUnit() + i, this.getYUnit()) instanceof Border) {
                Iterator<NewFlame> it = flames.iterator();
                while (it.hasNext()) {
                    NewFlame flame = it.next();
                    if(flame.getXUnit()>= this.getXUnit() + i){
                        it.remove();
                    }
                }
                break;
            } else if (Board.getMostPoweredEntityAt(this.getXUnit() + i, this.getYUnit()) instanceof Brick) {
                Brick brick = (Brick) (Board.getMostPoweredEntityAt(this.getXUnit() + i, this.getYUnit()));
                brick.setDestroyed(true);
                Iterator<NewFlame> it = flames.iterator();
                while (it.hasNext()) {
                    NewFlame flame = it.next();
                    if(flame.getXUnit()>= this.getXUnit() + i){
                        it.remove();
                    }
                }
                break;
            }
        }
        //left
        for (int i = 1; i <= range; i++) {
            if (Board.getMostPoweredEntityAt(this.getXUnit() - i, this.getYUnit()) instanceof Wall
                    || Board.getMostPoweredEntityAt(this.getXUnit() - i, this.getYUnit()) instanceof Border) {
                Iterator<NewFlame> it = flames.iterator();
                while (it.hasNext()) {
                    NewFlame flame = it.next();
                    if(flame.getXUnit()<= this.getXUnit() - i){
                        it.remove();
                    }
                }
                break;
            } else if (Board.getMostPoweredEntityAt(this.getXUnit() - i, this.getYUnit()) instanceof Brick) {
                Brick brick = (Brick) (Board.getMostPoweredEntityAt(this.getXUnit() - i, this.getYUnit()));
                brick.setDestroyed(true);
                Iterator<NewFlame> it = flames.iterator();
                while (it.hasNext()) {
                    NewFlame flame = it.next();
                    if(flame.getXUnit()<= this.getXUnit() - i){
                        it.remove();
                    }
                }
                break;
            }
        }
    }

}
