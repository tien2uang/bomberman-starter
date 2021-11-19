package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected double x;
    protected int status;
    public static final int VALID=0;
    public static final int INVALID=1;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected double y;

    protected Image img;
    public int layerPower=0;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( double xUnit, double yUnit, Image img) {
        this.x = xUnit * NewSprite.SCALED_SIZE;
        this.y = yUnit * NewSprite.SCALED_SIZE;
        this.img = img;
        this.status=VALID;
    }
    public Entity(double xUnit, double yUnit){
        this.x = xUnit * NewSprite.SCALED_SIZE;
        this.y = yUnit * NewSprite.SCALED_SIZE;
        this.status=VALID;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();

    public int getStatus() {
        return status;
    }
}
