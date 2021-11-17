package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.characters.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mapMaterials.Grass;
import uet.oop.bomberman.entities.mapMaterials.Wall;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;
    
    private GraphicsContext gc;
    private Canvas canvas;
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
//        // Tao Canvas
//        canvas = new Canvas(NewSprite.SCALED_SIZE * WIDTH, NewSprite.SCALED_SIZE * HEIGHT);
//        gc = canvas.getGraphicsContext2D();
//
//        // Tao root container
//        Group root = new Group();
//        root.getChildren().add(canvas);
//
//        // Tao scene
//        Scene scene = new Scene(root);
//
//        // Them scene vao stage
//        stage.setScene(scene);
//        stage.show();
//
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                render();
//                update();
//            }
//        };
//        timer.start();
//
//        createMap();
//
//        //Entity bomberman = new Bomber(1, 1, NewSprite.portal_7.getFxImage());
//        Entity wall= new Wall(2,1,NewSprite.wall.getFxImage());
//
//
//        entities.add(wall);
//    //    entities.add(bomberman);
        Game.start();
    }

    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, NewSprite.wall.getFxImage());
                }
                else {
                    object = new Grass(i, j, NewSprite.ground.getFxImage());
                }
                stillObjects.add(object);
            }
        }
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
