package uet.oop.bomberman.gameplay;

import uet.oop.bomberman.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Board extends Game {
    public static final double BOARD_WIDTH = 17;
    public static final double BOARD_HEIGHT = 13;
    public static final double BOARD_COORDINATE_Y = Game.INFO_HEIGHT;
    public static List<Entity> mapEntities = new ArrayList<>();
    public static List<Entity> character = new ArrayList<>();
    public static List<Entity> bombs = new ArrayList<>();
    public static List<Entity> flames = new ArrayList<>();


    public static void update() {
        Game.currentGameTime++;
        updateMap();
        updateBombs();
        updateFlames();
        updateCharacter();
    }

    public static void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        mapEntities.forEach(g -> g.render(gc));
        bombs.forEach(g -> g.render(gc));
        flames.forEach(g -> g.render(gc));
        character.forEach(g -> g.render(gc));

    }

    public static Entity getMostPoweredEntityAt(double xUnit, double yUnit) {
        Entity result = null;
        double temp = 0;
        for (Entity entity : mapEntities) {

            if (Double.compare(xUnit, entity.getXUnit()) == 0 && Double.compare(yUnit, entity.getYUnit()) == 0) {
                if (entity.getLayerPower() >= temp) {
                    result = entity.getMostPoweredEntity();
                    temp = entity.getLayerPower();
                }
            }
        }
        for (Entity entity : character) {
            if (Double.compare(xUnit, entity.getXUnit()) == 0 && Double.compare(yUnit, entity.getYUnit()) == 0) {
                if (entity.getLayerPower() >= temp) {
                    result = entity.getMostPoweredEntity();
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
        return character;
    }

    public static List<Entity> getBombs() {
        return bombs;
    }

    public static List<Entity> getFlames() {
        return flames;
    }

    private static void updateMap() {
        mapEntities.forEach(g -> g.update());
    }
    private static void updateBombs() {
        bombs.forEach(g -> g.update());
        for(int i=0;i<bombs.size();i++){
            if(bombs.get(i).getStatus()==Entity.INVALID){
                bombs.remove(i);
            }
        }
    }
    private static void updateCharacter() {
        character.forEach(g -> g.update());
    }
    private static void updateFlames(){
        flames.forEach(g -> g.update());
        for(int i=0;i<flames.size();i++){
            if(flames.get(i).getStatus()==Entity.INVALID){
                flames.remove(i);
            }
        }
    }
}
