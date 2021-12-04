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
    public static final double INFO_HEIGHT = 2;
    public static final double WIDTH = BOARD_WIDTH;
    public static final double HEIGHT = BOARD_HEIGHT + INFO_HEIGHT;
    public static Stage stage = BombermanGame.getPrimaryStage();
    private static AnimationTimer timer;
    public static long currentGameTime = 0;
    public static int currentLevel = 1;
    public static long frameTime = 0;
    private static long count = 0;
    private static boolean isPaused = false;
    protected static boolean isInGame = false;
    public static boolean gameOver = false;
    protected static GraphicsContext gc;
    protected static Canvas canvas;
    private static LevelLoader levelLoader = new LevelLoader();
    public static int score=0;

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
        //init Board,Info
        Board b = new Board();
        Info info = new Info();

        currentGameTime = 0;

        Keyboard.keyboardHandle(scene);
        loadLevel(currentLevel);
        timer = new AnimationTimer() {

            @Override
            public void handle(long l) {


                if (!isPaused) {
                    frameTime++;
                    currentGameTime = frameTime / 60;

                }
                if (!gameOver) {
                    if (isIsInGame()) {
                        if (!isPaused) {

                            render();
                            update();
                        }
                    }
                    else{
                        render();
                        update();
                    }
                }
                else{
                    gc.drawImage(NewSprite.game_over.getFxImage(),36*17/2-105,36*7 );
                }

            }
        };
        timer.start();


    }
    public static void restart(){
        clear();
        currentGameTime = 0;
        frameTime=0;
        currentLevel=1;
        isInGame = false;
        score=0;
        isPaused = false;
        gameOver = false;
        Board.restart();

    }
    private static void update() {
        Board.update();
        Info.update();
    }

    public static void loadLevel(int level) {
        levelLoader.loadLevel(level);
    }

    private static void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Board.render();
        Info.render();

    }
    public static void clear(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public static boolean isIsInGame() {
        return isInGame;
    }

    public static void setIsInGame(boolean isInGame) {
        Game.isInGame = isInGame;
    }

    public static boolean isIsPaused() {
        return isPaused;
    }

    public static void setIsPaused(boolean isPaused) {
        Game.isPaused = isPaused;
    }
}
