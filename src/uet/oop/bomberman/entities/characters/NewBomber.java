package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.items.bomb.NewBomb;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.input.Keyboard;

import java.util.Vector;

public class NewBomber extends Character {

    public int direction;
    private boolean isMoving;
    public static double speed = 1.8;
    private NewSprite currentSprite;
    public static Vector<Bomb> bombs = new Vector<>();
    private boolean isAlive;

    public NewBomber(double x, double y) {
        super(x, y);
        this.direction = 4;
        this.img = NewSprite.player_down_1.getFxImage();
        this.currentSprite = NewSprite.player_down_1;
        this.animate = 0;
        this.isMoving = false;
        this.layerPower = 2;
        isAlive = true;
    }

    public void move(double p, double q) {


        if (canMove(x, y + q)) {
            y += q;
        }

        if (canMove(x + p, y)) {
            x += p;
        }
    }

    public void calculateMove() {
        double X = 0, Y = 0;
        if (Keyboard.isRight()) {
            direction = 2;
            animate();
            right();
        } else if (Keyboard.isLeft()) {
            direction = 1;
            animate();
            left();
        } else if (Keyboard.isUp()) {

            direction = 3;
            animate();
            up();

        } else if (Keyboard.isDown()) {
            direction = 4;

            animate();
            down();
        }

//        if (X != 0 || Y != 0) {
//            // System.out.println("YES");
//            move(X, Y);
//        }

    }

    public boolean isMoving() {
        if (Keyboard.isLeft() || Keyboard.isRight() || Keyboard.isDown() || Keyboard.isUp()) {
            return true;
        }
        return false;
    }

    public boolean canMove(double xx, double yy) {
        return true;
    }

    public Image chooseImage(int direction) {
        switch (direction) {
            case 1:
                currentSprite = NewSprite.movingSprite(NewSprite.playerLeftList, animate, 33);
                return NewSprite.movingSprite(NewSprite.playerLeftList, animate, 33).getFxImage();
            case 2:
                currentSprite = NewSprite.movingSprite(NewSprite.playerRightList, animate, 33);
                return NewSprite.movingSprite(NewSprite.playerRightList, animate, 33).getFxImage();
            case 3:
                currentSprite = NewSprite.movingSprite(NewSprite.playerUpList, animate, 33);
                return NewSprite.movingSprite(NewSprite.playerUpList, animate, 33).getFxImage();
            case 4:
                currentSprite = NewSprite.movingSprite(NewSprite.playerDownList, animate, 33);
                return NewSprite.movingSprite(NewSprite.playerDownList, animate, 33).getFxImage();
        }
        return null;
    }

    @Override
    public void update() {
        if(Game.currentGameTime==100){
            setAlive(false);
        }
        if (isAlive) {
            if (!isMoving()) {
                animate = 0;
            }

            calculateMove();
            img = chooseImage(direction);

            if (Keyboard.isPlaceBomb()) {
                placeBomb();
                Keyboard.setPlaceBomb();
            }
        } else {
            currentSprite = NewSprite.movingSprite(NewSprite.playerDeadList, animate, 90);
            img=currentSprite.getFxImage();
            animate();
            if(getAnimate()==90){
                this.status=INVALID;
            }
        }
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
        animate = 0;

    }

    public void placeBomb() {
        double x = (this.x + NewSprite.SCALED_SIZE / 2) / NewSprite.SCALED_SIZE;
        double y = (this.y + NewSprite.SCALED_SIZE / 2) / NewSprite.SCALED_SIZE;
        double xUnitToPlace = (double) ((int) x);
        double yUnitToPlace = (double) ((int) y);
        NewBomb bomb = new NewBomb(xUnitToPlace, yUnitToPlace - 1);
        Board.getBombs().add(bomb);
    }

    @Override
    public void render(GraphicsContext gc) {
        double x = this.x - (double) (currentSprite.getDistanceToTopLeftX()) * NewSprite.SCALED_FACTOR;
        double y = this.y - (double) (currentSprite.getDistanceToTopLeftY()) * NewSprite.SCALED_FACTOR;
        gc.drawImage(img, x, y);
    }

    private void up() {
        if ((int) (this.getXUnit()) == this.getXUnit()) {
            if ((int) (this.getYUnit()) == this.getYUnit()) {
                int x = (int) (this.getXUnit());
                int y = (int) (this.getYUnit());
                if (canCrossOver(Board.getMostPoweredEntityAt((double) x, (double) (y - 1)))) {
                    this.y -= speed;
                    double temp = speed / (double) NewSprite.SCALED_SIZE;
                    this.yUnit -= temp;
                }
            } else {
                this.y -= speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.yUnit -= temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }
        } else {
            int tempX = (int) (this.getXUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) tempX, this.getYUnit() - 1))) {
                this.x -= speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.xUnit -= temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) NewSprite.SCALED_SIZE;
                }
            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) (tempX + 1), this.getYUnit() - 1))) {
                this.x += speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.xUnit += temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) NewSprite.SCALED_SIZE;
                }
            }

        }
    }

    private void down() {
        if ((int) (this.getXUnit()) == this.getXUnit()) {
            if ((int) (this.getYUnit()) == this.getYUnit()) {
                int x = (int) (this.getXUnit());
                int y = (int) (this.getYUnit());
                if (canCrossOver(Board.getMostPoweredEntityAt((double) x, (double) (y + 1)))) {
                    this.y += speed;
                    double temp = speed / (double) NewSprite.SCALED_SIZE;
                    this.yUnit += temp;
                }
            } else {
                this.y += speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.yUnit += temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }
        } else {
            int tempX = (int) (this.getXUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) tempX, this.getYUnit() + 1))) {
                this.x -= speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.xUnit -= temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) NewSprite.SCALED_SIZE;
                }
            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) (tempX + 1), this.getYUnit() + 1))) {
                this.x += speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.xUnit += temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) NewSprite.SCALED_SIZE;
                }
            }
        }

    }

    private void left() {
        if ((int) (this.getYUnit()) == this.getYUnit()) {
            if ((int) (this.getXUnit()) == this.getXUnit()) {
                int x = (int) (this.getXUnit());
                int y = (int) (this.getYUnit());
                if (canCrossOver(Board.getMostPoweredEntityAt((double) (x - 1), (double) (y)))) {
                    this.x -= speed;
                    double temp = speed / (double) NewSprite.SCALED_SIZE;
                    this.xUnit -= temp;
                }
            } else {
                this.x -= speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.xUnit -= temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = (xUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }
        } else {
            int tempY = (int) (this.getYUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() - 1, tempY))) {
                this.y -= speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.yUnit -= temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }

            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() - 1, tempY + 1))) {
                this.y += speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.yUnit += temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }
        }
    }

    private void right() {
        if ((int) (this.getYUnit()) == this.getYUnit()) {
            if ((int) (this.getXUnit()) == this.getXUnit()) {
                int x = (int) (this.getXUnit());
                int y = (int) (this.getYUnit());
                if (canCrossOver(Board.getMostPoweredEntityAt((double) (x + 1), (double) (y)))) {
                    this.x += speed;
                    double temp = speed / (double) NewSprite.SCALED_SIZE;
                    this.xUnit += temp;
                }

            } else {
                this.x += speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.xUnit += temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = (xUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }

        } else {
            int tempY = (int) (this.getYUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() + 1, tempY))) {
                this.y -= speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.yUnit -= temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }

            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() + 1, tempY + 1))) {
                this.y += speed;
                double temp = speed / (double) NewSprite.SCALED_SIZE;
                this.yUnit += temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }
        }

    }

}
