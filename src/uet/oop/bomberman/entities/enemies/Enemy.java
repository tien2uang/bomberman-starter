package uet.oop.bomberman.entities.enemies;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.audio.Audio;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.NewBomber;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;

import java.util.Random;

public abstract class Enemy extends AnimatedEntity {

    public static double speed;
    public int direction;
    protected int point;

    public final double MAX_UP = 72;
    public double step_Up = 72;
    public final double MAX_DOWN = 72;
    public double step_Down = 72;

    public final double MAX_STEPS = 144;
    public double _steps = 0;
    public int rand = random_();
    public int a = 0;

    public boolean isMovingUP = false;
    public boolean isMovingDOWN = false;
    protected int death_animate = 100;

    public final double temp = 1 / (double) NewSprite.SCALED_SIZE;

    public Enemy(double x, double y, Image image) {
        super(x, y, image);
    }

    public Enemy(double x, double y, double speed_, int point_) {
        super(x,y);
        speed = speed_;
        point = point_;
    }

    @Override
    public void update() {
        if (killed) {
            die();
        } else {
            animate();
            calculateMove();
        }
    }

    @Override
    public void render(GraphicsContext gc) {

        chooseImg();
        gc.drawImage(img, (xUnit ) * 36, (yUnit + Game.INFO_HEIGHT) * 36 );
    }

    public int random_() {
        return new Random().nextInt(2);
    }


    public void move(double xa, double ya) {
        x += xa;
        y += ya;
        xUnit += xa / NewSprite.SCALED_SIZE;
        yUnit += ya / NewSprite.SCALED_SIZE;
    }

    public void calculateMove() {
        double xa = 0, ya = 0;
        if(_steps <= 0){
            rand = random_();
            _steps = MAX_STEPS;
        }

        if(rand == 0) xa -= speed; // left
        if(rand == 1) xa += speed; // right

        if(canMove(rand)) {
            _steps -= speed;
            direction = rand;
            move(xa, ya);

        } else {
            _steps = 0;
        }

        //System.out.println(xUnit + " " + yUnit);
        if (Math.abs(xUnit - (int) xUnit) <= temp) {
            int tempX = (int) xUnit;
            //System.out.println(tempX);

            if (!isMovingDOWN && !isMovingUP) {
                a = new Random().nextInt(2);
            }

            if (tempX % 2 == 0 && a == 0) {
                //System.out.println("up");
                up();
            }

            if (tempX % 2 == 0 && a == 1) {
                //System.out.println("down");
                down();
            }
        }
    }

    public boolean canMove (int rand_) {

//right 1
        if (rand_ == 1) {
            if ((int) yUnit == yUnit) {
                return getAt(xUnit + 1, yUnit);
            }
        }

//left 0
        if (rand_ == 0) {
            if ((int) yUnit == yUnit) {
                return getAt(xUnit, yUnit);
            }
        }
        return false;
    }

    public void up() {
        if (step_Up <= 0) {
            isMovingUP = false;
            step_Up = MAX_UP;
        } else isMovingUP = true;

        if (canUp(xUnit,yUnit - temp ) && isMovingUP) {
            direction = 3;
            move(0,-speed);
            step_Up--;
        } else {
            isMovingUP = false;
            if (Math.abs(yUnit - Math.round(yUnit)) <= temp) {
                yUnit = Math.round(yUnit);
            }
        }
    }

    public void down() {
        if (step_Down <= 0) {
            isMovingDOWN = false;
            step_Down = MAX_DOWN;
        } else isMovingDOWN = true;

        if (canDown(xUnit, yUnit + 1 + temp ) && isMovingDOWN) {
            direction = 2;
            move(0,speed);
            step_Down--;
        } else {
            isMovingDOWN = false;
            if (Math.abs(yUnit - Math.round(yUnit)) <= temp) {
                yUnit = Math.round(yUnit);
            }
        }
    }

    public boolean canUp(double tempX, double tempY) {
        return getAt(tempX, tempY);
    }

    public boolean canDown(double tempX, double tempY) {
        return getAt(tempX, tempY);
    }

    public boolean getAt(double xx, double yy) {
        int a = (int) ( xx);
        int b = (int) ( yy);
        for (Entity entity: Board.getFlames()) {
            if (Math.round(xx) == entity.getXUnit() && Math.round(yy) == entity.getYUnit()) {
                killed();
                Audio.playSound(Audio.enemyDied);
                return false;
            }
        }
        for (Entity entity : Board.getMapEntitiesList()) {
            if(a == (int) entity.getXUnit() && b == (int) entity.getYUnit()) {
                if(this.getLayerPower() >= entity.getLayerPower()) {
                    return true;

                }
            }
        }
        return false;

    }

    public double getXUnitBomber() {
        for (Entity entity : Board.getCharacterList()) {
            if (entity instanceof NewBomber) {
                return entity.getXUnit();
            }
        }
        return -1;
    }

    public double getYUnitBomber() {
        for (Entity entity : Board.getCharacterList()) {
            if (entity instanceof NewBomber) {
                return entity.getYUnit();
            }
        }
        return -1;
    }




    public abstract void chooseImg();

    public void die() {
        if (death_animate > 0) {
            direction = -1;
            animate();
            death_animate--;
        } else {
            this.status = INVALID;
        }
    }

}

