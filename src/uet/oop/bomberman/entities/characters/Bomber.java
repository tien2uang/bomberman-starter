package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.items.bomb.Bomb;
import uet.oop.bomberman.entities.mapMaterials.Portal;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.Keyboard;

import static uet.oop.bomberman.gameplay.Board.BOMBER_FAST_SPEED;
import static uet.oop.bomberman.gameplay.Board.BOMBER_SPEED;

public class Bomber extends Character {

    public int direction;
    private boolean isMoving;
    private Sprite currentSprite;

    public int speedItem_animation = 600;
    public static int bombQuantity;

    public Bomber(double x, double y) {
        super(x, y);
        this.direction = 4;
        this.img = Sprite.player_down_1.getFxImage();
        this.currentSprite = Sprite.player_down_1;
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
            if (!(entity instanceof Bomber)) {
                double x = this.getXUnit() - entity.getXUnit();
                double y = this.getYUnit() - entity.getYUnit();
                if ((int)this.getXUnit() == entity.getXUnit()) {
                    if (0 <= Math.abs(y) && Math.abs(y) < 1) {
                        setAlive(false);
                        Audio.playSound(Audio.bomberDied);
                    }
                } else if ((int)this.getYUnit() == entity.getYUnit()) {
                    if (0 <= Math.abs(x) && Math.abs(x) < 1) {
                        setAlive(false);
                        Audio.playSound(Audio.bomberDied);
                    }
                }

            }
        }
        for (Entity entity: Board.getFlames()) {
            double x = this.getXUnit() - entity.getXUnit();
            double y = this.getYUnit() - entity.getYUnit();
            if ((int)this.getXUnit() == entity.getXUnit()) {
                if (0 <= Math.abs(y) && Math.abs(y) < 1) {
                    setAlive(false);
                    Audio.playSound(Audio.bomberDied);
                    return;
                }
            } else if ((int)this.getYUnit() == entity.getYUnit()) {
                if (0 <= Math.abs(x) && Math.abs(x) < 1) {
                    setAlive(false);
                    Audio.playSound(Audio.bomberDied);
                    return;
                }
            }
            /*if (Math.round(this.getXUnit()) == entity.getXUnit() && Math.round(this.getYUnit()) == entity.getYUnit()) {
                isAlive = false;
            }*/
        }
        //collide with portal
        double x = (this.x + Sprite.SCALED_SIZE / 2) / Sprite.SCALED_SIZE;
        double y = (this.y + Sprite.SCALED_SIZE / 2) / Sprite.SCALED_SIZE;
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
            case 1:
                currentSprite = Sprite.movingSprite(Sprite.playerLeftList, animate, 33);
                return Sprite.movingSprite(Sprite.playerLeftList, animate, 33).getFxImage();
            case 2:
                currentSprite = Sprite.movingSprite(Sprite.playerRightList, animate, 33);
                return Sprite.movingSprite(Sprite.playerRightList, animate, 33).getFxImage();
            case 3:
                currentSprite = Sprite.movingSprite(Sprite.playerUpList, animate, 33);
                return Sprite.movingSprite(Sprite.playerUpList, animate, 33).getFxImage();
            case 4:
                currentSprite = Sprite.movingSprite(Sprite.playerDownList, animate, 33);
                return Sprite.movingSprite(Sprite.playerDownList, animate, 33).getFxImage();
        }
        return null;
    }

    @Override
    public void update() {
        if (isAlive) {
            if (!isMoving()) {
                animate = 0;
            }
            collide();
            calculateMove();
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
                currentSprite = Sprite.movingSprite(Sprite.playerDeadList, animate, 60);
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
        double x = (this.x + Sprite.SCALED_SIZE / 2) / Sprite.SCALED_SIZE;
        double y = (this.y + Sprite.SCALED_SIZE / 2) / Sprite.SCALED_SIZE;
        double xUnitToPlace = (double) ((int) x);
        double yUnitToPlace = (double) ((int) y);
        Bomb bomb;
        if (Board.getBombQuantity() > 0) {
            Audio.playSound(Audio.placeBomb);
            if (Board.flameItem_quantity != 0) {
                bomb = new Bomb(xUnitToPlace, yUnitToPlace - Game.INFO_HEIGHT, 1);
                Board.flameItem_quantity--;
            } else {
                bomb = new Bomb(xUnitToPlace, yUnitToPlace - Game.INFO_HEIGHT);
            }
            Board.getBombs().add(bomb);
            Board.bombQuantity--;
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        double x = this.x - (double) (currentSprite.getDistanceToTopLeftX()) * Sprite.SCALED_FACTOR;
        double y = this.y - (double) (currentSprite.getDistanceToTopLeftY()) * Sprite.SCALED_FACTOR;
        gc.drawImage(img, x, y);
    }

    private void up() {
        if ((int) (this.getXUnit()) == this.getXUnit()) {
            if ((int) (this.getYUnit()) == this.getYUnit()) {
                int x = (int) (this.getXUnit());
                int y = (int) (this.getYUnit());
                if (canCrossOver(Board.getMostPoweredEntityAt((double) x, (double) (y - 1)))) {
                    this.y -= Board.getBomberSpeed();
                    double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                    this.yUnit -= temp;
                }
            } else {
                this.y -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.yUnit -= temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) Sprite.SCALED_SIZE;
                }
            }
        } else {
            int tempX = (int) (this.getXUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) tempX, this.getYUnit() - 1))) {
                this.x -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.xUnit -= temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) Sprite.SCALED_SIZE;
                }
            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) (tempX + 1), this.getYUnit() - 1))) {
                this.x += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.xUnit += temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) Sprite.SCALED_SIZE;
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
                    double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                    this.yUnit += temp;
                }
            } else {
                this.y += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.yUnit += temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) Sprite.SCALED_SIZE;
                }
            }
        } else {
            int tempX = (int) (this.getXUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) tempX, this.getYUnit() + 1))) {
                this.x -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.xUnit -= temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) Sprite.SCALED_SIZE;
                }
            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) (tempX + 1), this.getYUnit() + 1))) {
                this.x += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.xUnit += temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = xUnit * (double) Sprite.SCALED_SIZE;
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
                    double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                    this.xUnit -= temp;
                }
            } else {
                this.x -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.xUnit -= temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = (xUnit) * (double) Sprite.SCALED_SIZE;
                }
            }
        } else {
            int tempY = (int) (this.getYUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() - 1, tempY))) {
                this.y -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.yUnit -= temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) Sprite.SCALED_SIZE;
                }

            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() - 1, tempY + 1))) {
                this.y += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.yUnit += temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) Sprite.SCALED_SIZE;
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
                    double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                    this.xUnit += temp;
                }

            } else {
                this.x += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.xUnit += temp;
                if (Math.abs(this.xUnit - Math.round(this.xUnit)) <= temp) {
                    this.xUnit = (double) Math.round(this.xUnit);
                    this.x = (xUnit) * (double) Sprite.SCALED_SIZE;
                }
            }

        } else {
            int tempY = (int) (this.getYUnit());
            if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() + 1, tempY))) {
                this.y -= Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.yUnit -= temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) Sprite.SCALED_SIZE;
                }

            } else if (canCrossOver(Board.getMostPoweredEntityAt((double) this.getXUnit() + 1, tempY + 1))) {
                this.y += Board.getBomberSpeed();
                double temp = Board.getBomberSpeed() / (double) Sprite.SCALED_SIZE;
                this.yUnit += temp;
                if (Math.abs(this.yUnit - Math.round(this.yUnit)) <= temp) {
                    this.yUnit = (double) Math.round(this.yUnit);
                    this.y = (Game.INFO_HEIGHT + yUnit) * (double) Sprite.SCALED_SIZE;
                }
            }
        }

    }

    public void pickUpItem() {
        if (Board.speedItemTime != 0) {
            Board.bomberSpeed=BOMBER_FAST_SPEED;
        }
        else
        {
            Board.bomberSpeed=BOMBER_SPEED;
        }
    }

}
