package uet.oop.bomberman.gameplay;

import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mapMaterials.Ground;
import uet.oop.bomberman.entities.mapMaterials.Wall;


import java.util.ArrayList;
import java.util.List;

public class Board extends Game {
    public static final double BOARD_WIDTH = 17;
    public static final double BOARD_HEIGHT = 13;
    public static final double BOARD_COORDINATE_Y = Game.INFO_HEIGHT;
    private static List<Entity> entities = new ArrayList<>();
    private static List<Entity> stillObjects = new ArrayList<>();


    public static void update() {
        Game.currentGameTime++;
        entities.forEach(g -> g.update());
        stillObjects.forEach(g -> g.update());
    }

    public static void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        entities.forEach(g -> g.render(gc));
        stillObjects.forEach(g -> g.render(gc));
    }



    public static List<Entity> getEntitiesList() {
        return entities;
    }

    public static List<Entity> getStillObjectsList() {
        return stillObjects;
    }

}
