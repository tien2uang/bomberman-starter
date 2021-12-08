package uet.oop.bomberman.entities.enemies;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Character;
import uet.oop.bomberman.gameplay.Board;
import uet.oop.bomberman.gameplay.Game;
import uet.oop.bomberman.graphics.NewSprite;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.input.Keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Balloon extends Enemy {


    public Balloon(double x, double y) {
        super(x, y, 0.5, 100);
        img = NewSprite.balloon_right.getFxImage();
        this.layerPower = 2.5;
        this.animate = 0;
        this.direction = 1;
        this._steps = 0;
    }

    @Override
    public void chooseImg() {
        if (direction == -1) img = NewSprite.movingSprite(NewSprite.balloonDeadList, getAnimate(), 51).getFxImage();
        if (direction == 0) img = NewSprite.movingSprite(NewSprite.BalloonLeftList,getAnimate(),30).getFxImage();
        if (direction == 1) img = NewSprite.movingSprite(NewSprite.BalloonRightList,getAnimate(),30).getFxImage();
        if (direction == 2) img = NewSprite.movingSprite(NewSprite.BalloonLeftList,getAnimate(),30).getFxImage();
        if (direction == 3) img = NewSprite.movingSprite(NewSprite.BalloonRightList,getAnimate(),30).getFxImage();
    }


}