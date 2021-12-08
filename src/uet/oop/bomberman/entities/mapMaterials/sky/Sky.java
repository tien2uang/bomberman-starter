package uet.oop.bomberman.entities.mapMaterials.sky;

import uet.oop.bomberman.entities.StaticEntity;
import uet.oop.bomberman.graphics.Sprite;

public class Sky extends StaticEntity {
    public Sky(double x, double y, String name) {
        super(x, y);
        this.layerPower=5;
        switch (name) {
            case "l1":
                this.img = Sprite.sky_left_1.getFxImage();
                break;
            case "l2":
                this.img = Sprite.sky_left_2.getFxImage();
                break;
            case "l3":
                this.img = Sprite.sky_left_3.getFxImage();
                break;
            case "l4":
                this.img = Sprite.sky_left_4.getFxImage();
                break;
            case "l5":
                this.img = Sprite.sky_left_5.getFxImage();
                break;
            case "l6":
                this.img = Sprite.sky_left_6.getFxImage();
                break;
            case "l7":
                this.img = Sprite.sky_left_7.getFxImage();
                break;
            case "l8":
                this.img = Sprite.sky_left_8.getFxImage();
                break;
            case "l9":
                this.img = Sprite.sky_left_9.getFxImage();
                break;
            case "l10":
                this.img = Sprite.sky_left_10.getFxImage();
                break;
            case "r1":
                this.img = Sprite.sky_right_1.getFxImage();
                break;
            case "r2":
                this.img = Sprite.sky_right_2.getFxImage();
                break;
            case "r3":
                this.img = Sprite.sky_right_3.getFxImage();
                break;
            case "r4":
                this.img = Sprite.sky_right_4.getFxImage();
                break;
            case "r5":
                this.img = Sprite.sky_right_5.getFxImage();
                break;
            case "r6":
                this.img = Sprite.sky_right_6.getFxImage();
                break;
            case "r7":
                this.img = Sprite.sky_right_7.getFxImage();
                break;
            case "r8":
                this.img = Sprite.sky_right_8.getFxImage();
                break;
            case "r9":
                this.img = Sprite.sky_right_9.getFxImage();
                break;
            case "r10":
                this.img = Sprite.sky_right_10.getFxImage();
                break;


        }
    }

    @Override
    public void update() {

    }
}
