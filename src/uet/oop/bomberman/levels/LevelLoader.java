package uet.oop.bomberman.levels;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.characters.NewBomber;
import uet.oop.bomberman.entities.enemies.*;
import uet.oop.bomberman.entities.items.buff.BombItem;
import uet.oop.bomberman.entities.items.buff.FlameItem;
import uet.oop.bomberman.entities.items.buff.SpeedItem;
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



    public LevelLoader() {


    }

    public void loadLevel(int level) {
        try {
            List<Entity> entitiesList = Board.getMapEntitiesList();
            List<Entity> stillObjList = Board.getCharacterList();
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
            case "3" :
                mapEntities.add(new Ground(tempX, tempY));
                notMapEntities.add(new Ghost(tempX, tempY));
                break;
            case "4" :
                mapEntities.add(new Ground(tempX, tempY));
                notMapEntities.add(new Eye(tempX, tempY));
                break;
            case "5" :
                mapEntities.add(new Ground(tempX, tempY));
                notMapEntities.add(new Oneal(tempX, tempY));
                break;
            case "#":
                mapEntities.add(new TopBorder(tempX, tempY));
                break;
            case"t":
                arrayEntities= new ArrayList<Entity>();
                arrayEntities.add(0,new Portal(tempX,tempY));
                arrayEntities.add(0,new Brick(tempX,tempY));
                mapEntities.add(new LayeredEntity(tempX,tempY,arrayEntities));
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
            case"s":
                arrayEntities= new ArrayList<Entity>();
                arrayEntities.add(0,new Ground(tempX,tempY));
                arrayEntities.add(0, new SpeedItem(tempX, tempY));
                arrayEntities.add(0,new Brick(tempX,tempY));
                mapEntities.add(new LayeredEntity(tempX,tempY,arrayEntities));
                break;
            case"b":
                arrayEntities= new ArrayList<Entity>();
                arrayEntities.add(0,new Ground(tempX,tempY));
                arrayEntities.add(0,new Brick(tempX,tempY));
                mapEntities.add(new LayeredEntity(tempX,tempY,arrayEntities));
                break;
            case"f":
                arrayEntities= new ArrayList<Entity>();
                arrayEntities.add(0,new Ground(tempX,tempY));
                arrayEntities.add(0, new FlameItem(tempX, tempY));
                arrayEntities.add(0,new Brick(tempX,tempY));
                mapEntities.add(new LayeredEntity(tempX,tempY,arrayEntities));
                break;
            case"i":
                arrayEntities= new ArrayList<Entity>();
                arrayEntities.add(0,new Ground(tempX,tempY));
                arrayEntities.add(0, new BombItem(tempX, tempY));
                arrayEntities.add(0,new Brick(tempX,tempY));
                mapEntities.add(new LayeredEntity(tempX,tempY,arrayEntities));
                break;
            default:
                mapEntities.add(new Sky(tempX,tempY,temp));
        }
    }

}
