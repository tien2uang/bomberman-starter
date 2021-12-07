package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Coordinate;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.items.bomb.NewBomb;
import uet.oop.bomberman.entities.items.buff.SpeedItem;
import uet.oop.bomberman.entities.mapMaterials.Portal;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.Keyboard;

import java.awt.*;
import java.util.Vector;

public class NewBomber extends Character {

    public int direction;
    private boolean isMoving;
    private NewSprite currentSprite;
    public static Vector<Bomb> bombs = new Vector<>();
    public int speedItem_animation = 600;
    public static int bombQuantity;

    public NewBomber(double x, double y) {
        super(x, y);
        this.direction = 4;
        this.img = NewSprite.player_down_1.getFxImage();
        this.currentSprite = NewSprite.player_down_1;
        this.animate = 0;
        this.isMoving = false;
        this.layerPower = 2;
        isAlive = true;
        bombQuantity = Board.getBombQuantity();
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



    }

    public boolean isMoving() {
        if (Keyboard.isLeft() || Keyboard.isRight() || Keyboard.isDown() || Keyboard.isUp()) {
            return true;
        }
        return false;
    }

    public void collide() {
        for (Entity entity: Board.getCharacterList()) {
            if (!(entity instanceof NewBomber)) {
                double x = this.getXUnit() - entity.getXUnit();
                double y = this.getYUnit() - entity.getYUnit();
                if ((int)this.getXUnit() == entity.getXUnit()) {
                    if (0 <= Math.abs(y) && Math.abs(y) < 1) {
                        isAlive = false;
                    }
                } else if ((int)this.getYUnit() == entity.getYUnit()) {
                    if (0 <= Math.abs(x) && Math.abs(x) < 1) {
                        isAlive = false;
                    }
                }
                /*if (Math.round(this.getXUnit()) == Math.round(entity.getXUnit()) && Math.round(this.getYUnit()) == Math.round(entity.getYUnit())) {
                    isAlive = false;
                }*/
            }
        }
        for (Entity entity: Board.getFlames()) {
            double x = this.getXUnit() - entity.getXUnit();
            double y = this.getYUnit() - entity.getYUnit();
            if ((int)this.getXUnit() == entity.getXUnit()) {
                if (0 <= Math.abs(y) && Math.abs(y) < 1) {
                    isAlive = false;
                }
            } else if ((int)this.getYUnit() == entity.getYUnit()) {
                if (0 <= Math.abs(x) && Math.abs(x) < 1) {
                    isAlive = false;
                }
            }
            /*if (Math.round(this.getXUnit()) == entity.getXUnit() && Math.round(this.getYUnit()) == entity.getYUnit()) {
                isAlive = false;
            }*/
        }
        //collide with portal
        double x = (this.x + NewSprite.SCALED_SIZE / 2) / NewSprite.SCALED_SIZE;
        double y = (this.y + NewSprite.SCALED_SIZE / 2) / NewSprite.SCALED_SIZE;
        double xUnit = (double) ((int) x);
        double yUnit = (double) ((int) y);
        if(Board.getMostPoweredEntityAt(xUnit, yUnit-Game.INFO_HEIGHT) instanceof Portal) {

            if(Board.hasKilledAllEnemies()){
                if(!Board.hasWon){
                    Board.wonTime=Game.frameTime;
                    Board.hasWon=true;
                    System.out.println("won");
                }




                ///next level
            }
        }

    }

    public Image chooseImage(int direction) {
        switch (direction) {
            case -1:
                currentSprite = NewSprite.movingSprite(NewSprite.frogList, animate, 33);
                return NewSprite.movingSprite(NewSprite.frogList, animate, 33).getFxImage();
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
        if (isAlive) {
            if (!isMoving()) {
                animate = 0;
            }
            calculateMove();
            collide();
            pickUpItem();
            img = chooseImage(direction);
            if (Keyboard.isPlaceBomb()) {
                placeBomb();
                Keyboard.setNotPlaceBomb();
            }
        } else {
            animate();
            if(animate<=59)
            {
                currentSprite = NewSprite.movingSprite(NewSprite.playerDeadList, animate, 60);
                img=currentSprite.getFxImage();
            }
            else{
                img=null;
                if(getAnimate()==60+60){
                    this.status=INVALID;
                    Board.isBomberAlive=isAlive;
                }
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
        NewBomb bomb;
        if (Board.getBombQuantity() > 0) {
            if (Board.flameItem_quantity != 0) {
                bomb = new NewBomb(xUnitToPlace, yUnitToPlace - Game.INFO_HEIGHT, 1);
                Board.flameItem_quantity--;
            } else {
                bomb = new NewBomb(xUnitToPlace, yUnitToPlace - Game.INFO_HEIGHT);
            }
            Board.getBombs().add(bomb);
            Board.bombQuantity--;
        }
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
                    this.y -= Board.getBomberSpeed();
                    double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                    this.yUnit -= temp;
                }
            } else {
                this.y -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                this.yUnit -= temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }
        } else {
            int tempX = (int) (this.getXUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) tempX, this.getYUnit() - 1))) {
                this.x -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                this.xUnit -= temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) NewSprite.SCALED_SIZE;
                }
            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) (tempX + 1), this.getYUnit() - 1))) {
                this.x += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
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
                    this.y += Board.getBomberSpeed();
                    double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                    this.yUnit += temp;
                }
            } else {
                this.y += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                this.yUnit += temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }
        } else {
            int tempX = (int) (this.getXUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) tempX, this.getYUnit() + 1))) {
                this.x -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                this.xUnit -= temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) NewSprite.SCALED_SIZE;
                }
            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) (tempX + 1), this.getYUnit() + 1))) {
                this.x += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
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
                    this.x -= Board.getBomberSpeed();
                    double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                    this.xUnit -= temp;
                }
            } else {
                this.x -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                this.xUnit -= temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = (xUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }
        } else {
            int tempY = (int) (this.getYUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() - 1, tempY))) {
                this.y -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                this.yUnit -= temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }

            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() - 1, tempY + 1))) {
                this.y += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
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
                    this.x += Board.getBomberSpeed();
                    double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                    this.xUnit += temp;
                }

            } else {
                this.x += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                this.xUnit += temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = (xUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }

        } else {
            int tempY = (int) (this.getYUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() + 1, tempY))) {
                this.y -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                this.yUnit -= temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }

            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() + 1, tempY + 1))) {
                this.y += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) NewSprite.SCALED_SIZE;
                this.yUnit += temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) NewSprite.SCALED_SIZE;
                }
            }
        }

    }

    public void pickUpItem() {
        if (Board.speedItem_quantity != 0) {
            if (speedItem_animation > 0) {
                speedItem_animation--;
            } else {
                Board.bomberSpeed = Board.BOMBER_SPEED;
                Board.speedItem_quantity = 0;
            }
        }
    }

}
