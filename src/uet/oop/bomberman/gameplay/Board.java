package uet.oop.bomberman.gameplay;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Bomber;
import uet.oop.bomberman.entities.enemies.Enemy;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board extends Game {
    public static final double BOARD_WIDTH = 17;
    public static final double BOARD_HEIGHT = 13;
    public static final double BOARD_COORDINATE_Y = Game.INFO_HEIGHT;
    public static long levelTime = 250;
    public static int lives = 2;
    public static int levelScore=0;
    public static boolean isBomberAlive = true;
    public static boolean hasWon = false;
    public static long startTime;
    public static long wonTime;

    public static int BOMB_QUANTITY = 1;
    public static int BOMB_RANGE = 1;
    public static double BOMBER_SPEED = 1.6;
    public static double BOMBER_FAST_SPEED = 3.5;


    public static int bombQuantity = BOMB_QUANTITY;
    public static int bombRange = BOMB_RANGE;
    public static double bomberSpeed = BOMBER_SPEED;

    public static int speedItemTime = 0;
    public static int flameItem_quantity = 0;
    public static int bombItem_quantity = 0;

    public static long speedItemCollidedTime = 0;

    public static List<Entity> mapEntities = new ArrayList<>();
    public static List<Entity> character = new ArrayList<>();
    public static List<Entity> bombs = new ArrayList<>();
    public static List<Entity> flames = new ArrayList<>();




    public static void update() {

        if (hasWon) {

            if (Game.frameTime == Board.wonTime + 90) {
                nextLevel();
                System.out.println("next levellll");
            }

        }
        if (!isBomberAlive) {
            restartLevel();
        }
        if (lives < 0) {
            Game.gameOver = true;
            System.out.println("game over");
        }
        if (Game.isInGame) {
            updateMap();
            updateBombs();
            updateFlames();
            updateCharacter();
            updateItems();
            levelTime = 250 - (Game.currentGameTime - startTime);

        } else {
            updateMap();
        }
    }

    public static void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (Game.isInGame) {
            mapEntities.forEach(g -> g.render(gc));
            bombs.forEach(g -> g.render(gc));
            flames.forEach(g -> g.render(gc));
            character.forEach(g -> g.render(gc));


            if (Game.currentGameTime <= startTime + 1) {
                if (Game.currentLevel == 1) {
                    gc.drawImage(Sprite.stage_1.getFxImage(), 36 * 17 / 2 - 60, 36 * 3 + 18 - 9);
                } else {
                    gc.drawImage(Sprite.stage_2.getFxImage(), 36 * 17 / 2 - 60, 36 * 3 + 18 - 9);
                }
            }

        } else {
            mapEntities.forEach(g -> g.render(gc));
            for (Entity entity : character) {
                if (entity instanceof Bomber) {
                    entity.render(gc);
                }
            }
        }


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
        for (Entity entity : bombs) {

            if (Double.compare(xUnit, entity.getXUnit()) == 0 && Double.compare(yUnit, entity.getYUnit()) == 0) {
                if (entity.getLayerPower() >= temp) {
                    result = entity.getMostPoweredEntity();
                    temp = entity.getLayerPower();
                }
            }
        }
        for (Entity entity : flames) {

            if (Double.compare(xUnit, entity.getXUnit()) == 0 && Double.compare(yUnit, entity.getYUnit()) == 0) {
                if (entity.getLayerPower() >= temp) {
                    result = entity.getMostPoweredEntity();
                    temp = entity.getLayerPower();
                }
            }
        }
        return result;
    }

    public static List<Entity> getMapEntitiesList() {
        return mapEntities;
    }

    public static List<Entity> getCharacterList() {
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
        for (Iterator<Entity> e = bombs.iterator(); e.hasNext();) {
            Entity bomb = e.next();
            bomb.update();
            if (bomb.getStatus() == Entity.INVALID) {
                e.remove();
            }
        }
    }

    private static void updateCharacter() {
        for (Iterator<Entity> entity = character.iterator(); entity.hasNext(); ) {
            Entity mob = entity.next();
            mob.update();

            if (mob.getStatus() == Entity.INVALID) {
                if(mob instanceof Bomber){
                    entity.remove();
                }
                else{
                    Enemy enemy=(Enemy)mob;
                    levelScore+=enemy.getScore();
                    entity.remove();
                }

            }
        }

    }

    private static void updateFlames() {
        flames.forEach(g -> g.update());
        for (int i = 0; i < flames.size(); i++) {
            if (flames.get(i).getStatus() == Entity.INVALID) {
                flames.remove(i);
            }
        }
    }

    public static void increaseSpeed(double add) {
        bomberSpeed = bomberSpeed + add;
    }

    public static double getBomberSpeed() {
        return bomberSpeed;
    }

    public static int getBombRange() {
        return bombRange;
    }

    public static int getBombQuantity() {
        return bombQuantity;
    }

    public static void increaseBombQuantity(int add) {
        bombQuantity = bombQuantity + add;
    }

    public static void restartLevel() {
        if (lives >= 0) {
            mapEntities.clear();
            character.clear();
            bombs.clear();
            flames.clear();
            loadLevel(Game.currentLevel);
            isBomberAlive = true;
            startTime = Game.currentGameTime;
            wonTime = 0;
            lives--;
            levelScore=0;
            hasWon = false;
            System.out.println(lives);
            speedItemTime = 0;
            flameItem_quantity = 0;
            bombItem_quantity = 0;
            bombQuantity = BOMB_QUANTITY;
            bombRange = BOMB_RANGE;
            bomberSpeed = BOMBER_SPEED;
            speedItemCollidedTime=0;
        }

    }

    public static void restart() {
        Game.currentLevel=1;
        System.out.println("restart game");
        mapEntities.clear();
        character.clear();
        bombs.clear();
        flames.clear();
        loadLevel(Game.currentLevel);
        isBomberAlive = true;
        hasWon = false;
        wonTime = 0;
        lives = 2;
        speedItemTime = 0;
        speedItemCollidedTime=0;
        flameItem_quantity = 0;
        bombItem_quantity = 0;
        bombQuantity = BOMB_QUANTITY;
        bombRange = BOMB_RANGE;
        bomberSpeed = BOMBER_SPEED;
    }

    public static void nextLevel() {
        if (Game.currentLevel == 1) {
            Game.currentLevel++;
            Game.gameScore=Board.levelScore;
            Board.levelScore=0;
            mapEntities.clear();
            character.clear();
            bombs.clear();
            flames.clear();
            loadLevel(2);
            isBomberAlive = true;
            startTime = Game.currentGameTime;
            wonTime = 0;
            lives = 2;
            hasWon = false;
            speedItemTime = 0;
            speedItemCollidedTime=0;
            flameItem_quantity = 0;
            bombItem_quantity = 0;
            bombQuantity = BOMB_QUANTITY;
            bombRange = BOMB_RANGE;
            bomberSpeed = BOMBER_SPEED;
            System.out.println("next level");
        }
        else{
            System.out.println("YOU WIN");
        }
    }

    public static boolean hasKilledAllEnemies() {
        return character.size() == 1;
    }
    private static void updateItems(){
        if(speedItemTime>0){
            speedItemTime=(int)(10-(Game.currentGameTime - Board.speedItemCollidedTime));
        }
        else {
            speedItemTime=0;
        }
    }
}
