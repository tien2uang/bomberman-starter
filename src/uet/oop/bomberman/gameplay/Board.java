package uet.oop.bomberman.gameplay;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mapMaterials.Grass;
import uet.oop.bomberman.entities.mapMaterials.Wall;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.ArrayList;
import java.util.List;

public class Board extends Game {
    public static final double BOARD_WIDTH = 17;
    public static final double BOARD_HEIGHT = 13;
    public static final double BOARD_COORDINATE_Y = Game.INFO_HEIGHT;
    private static List<Entity> entities = new ArrayList<>();
    private static List<Entity> stillObjects = new ArrayList<>();

    public void update() {

    }

    public static void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }

    public static void createMap() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == BOARD_HEIGHT - 1 || i == 0 || i == BOARD_WIDTH - 1) {
                    object = new Wall(i, j + BOARD_COORDINATE_Y, NewSprite.wall.getFxImage());
                } else {
                    object = new Grass(i, j + BOARD_COORDINATE_Y, NewSprite.ground.getFxImage());
                }
                stillObjects.add(object);
            }
        }
    }
}
