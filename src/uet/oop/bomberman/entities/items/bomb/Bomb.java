package uet.oop.bomberman.entities.items.bomb;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.mapMaterials.Brick;
import uet.oop.bomberman.entities.mapMaterials.Wall;
import uet.oop.bomberman.entities.mapMaterials.border.Border;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Bomb extends AnimatedEntity {
    private ArrayList<Sprite> bombs;
    private ArrayList<Flame> flames;
    private int type;
    private int range;
    private final int ANIMATION_CIRCLE = 90;

    public Bomb(double xUnit, double yUnit) {
        super(xUnit, yUnit + Game.INFO_HEIGHT);
        this.img = Sprite.bomb1_1.getFxImage();
        this.layerPower = 3.5;
        type = 0;
        range = 2;
        bombs = Sprite.normalBomb;
        flames = new ArrayList<Flame>(Arrays.asList(
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT, "central"),
                new Flame(this.xUnit + 1, yUnit + Game.INFO_HEIGHT, "horizontal"),
                new Flame(this.xUnit - 1, yUnit + Game.INFO_HEIGHT, "horizontal"),
                new Flame(this.xUnit + 2, yUnit + Game.INFO_HEIGHT, "rightLast"),
                new Flame(this.xUnit - 2, yUnit + Game.INFO_HEIGHT, "leftLast"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT - 1, "vertical"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT + 1, "vertical"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT - 2, "topLast"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT + 2, "botLast")
        ));
    }

    public Bomb(double xUnit, double yUnit, int type) {
        this(xUnit, yUnit);
        this.type = type;
        if (type == 1) {
            bombs = Sprite.powerBomb;
            range = 3;
        }
        flames = new ArrayList<Flame>(Arrays.asList(
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT, "central"),
                new Flame(this.xUnit + 1, yUnit + Game.INFO_HEIGHT, "horizontal"),
                new Flame(this.xUnit + 2, yUnit + Game.INFO_HEIGHT, "horizontal"),
                new Flame(this.xUnit - 1, yUnit + Game.INFO_HEIGHT, "horizontal"),
                new Flame(this.xUnit - 2, yUnit + Game.INFO_HEIGHT, "horizontal"),
                new Flame(this.xUnit + 3, yUnit + Game.INFO_HEIGHT, "rightLast"),
                new Flame(this.xUnit - 3, yUnit + Game.INFO_HEIGHT, "leftLast"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT - 1, "vertical"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT - 2, "vertical"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT + 1, "vertical"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT + 2, "vertical"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT - 3, "topLast"),
                new Flame(this.xUnit, yUnit + Game.INFO_HEIGHT + 3, "botLast")
        ));

    }

    @Override
    public void update() {
        img = Sprite.movingSprite(bombs, getAnimate(), ANIMATION_CIRCLE).getFxImage();
        animate();
        if (getAnimate() == ANIMATION_CIRCLE) {
            explode();
        }else if(collideWithFlames()){
            explode();
        }

    }

    private void explode() {
        checkCollisionWithMapForFlames();
        if (Board.bombQuantity == 0) {
            Board.bombQuantity++;
        } else if (Board.bombQuantity == 1) {
            Board.bombItem_quantity--;
        }
        for (Flame flame : flames) {
            Board.getFlames().add(flame);
        }
        Audio.playSound(Audio.bombExplosion);
        this.status = INVALID;
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    private boolean collideWithFlames(){
        if(Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() ) instanceof Flame) {
            System.out.println("ÝE");
            return true;
        }
        return false;
    }
    private void checkCollisionWithMapForFlames() {
        //kiểm tra chạm tường, bom, brick
        // nếu va chạm với brick thì cho nổ brick, setOnFire ở brick

        //top
        for (int i = 1; i <= range; i++) {
            if (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() - i) instanceof Wall
                    || Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() - i) instanceof Border
                    || Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() - i) instanceof Flame) {
                Iterator<Flame> it = flames.iterator();

                while (it.hasNext()) {
                    Flame flame = it.next();
                    if (flame.getYUnit() <= this.getYUnit() - i) {
                        it.remove();
                    }
                }

                break;
            } else if (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() - i) instanceof Brick) {
                Brick brick = (Brick) (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() - i));
                brick.setDestroyed(true);
                Iterator<Flame> it = flames.iterator();

                while (it.hasNext()) {
                    Flame flame = it.next();
                    if (flame.getYUnit() <= this.getYUnit() - i) {
                        it.remove();
                    }
                }
                break;
            }
        }
        //bot
        for (int i = 1; i <= range; i++) {
            if (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() + i) instanceof Wall
                    || Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() + i) instanceof Border
                    || Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() + i) instanceof Flame) {

                Iterator<Flame> it = flames.iterator();
                while (it.hasNext()) {
                    Flame flame = it.next();
                    if (flame.getYUnit() >= this.getYUnit() + i) {
                        it.remove();
                    }
                }
                break;
            } else if (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() + i) instanceof Brick) {
                Brick brick = (Brick) (Board.getMostPoweredEntityAt(this.getXUnit(), this.getYUnit() + i));
                brick.setDestroyed(true);
                Iterator<Flame> it = flames.iterator();
                while (it.hasNext()) {
                    Flame flame = it.next();
                    if (flame.getYUnit() >= this.getYUnit() + i) {
                        it.remove();
                    }
                }
                break;
            }
        }
        //right
        for (int i = 1; i <= range; i++) {
            if (Board.getMostPoweredEntityAt(this.getXUnit() + i, this.getYUnit()) instanceof Wall
                    || Board.getMostPoweredEntityAt(this.getXUnit() + i, this.getYUnit()) instanceof Border
                    || Board.getMostPoweredEntityAt(this.getXUnit() + i, this.getYUnit()) instanceof Flame) {
                Iterator<Flame> it = flames.iterator();
                while (it.hasNext()) {
                    Flame flame = it.next();
                    if (flame.getXUnit() >= this.getXUnit() + i) {
                        it.remove();
                    }
                }
                break;
            } else if (Board.getMostPoweredEntityAt(this.getXUnit() + i, this.getYUnit()) instanceof Brick) {
                Brick brick = (Brick) (Board.getMostPoweredEntityAt(this.getXUnit() + i, this.getYUnit()));
                brick.setDestroyed(true);
                Iterator<Flame> it = flames.iterator();
                while (it.hasNext()) {
                    Flame flame = it.next();
                    if (flame.getXUnit() >= this.getXUnit() + i) {
                        it.remove();
                    }
                }
                break;
            }
        }
        //left
        for (int i = 1; i <= range; i++) {
            if (Board.getMostPoweredEntityAt(this.getXUnit() - i, this.getYUnit()) instanceof Wall
                    || Board.getMostPoweredEntityAt(this.getXUnit() - i, this.getYUnit()) instanceof Border
                    || Board.getMostPoweredEntityAt(this.getXUnit() - i, this.getYUnit()) instanceof Flame) {
                Iterator<Flame> it = flames.iterator();
                while (it.hasNext()) {
                    Flame flame = it.next();
                    if (flame.getXUnit() <= this.getXUnit() - i) {
                        it.remove();
                    }
                }
                break;
            } else if (Board.getMostPoweredEntityAt(this.getXUnit() - i, this.getYUnit()) instanceof Brick) {
                Brick brick = (Brick) (Board.getMostPoweredEntityAt(this.getXUnit() - i, this.getYUnit()));
                brick.setDestroyed(true);
                Iterator<Flame> it = flames.iterator();
                while (it.hasNext()) {
                    Flame flame = it.next();
                    if (flame.getXUnit() <= this.getXUnit() - i) {
                        it.remove();
                    }
                }
                break;
            }
        }
    }

}
