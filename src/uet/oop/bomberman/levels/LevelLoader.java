package uet.oop.bomberman.levels;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.characters.Bomber;
import uet.oop.bomberman.entities.characters.NewBomber;
import uet.oop.bomberman.entities.enemies.Balloon;
import uet.oop.bomberman.entities.enemies.Bat;
import uet.oop.bomberman.entities.items.bomb.SpeedItem;
import uet.oop.bomberman.entities.mapMaterials.Brick;
import uet.oop.bomberman.entities.mapMaterials.Ground;
import uet.oop.bomberman.entities.mapMaterials.Portal;
import uet.oop.bomberman.entities.mapMaterials.Wall;
import uet.oop.bomberman.entities.mapMaterials.border.*;
import uet.oop.bomberman.entities.mapMaterials.sky.Sky;
import uet.oop.bomberman.gameplay.Board;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LevelLoader {
    private Board board;
    private int level;

    public LevelLoader(Board board, int level) {
        this.board = board;
        this.level = level;
    }

    public void loadLevel(int level) {
        try {
            List<Entity> entitiesList = board.getEntitiesList();
            List<Entity> stillObjList = board.getStillObjectsList();
            String path = "res/levels/Level1-" + level + ".txt";
            Scanner scanner = new Scanner(new File(path));
            String _line = scanner.nextLine().trim();
            StringTokenizer _stringTokenizer = new StringTokenizer(_line, " ");
            _stringTokenizer.nextToken().trim();
            int height = Integer.valueOf(_stringTokenizer.nextToken().trim());
            int width = Integer.valueOf(_stringTokenizer.nextToken().trim());
            double tempY = Board.BOARD_COORDINATE_Y;
            while (scanner.hasNextLine()) {
                double tempX = 0;
                String line = scanner.nextLine().trim();
                if (line.equals("the-end")) {
                    break;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                while (stringTokenizer.hasMoreTokens()) {
                    String temp = stringTokenizer.nextToken().trim();
                    if (temp.equals("p")) {
                        addEntity(entitiesList,stillObjList, temp, tempX, tempY);
                    }
                    addEntity(entitiesList,stillObjList,temp,tempX,tempY);
                    tempX++;
                }
                tempY++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void addEntity(List<Entity> mapEntities,List<Entity> notMapEntities,String temp,double tempX,double tempY){
        ArrayList<Entity> arrayEntities;
        switch (temp) {
            case "p":
                mapEntities.add(new Ground(tempX, tempY));
                notMapEntities.add(new NewBomber(tempX, tempY));
                break;
            case "1" :
                mapEntities.add(new Ground(tempX, tempY));
                notMapEntities.add(new Balloon(tempX, tempY));
                break;
            case "2" :
                mapEntities.add(new Ground(tempX, tempY));
                notMapEntities.add(new Bat(tempX, tempY));
                break;
            case "#":
                mapEntities.add(new TopBorder(tempX, tempY));
                break;
            case"t":
                mapEntities.add(new Portal(tempX, tempY));
                break;
            case "l":
                mapEntities.add(new LeftBorder(tempX, tempY));
                break;
            case "r":
                mapEntities.add(new RightBorder(tempX, tempY));
                break;
            case "g":
                mapEntities.add(new Ground(tempX, tempY));
                break;
            case "&":
                mapEntities.add(new BotBorder(tempX, tempY));
                break;
            case "tl":
                mapEntities.add(new TopLeftCorner(tempX, tempY));
                break;
            case "tr":
                mapEntities.add(new TopRightCorner(tempX, tempY));
                break;
            case "bl":
                mapEntities.add(new BotLeftCorner(tempX, tempY));
                break;
            case "br":
                mapEntities.add(new BotRightCorner(tempX, tempY));
                break;
            case"w":
                arrayEntities= new ArrayList<Entity>();
                arrayEntities.add(0,new Ground(tempX,tempY));
                arrayEntities.add(0,new Wall(tempX,tempY));
                mapEntities.add(new LayeredEntity(tempX,tempY,arrayEntities));
                break;
            case"b":
                arrayEntities= new ArrayList<Entity>();
                arrayEntities.add(0,new Ground(tempX,tempY));
                arrayEntities.add(0, new SpeedItem(tempX, tempY));
                arrayEntities.add(0,new Brick(tempX,tempY));
                mapEntities.add(new LayeredEntity(tempX,tempY,arrayEntities));
                break;
            default:
                mapEntities.add(new Sky(tempX,tempY,temp));
        }
    }

}
