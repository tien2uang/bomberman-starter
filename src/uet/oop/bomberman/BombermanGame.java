package uet.oop.bomberman;

import javafx.application.Application;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.gameplay.Game;

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
