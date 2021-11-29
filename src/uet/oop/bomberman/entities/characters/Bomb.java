package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mapMaterials.Brick;
import uet.oop.bomberman.entities.mapMaterials.Wall;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.ArrayList;

public class Bomb extends AnimatedEntity {
    int timer = 200;
    boolean exploded = false;
    ArrayList<Flame> flames = new ArrayList<>();
    public Bomb(double xUnit, double yUnit) {
        super(xUnit, yUnit);
        this.img = NewSprite.bomb1_1.getFxImage();
        this.layerPower = 2;
    }

    @Override
    public void update() {
        if (timer > 0) {
            if (timer > 100) {
                img = NewSprite.movingSprite(NewSprite.bombExplosion1, getAnimate(), 75).getFxImage();
                animate();
            } else {
                if (!exploded) {
                    explode();
                } /*else if (exploded && timer <= 50) {
                    explode1();
                }*/
                for (Flame flame : flames) {
                    flame.update();
                }
            }
            timer--;
        } else {
            flames.clear();
        }
    }

    public void explode() {
        img = null;
        exploded = true;
        double xUnit = getXUnit();
        double yUnit = getYUnit() + Game.INFO_HEIGHT;
        flames.add(new Flame(xUnit, yUnit, NewSprite.bomb_exploded_2.getFxImage()));
        //Up
        double newUnitUp = yUnit - 1;
        if (Board.getMostPoweredEntityAt((int) (xUnit + 0.5), (int) (newUnitUp - 0.5)).getLayerPower() >= 5) {

        } else if (Board.getMostPoweredEntityAt((int) (xUnit + 0.5), (int) (newUnitUp - 0.5)).getLayerPower() == 3.5) {
            //Brick.setDestroyed(true);
        } else {
            flames.add(new Flame(xUnit, newUnitUp, NewSprite.explosion_vertical_top_last_2.getFxImage()));
        }
        //Down
        double newUnitDown = yUnit + 1;
        if (Board.getMostPoweredEntityAt((int) (xUnit + 0.5), (int) (newUnitDown - 0.5)).getLayerPower() >= 5) {

        } else if (Board.getMostPoweredEntityAt((int) (xUnit + 0.5), (int) (newUnitDown - 0.5)).getLayerPower() == 3.5) {
            //Brick.setDestroyed(true);
        } else {
            flames.add(new Flame(xUnit, newUnitDown, NewSprite.explosion_vertical_bot_last_2.getFxImage()));
        }
        //Right
        double newUnitRight = xUnit + 1;
        if (Board.getMostPoweredEntityAt((int) (newUnitRight + 0.5), (int) (yUnit - 0.5)).getLayerPower() >= 5) {

        } else if (Board.getMostPoweredEntityAt((int) (newUnitRight + 0.5), (int) (yUnit - 0.5)).getLayerPower() == 3.5) {
            //Brick.setDestroyed(true);
        } else {
            flames.add(new Flame(newUnitRight, yUnit, NewSprite.explosion_horizontal_right_last_2.getFxImage()));
        }

        //Left
        double newUnitLeft = xUnit - 1;
        if (Board.getMostPoweredEntityAt((int) (newUnitLeft + 0.5), (int) (yUnit - 0.5)).getLayerPower() >= 5) {

        } else if (Board.getMostPoweredEntityAt((int) (newUnitLeft + 0.5), (int) (yUnit - 0.5)).getLayerPower() == 3.5) {
           // Brick.setDestroyed(true);
        } else {
            flames.add(new Flame(newUnitLeft, yUnit, NewSprite.explosion_horizontal_left_last_2.getFxImage()));
        }
    }

    public void explode1() {
        double xUnit = getXUnit();
        double yUnit = getYUnit() + 1;
        flames.add(new Flame(xUnit, yUnit, NewSprite.bomb_exploded.getFxImage()));
        double newUnitUp = yUnit - 1;
        if (Board.getMostPoweredEntityAt((int) (xUnit + 0.5), (int) (newUnitUp - 0.5)).getLayerPower() >= 5) {

        } else if (Board.getMostPoweredEntityAt((int) (xUnit + 0.5), (int) (newUnitUp - 0.5)).getLayerPower() == 3.5) {
          //  Brick.setDestroyed(true);
        } else {
            flames.add(new Flame(xUnit, newUnitUp, NewSprite.explosion_vertical_top_last.getFxImage()));
        }
        //Down
        double newUnitDown = yUnit + 1;
        if (Board.getMostPoweredEntityAt((int) (xUnit + 0.5), (int) (newUnitDown - 0.5)).getLayerPower() >= 5) {

        } else if (Board.getMostPoweredEntityAt((int) (xUnit + 0.5), (int) (newUnitDown - 0.5)).getLayerPower() == 3.5) {
           // Brick.setDestroyed(true);
        } else {
            flames.add(new Flame(xUnit, newUnitDown, NewSprite.explosion_vertical_bot_last.getFxImage()));
        }
        //Right
        double newUnitRight = xUnit + 1;
        if (Board.getMostPoweredEntityAt((int) (newUnitRight + 0.5), (int) (yUnit - 0.5)).getLayerPower() >= 5) {

        } else if (Board.getMostPoweredEntityAt((int) (newUnitRight + 0.5), (int) (yUnit - 0.5)).getLayerPower() == 3.5) {
           // Brick.setDestroyed(true);
        } else {
            flames.add(new Flame(newUnitRight, yUnit, NewSprite.explosion_horizontal_right_last.getFxImage()));
        }

        //Left
        double newUnitLeft = xUnit - 1;
        if (Board.getMostPoweredEntityAt((int) (newUnitLeft + 0.5), (int) (yUnit - 0.5)).getLayerPower() >= 5) {

        } else if (Board.getMostPoweredEntityAt((int) (newUnitLeft + 0.5), (int) (yUnit - 0.5)).getLayerPower() == 3.5) {
           // Brick.setDestroyed(true);
        } else {
            flames.add(new Flame(newUnitLeft, yUnit, NewSprite.explosion_horizontal_left_last.getFxImage()));
        }
    }

    public boolean isExploded() {
        return exploded;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
        for (Flame flame : flames) {
            flame.render(gc);
        }
    }
}
