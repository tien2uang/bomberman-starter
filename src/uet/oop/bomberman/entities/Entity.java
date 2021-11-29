package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.NewSprite;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected double x;
    protected int status;
    public static final int VALID = 0;
    public static final int INVALID = 1;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected double y;
    protected double xUnit;
    protected double yUnit;

    protected Image img;
    public double layerPower = 0;
    public boolean removeBomb = false;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity(double xUnit, double yUnit, Image img) {
        this.x = xUnit * NewSprite.SCALED_SIZE;
        this.y = yUnit * NewSprite.SCALED_SIZE;
        this.img = img;
        this.status = VALID;
    }

    public Entity(double xUnit, double yUnit) {
        this.x = xUnit * NewSprite.SCALED_SIZE;
        this.y = yUnit * NewSprite.SCALED_SIZE;
        this.status = VALID;
        this.xUnit = xUnit;
        this.yUnit = Coordinate.canvasToBoardTileY(yUnit);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getXUnit() {
        return xUnit;
    }

    public double getYUnit() {
        return yUnit;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void update();

    public int getStatus() {
        return status;
    }

    public double getLayerPower() {
        return layerPower;
    }

    public boolean canCrossOver(Entity entity) {
        return this.layerPower >= entity.getLayerPower();
    }

    public boolean isRemoveBomb() {
        return removeBomb;
    }

    public Entity getMostPoweredEntity() {
        return this;
    }

}
