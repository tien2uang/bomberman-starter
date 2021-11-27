package uet.oop.bomberman;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mapMaterials.Ground;
import uet.oop.bomberman.entities.mapMaterials.Wall;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;
    

    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);

    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        Game.start();

    }




}
