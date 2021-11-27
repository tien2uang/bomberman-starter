package uet.oop.bomberman.gameplay;

import uet.oop.bomberman.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Board extends Game {
    public static final double BOARD_WIDTH = 17;
    public static final double BOARD_HEIGHT = 13;
    public static final double BOARD_COORDINATE_Y = Game.INFO_HEIGHT;
    private static List<Entity> mapEntities = new ArrayList<>();
    private static List<Entity> nonMapEntities = new ArrayList<>();
    private static List<Entity> bombs = new ArrayList<>();


    public static void update() {
        Game.currentGameTime++;
        mapEntities.forEach(g -> g.update());
        nonMapEntities.forEach(g -> g.update());
        bombs.forEach(g -> g.update());
    }

    public static void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        mapEntities.forEach(g -> g.render(gc));
        nonMapEntities.forEach(g -> g.render(gc));
        bombs.forEach(g -> g.render(gc));
    }

    public static Entity getMostPoweredEntityAt(double x, double y) {
        Entity result = null;
        double temp = 0;
        for (Entity entity : mapEntities) {

            if (Double.compare(x, entity.getXUnit()) == 0 && Double.compare(y, entity.getYUnit()) == 0) {
                if (entity.getLayerPower() >= temp) {
                    result = entity;
                    temp = entity.getLayerPower();
                }
            }
        }
        for (Entity entity : nonMapEntities) {
            if (Double.compare(x, entity.getX()) == 0 && Double.compare(y, entity.getY()) == 0) {
                if (entity.getLayerPower() >= temp) {
                    result = entity;
                    temp = entity.getLayerPower();
                }
            }
        }
        return result;
    }

    public static List<Entity> getEntitiesList() {
        return mapEntities;
    }

    public static List<Entity> getStillObjectsList() {
        return nonMapEntities;
    }

    public static List<Entity> getBombs() {
        return bombs;
    }

}
