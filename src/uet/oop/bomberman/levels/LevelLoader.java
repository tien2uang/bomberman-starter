package uet.oop.bomberman.levels;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.mapMaterials.Brick;
import uet.oop.bomberman.entities.mapMaterials.Ground;
import uet.oop.bomberman.entities.mapMaterials.Wall;
import uet.oop.bomberman.entities.mapMaterials.border.*;
import uet.oop.bomberman.entities.mapMaterials.sky.Sky;
import uet.oop.bomberman.gameplay.Board;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

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
                    addEntity(entitiesList,temp,tempX,tempY);
                    tempX++;
                }
                tempY++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void addEntity(List<Entity> entitiesList,String temp,double tempX,double tempY){
        Stack<Entity>stackEntities;
        switch (temp) {

            case "#":
                entitiesList.add(new TopBorder(tempX, tempY));
                break;
            case "l":
                entitiesList.add(new LeftBorder(tempX, tempY));
                break;
            case "r":
                entitiesList.add(new RightBorder(tempX, tempY));
                break;
            case "g":
                entitiesList.add(new Ground(tempX, tempY));
                break;
            case "&":
                entitiesList.add(new BotBorder(tempX, tempY));
                break;
            case "tl":
                entitiesList.add(new TopLeftCorner(tempX, tempY));
                break;
            case "tr":
                entitiesList.add(new TopRightCorner(tempX, tempY));
                break;
            case "bl":
                entitiesList.add(new BotLeftCorner(tempX, tempY));
                break;
            case "br":
                entitiesList.add(new BotRightCorner(tempX, tempY));
                break;
            case"w":
                stackEntities= new Stack<Entity>();
                stackEntities.push(new Ground(tempX,tempY));
                stackEntities.push(new Wall(tempX,tempY));
                entitiesList.add(new LayeredEntity(tempX,tempY,stackEntities));
                break;
            case"b":
                stackEntities= new Stack<Entity>();
                stackEntities.push(new Ground(tempX,tempY));
                stackEntities.push(new Brick(tempX,tempY));
                entitiesList.add(new LayeredEntity(tempX,tempY,stackEntities));
            default:
                entitiesList.add(new Sky(tempX,tempY,temp));
        }
    }
}
