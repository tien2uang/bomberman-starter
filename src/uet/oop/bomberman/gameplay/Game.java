package uet.oop.bomberman.gameplay;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.input.Keyboard;
import uet.oop.bomberman.levels.LevelLoader;

public class Game {
    public static final double BOARD_WIDTH = 17;
    public static final double BOARD_HEIGHT = 13;
    public static final double INFO_WIDTH = 17;
    public static final double INFO_HEIGHT = 1;
    public static final double WIDTH = BOARD_WIDTH;
    public static final double HEIGHT = BOARD_HEIGHT + INFO_HEIGHT;
    public static Stage stage = BombermanGame.getPrimaryStage();
    private static AnimationTimer timer;
    public static long currentGameTime = 0;
    private static long startNanoTime;
    private static long count = 0;
    private static boolean isPaused = false;

    protected static GraphicsContext gc;
    protected static Canvas canvas;
    private static LevelLoader levelLoader = new LevelLoader(new Board(),1);



    public static void start() {
        canvas = new Canvas(NewSprite.SCALED_SIZE * WIDTH, NewSprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        currentGameTime = 0;

        Keyboard.keyboardHandle(scene);
        loadLevel(1);
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if ((l - startNanoTime) / (1000000000 / 60) > currentGameTime) {
                    if (isPaused) {
                        startNanoTime += (1000000000 / 60);
                    } else {
                        ++currentGameTime;
                    }
                }
                if (!isPaused) {

                    render();
                    update();
                }


            }
        };
        timer.start();
        System.out.println(Board.getMostPoweredEntityAt(0,0));

    }

    private static void update() {
        Board.update();
    }
    public static void loadLevel(int level){
        levelLoader.loadLevel(1);
    }
    private static void render() {
        Board.render();
    }
}
