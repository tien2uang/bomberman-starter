package uet.oop.bomberman.graphics;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;


public class NewSprite {

    private static final int SIZE = 16;
    public static final int SCALED_SIZE = SIZE * 36 / 16;
    public static double SCALED_FACTOR = 2.25;
    private int distanceToTopLeftX;
    private int distanceToTopLeftY;
    private Image image;
    private String name;//tạm thời


    public NewSprite(int originalSize, int distanceToTopLeftX, int distanceToTopLeftY, String name) {
        String path = "./newsprites/" + name + ".png";

        try {
            image = new Image(path, SCALED_SIZE, SCALED_SIZE, false, false);
        } catch (Exception e) {

            System.out.println("khong tim thay file sprite " + name);
        }
        this.distanceToTopLeftX = distanceToTopLeftX;
        this.distanceToTopLeftY = distanceToTopLeftY;
        this.name = name;
    }

    public NewSprite(int originalSize, int distanceToTopLeftX, int distanceToTopLeftY, double originalWidth, double originalHeight, String name) {
        String path = "./newsprites/" + name + ".png";
        try {
            image = new Image(path, (double) (originalWidth) * SCALED_FACTOR, (double) (originalHeight) * SCALED_FACTOR, false, false);

        } catch (Exception e) {

            System.out.println("khong tim thay file sprite " + name);
        }
        this.distanceToTopLeftX = distanceToTopLeftX;
        this.distanceToTopLeftY = distanceToTopLeftY;
        this.name = name;

    }

    public NewSprite(double originalWidth, double originalHeight, String name) {
        String path;
        if (name.length() == 1) {
            path = "./newsprites/digits/" + name + ".png";
        } else {
            path = "./newsprites/InfoBar/" + name + ".png";
        }
        try {
            image = new Image(path, (double) (originalWidth) * SCALED_FACTOR, (double) (originalHeight) * SCALED_FACTOR, false, false);

        } catch (Exception e) {

            System.out.println("khong tim thay file sprite " + name);
        }
        this.name = name;
        this.distanceToTopLeftX = 0;
        this.distanceToTopLeftY = 0;
    }


    public String getName() {
        return name;
    }

    public Image getFxImage() {
        return image;
    }

    /**
     * map materials
     */

    //bomb
    public static NewSprite bomb_exploded = new NewSprite(SIZE, 0, 0, "bomb-exploded");
    public static NewSprite bomb_exploded_1 = new NewSprite(SIZE, 0, 0, "bomb-exploded1");
    public static NewSprite bomb_exploded_2 = new NewSprite(SIZE, 0, 0, "bomb-exploded2");
    public static NewSprite bomb_exploded_3 = new NewSprite(SIZE, 0, 0, "bomb-exploded3");
    public static NewSprite bomb_exploded_4 = new NewSprite(SIZE, 0, 0, "bomb-exploded4");

    public static ArrayList<NewSprite> bombExplosionCentral = new ArrayList<NewSprite>(Arrays.asList(bomb_exploded, bomb_exploded_1, bomb_exploded_2, bomb_exploded_3, bomb_exploded_4
    ));
    public static ArrayList<NewSprite> newBombExplosionCentral = new ArrayList<NewSprite>(Arrays.asList(
            bomb_exploded, bomb_exploded_1, bomb_exploded_2, bomb_exploded_3, bomb_exploded_4,
            bomb_exploded_3, bomb_exploded_2, bomb_exploded_1, bomb_exploded
    ));

    public static NewSprite bomb1_1 = new NewSprite(SIZE, 0, 0, "1-bomb-1");
    public static NewSprite bomb1_2 = new NewSprite(SIZE, 0, 0, "1-bomb-2");
    public static NewSprite bomb1_3 = new NewSprite(SIZE, 0, 0, "1-bomb-3");

    public static NewSprite bomb2_1 = new NewSprite(SIZE, 0, 0, "2-bomb-1");
    public static NewSprite bomb2_2 = new NewSprite(SIZE, 0, 0, "2-bomb-2");
    public static NewSprite bomb2_3 = new NewSprite(SIZE, 0, 0, "2-bomb-3");

    public static ArrayList<NewSprite> bombExplosion1 = new ArrayList<NewSprite>(Arrays.asList(bomb1_1, bomb1_2, bomb1_3
    ));

    public static ArrayList<NewSprite> bombExplosion2 = new ArrayList<NewSprite>(Arrays.asList(bomb2_1, bomb2_2, bomb2_3
    ));
    //new bomb
    public static ArrayList<NewSprite> normalBomb = new ArrayList<NewSprite>(Arrays.asList(
            bomb1_1, bomb1_2, bomb1_3,
            bomb1_2, bomb1_1,
            bomb1_1, bomb1_2, bomb1_3
    ));
    public static ArrayList<NewSprite> powerBomb = new ArrayList<NewSprite>(Arrays.asList(
            bomb2_1, bomb2_2, bomb2_3,
            bomb2_2, bomb2_1,
            bomb2_1, bomb2_2, bomb2_3
    ));


    public static NewSprite explosion_horizontal = new NewSprite(SIZE, 0, 0, "explosion-horizontal");
    public static NewSprite explosion_horizontal_1 = new NewSprite(SIZE, 0, 0, "explosion-horizontal1");
    public static NewSprite explosion_horizontal_2 = new NewSprite(SIZE, 0, 0, "explosion-horizontal2");
    public static NewSprite explosion_horizontal_3 = new NewSprite(SIZE, 0, 0, "explosion-horizontal3");
    public static NewSprite explosion_horizontal_4 = new NewSprite(SIZE, 0, 0, "explosion-horizontal4");

    public static NewSprite explosion_horizontal_left_last = new NewSprite(SIZE, 0, 0, "explosion-horizontal-leftlast");
    public static NewSprite explosion_horizontal_left_last_1 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-leftlast1");
    public static NewSprite explosion_horizontal_left_last_2 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-leftlast2");
    public static NewSprite explosion_horizontal_left_last_3 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-leftlast3");
    public static NewSprite explosion_horizontal_left_last_4 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-leftlast4");

    public static NewSprite explosion_horizontal_right_last = new NewSprite(SIZE, 0, 0, "explosion-horizontal-rightlast");
    public static NewSprite explosion_horizontal_right_last_1 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-rightlast1");
    public static NewSprite explosion_horizontal_right_last_2 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-rightlast2");
    public static NewSprite explosion_horizontal_right_last_3 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-rightlast3");
    public static NewSprite explosion_horizontal_right_last_4 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-rightlast4");

    public static NewSprite explosion_vertical = new NewSprite(SIZE, 0, 0, "explosion-vertical");
    public static NewSprite explosion_vertical_1 = new NewSprite(SIZE, 0, 0, "explosion-vertical1");
    public static NewSprite explosion_vertical_2 = new NewSprite(SIZE, 0, 0, "explosion-vertical2");
    public static NewSprite explosion_vertical_3 = new NewSprite(SIZE, 0, 0, "explosion-vertical3");
    public static NewSprite explosion_vertical_4 = new NewSprite(SIZE, 0, 0, "explosion-vertical4");

    public static NewSprite explosion_vertical_bot_last = new NewSprite(SIZE, 0, 0, "explosion-vertical-botlast");
    public static NewSprite explosion_vertical_bot_last_1 = new NewSprite(SIZE, 0, 0, "explosion-vertical-botlast1");
    public static NewSprite explosion_vertical_bot_last_2 = new NewSprite(SIZE, 0, 0, "explosion-vertical-botlast2");
    public static NewSprite explosion_vertical_bot_last_3 = new NewSprite(SIZE, 0, 0, "explosion-vertical-botlast3");
    public static NewSprite explosion_vertical_bot_last_4 = new NewSprite(SIZE, 0, 0, "explosion-vertical-botlast4");

    public static NewSprite explosion_vertical_top_last = new NewSprite(SIZE, 0, 0, "explosion-vertical-toplast");
    public static NewSprite explosion_vertical_top_last_1 = new NewSprite(SIZE, 0, 0, "explosion-vertical-toplast1");
    public static NewSprite explosion_vertical_top_last_2 = new NewSprite(SIZE, 0, 0, "explosion-vertical-toplast2");
    public static NewSprite explosion_vertical_top_last_3 = new NewSprite(SIZE, 0, 0, "explosion-vertical-toplast3");
    public static NewSprite explosion_vertical_top_last_4 = new NewSprite(SIZE, 0, 0, "explosion-vertical-toplast4");

    //flame

    public static ArrayList<NewSprite> bomb1List = new ArrayList<NewSprite>(Arrays.asList(bomb1_1, bomb1_2, bomb1_3));
    public static ArrayList<NewSprite> bomb2List = new ArrayList<NewSprite>(Arrays.asList(bomb2_1, bomb2_2, bomb2_3));
    public static ArrayList<NewSprite> bombExplosionVertical = new ArrayList<NewSprite>(Arrays.asList(explosion_vertical, explosion_vertical_1, explosion_vertical_2, explosion_vertical_3, explosion_vertical_4
    ));
    public static ArrayList<NewSprite> bombExplosionVerticalTop = new ArrayList<NewSprite>(Arrays.asList(explosion_vertical_top_last, explosion_vertical_top_last_1, explosion_vertical_top_last_2, explosion_vertical_top_last_3, explosion_vertical_top_last_4
    ));
    public static ArrayList<NewSprite> bombExplosionHorizontalBot = new ArrayList<NewSprite>(Arrays.asList(explosion_vertical_bot_last, explosion_vertical_bot_last_1, explosion_vertical_bot_last_2, explosion_vertical_bot_last_3, explosion_vertical_bot_last_4
    ));

    //new flame
    public static ArrayList<NewSprite> newBombExplosionVertical = new ArrayList<NewSprite>(Arrays.asList(explosion_vertical, explosion_vertical_1, explosion_vertical_2, explosion_vertical_3, explosion_vertical_4
            , explosion_vertical_3, explosion_vertical_2, explosion_vertical_1, explosion_vertical
    ));
    public static ArrayList<NewSprite> newBombExplosionVerticalTopLast = new ArrayList<NewSprite>(Arrays.asList(
            explosion_vertical_top_last, explosion_vertical_top_last_1, explosion_vertical_top_last_2, explosion_vertical_top_last_3, explosion_vertical_top_last_4
            , explosion_vertical_top_last_3, explosion_vertical_top_last_2, explosion_vertical_top_last_1, explosion_vertical_top_last
    ));
    public static ArrayList<NewSprite> newBombExplosionVerticalBotLast = new ArrayList<NewSprite>(Arrays.asList(
            explosion_vertical_bot_last, explosion_vertical_bot_last_1, explosion_vertical_bot_last_2, explosion_vertical_bot_last_3, explosion_vertical_bot_last_4,
            explosion_vertical_bot_last_3, explosion_vertical_bot_last_2, explosion_vertical_bot_last_1, explosion_vertical_bot_last
    ));
    public static ArrayList<NewSprite> newBombExplosionHorizontal = new ArrayList<NewSprite>(Arrays.asList(
            explosion_horizontal, explosion_horizontal_1, explosion_horizontal_2, explosion_horizontal_3, explosion_horizontal_4,
            explosion_horizontal_3, explosion_horizontal_2, explosion_horizontal_1, explosion_horizontal
    ));
    public static ArrayList<NewSprite> newBombExplosionHorizontalRightLast = new ArrayList<NewSprite>(Arrays.asList(
            explosion_horizontal_right_last, explosion_horizontal_right_last_1, explosion_horizontal_right_last_2, explosion_horizontal_right_last_3, explosion_horizontal_right_last_4,
            explosion_horizontal_right_last_3, explosion_horizontal_right_last_2, explosion_horizontal_right_last_1, explosion_horizontal_right_last
    ));
    public static ArrayList<NewSprite> newBombExplosionHorizontalLeftLast = new ArrayList<NewSprite>(Arrays.asList(
            explosion_horizontal_left_last, explosion_horizontal_left_last_1, explosion_horizontal_left_last_2, explosion_horizontal_left_last_3, explosion_horizontal_left_last_4,
            explosion_horizontal_left_last_3, explosion_horizontal_left_last_2, explosion_horizontal_left_last_1, explosion_horizontal_left_last
    ));

    //brick
    public static NewSprite brick = new NewSprite(SIZE, 0, 0, "brick");

    public static NewSprite brick_broken_1 = new NewSprite(SIZE, 0, 0, "brick-1");
    public static NewSprite brick_broken_2 = new NewSprite(SIZE, 0, 0, "brick-2");
    public static NewSprite brick_broken_3 = new NewSprite(SIZE, 0, 0, "brick-3");
    public static NewSprite brick_broken_4 = new NewSprite(SIZE, 0, 0, "brick-4");
    public static NewSprite brick_broken_5 = new NewSprite(SIZE, 0, 0, "brick-5");
    public static NewSprite brick_broken_6 = new NewSprite(SIZE, 0, 0, "brick-6");

    public static ArrayList<NewSprite> brickBrokenList = new ArrayList<NewSprite>(Arrays.asList(
            brick_broken_1, brick_broken_2, brick_broken_3, brick_broken_4, brick_broken_5, brick_broken_6));


    //portal
    public static NewSprite portal_1 = new NewSprite(SIZE, 0, 0, "portal");
    public static NewSprite portal_2 = new NewSprite(SIZE, 0, 0, "portal1");
    public static NewSprite portal_3 = new NewSprite(SIZE, 0, 0, "portal2");
    public static NewSprite portal_4 = new NewSprite(SIZE, 0, 0, "portal3");
    public static NewSprite portal_5 = new NewSprite(SIZE, 0, 0, "portal4");
    public static NewSprite portal_6 = new NewSprite(SIZE, 0, 0, "portal5");
    public static NewSprite portal_7 = new NewSprite(SIZE, 0, 0, "portal6");

    public static ArrayList<NewSprite> portalList = new ArrayList<NewSprite>(Arrays.asList(
            portal_1, portal_2, portal_3, portal_4, portal_3, portal_2, portal_1, portal_5, portal_6, portal_7, portal_6, portal_5));

    //ground
    public static NewSprite ground = new NewSprite(SIZE, 0, 0, "ground");

    //wall
    public static NewSprite wall = new NewSprite(SIZE, 0, 0, "wall");

    //stage
    public static NewSprite stage_bot = new NewSprite(SIZE, 0, 0, "stage-bot");
    public static NewSprite stage_bot_left = new NewSprite(SIZE, 0, 0, "stage-botleft");
    public static NewSprite stage_top = new NewSprite(SIZE, 0, 0, "stage-top");
    public static NewSprite stage_top_left = new NewSprite(SIZE, 0, 0, "stage-topleft");
    public static NewSprite stage_left_1 = new NewSprite(SIZE, 0, 0, "stage-left");
    public static NewSprite stage_left_2 = new NewSprite(SIZE, 0, 0, "stage-left1");
    public static NewSprite stage_bot_right = new NewSprite(SIZE, 0, 0, "stage-botright");
    public static NewSprite stage_top_right = new NewSprite(SIZE, 0, 0, "stage-topright");
    public static NewSprite stage_right_1 = new NewSprite(SIZE, 0, 0, "stage-right");

    //sky
    public static NewSprite sky_left_1 = new NewSprite(SIZE, 0, 0, "sky-left");
    public static NewSprite sky_left_2 = new NewSprite(SIZE, 0, 0, "sky-left1");
    public static NewSprite sky_left_3 = new NewSprite(SIZE, 0, 0, "sky-left2");
    public static NewSprite sky_left_4 = new NewSprite(SIZE, 0, 0, "sky-left3");
    public static NewSprite sky_left_5 = new NewSprite(SIZE, 0, 0, "sky-left4");
    public static NewSprite sky_left_6 = new NewSprite(SIZE, 0, 0, "sky-left5");
    public static NewSprite sky_left_7 = new NewSprite(SIZE, 0, 0, "sky-left6");
    public static NewSprite sky_left_8 = new NewSprite(SIZE, 0, 0, "sky-left7");
    public static NewSprite sky_left_9 = new NewSprite(SIZE, 0, 0, "sky-left8");
    public static NewSprite sky_left_10 = new NewSprite(SIZE, 0, 0, "sky-left9");

    public static NewSprite sky_right_1 = new NewSprite(SIZE, 0, 0, "sky-right");
    public static NewSprite sky_right_2 = new NewSprite(SIZE, 0, 0, "sky-right1");
    public static NewSprite sky_right_3 = new NewSprite(SIZE, 0, 0, "sky-right2");
    public static NewSprite sky_right_4 = new NewSprite(SIZE, 0, 0, "sky-right3");
    public static NewSprite sky_right_5 = new NewSprite(SIZE, 0, 0, "sky-right4");
    public static NewSprite sky_right_6 = new NewSprite(SIZE, 0, 0, "sky-right5");
    public static NewSprite sky_right_7 = new NewSprite(SIZE, 0, 0, "sky-right6");
    public static NewSprite sky_right_8 = new NewSprite(SIZE, 0, 0, "sky-right7");
    public static NewSprite sky_right_9 = new NewSprite(SIZE, 0, 0, "sky-right8");
    public static NewSprite sky_right_10 = new NewSprite(SIZE, 0, 0, "sky-right9");

    /**
     * player
     */
    public static NewSprite player_down_1 = new NewSprite(SIZE, 0, 5, 17, 20, "player-down");
    public static NewSprite player_down_2 = new NewSprite(SIZE, -1, 5, 17, 20, "player-down1");
    public static NewSprite player_down_3 = new NewSprite(SIZE, 1, 5, 17, 20, "player-down2");
    public static ArrayList<NewSprite> playerDownList = new ArrayList<NewSprite>(Arrays.asList(
            player_down_1, player_down_2, player_down_3
    ));

    public static NewSprite player_left_1 = new NewSprite(SIZE, 0, 5, 18, 21, "player-left");
    public static NewSprite player_left_2 = new NewSprite(SIZE, 1, 5, 17, 21, "player-left1");
    public static NewSprite player_left_3 = new NewSprite(SIZE, 1, 5, 18, 21, "player-left2");
    public static ArrayList<NewSprite> playerLeftList = new ArrayList<NewSprite>(Arrays.asList(
            player_left_1, player_left_2, player_left_3
    ));

    public static NewSprite player_right_1 = new NewSprite(SIZE, 2, 5, 18, 21, "player-right");
    public static NewSprite player_right_2 = new NewSprite(SIZE, 0, 5, 17, 21, "player-right1");
    public static NewSprite player_right_3 = new NewSprite(SIZE, 1, 5, 18, 21, "player-right2");
    public static ArrayList<NewSprite> playerRightList = new ArrayList<NewSprite>(Arrays.asList(
            player_right_1,
            player_right_2
            , player_right_3
    ));

    public static NewSprite player_up_1 = new NewSprite(SIZE, 0, 5, 17, 20, "player-up");
    public static NewSprite player_up_2 = new NewSprite(SIZE, -1, 5, 17, 20, "player-up1");
    public static NewSprite player_up_3 = new NewSprite(SIZE, 1, 5, 17, 20, "player-up2");
    public static ArrayList<NewSprite> playerUpList = new ArrayList<NewSprite>(Arrays.asList(
            player_up_1, player_up_2, player_up_3
    ));

    public static NewSprite player_dead_1 = new NewSprite(SIZE, 2, 5, 20, 20, "player-dead");
    public static NewSprite player_dead_2 = new NewSprite(SIZE, 1, 5, 19, 20, "player-dead1");
    public static NewSprite player_dead_3 = new NewSprite(SIZE, 2, 5, 21, 21, "player-dead2");
    public static NewSprite player_dead_4 = new NewSprite(SIZE, 1, 5, 19, 21, "player-dead3");
    public static NewSprite player_dead_5 = new NewSprite(SIZE, 1, 5, 19, 21, "player-dead4");
    public static NewSprite player_dead_6 = new NewSprite(SIZE, 2, 5, 21, 21, "player-dead5");
    public static NewSprite player_dead_7 = new NewSprite(SIZE, 3, 5, 22, 22, "player-dead6");

    public static ArrayList<NewSprite> playerDeadList = new ArrayList<>(Arrays.asList(
            player_dead_1, player_dead_2, player_dead_3, player_dead_4, player_dead_5, player_dead_6, player_dead_7
    ));

    /**
     * enemies
     */

    //enemy dead
    public static NewSprite enemy_dead_1 = new NewSprite(SIZE, 0, 0, "enemy-dead");
    public static NewSprite enemy_dead_2 = new NewSprite(SIZE, 0, 0, "enemy-dead1");
    public static NewSprite enemy_dead_3 = new NewSprite(SIZE, 0, 0, "enemy-dead2");
    public static NewSprite enemy_dead_4 = new NewSprite(SIZE, 0, 0, "enemy-dead3");
    public static NewSprite enemy_dead_5 = new NewSprite(SIZE, 0, 0, "enemy-dead4");

    public static ArrayList<NewSprite> enemyDeadList = new ArrayList<>(Arrays.asList(
            enemy_dead_1, enemy_dead_2, enemy_dead_3, enemy_dead_4, enemy_dead_5
    ));
    //balloon

    public static NewSprite balloon_right = new NewSprite(SIZE, 0, 0, "balloon-right");
    public static NewSprite balloon_right_1 = new NewSprite(SIZE, 0, 0, "balloon-right1");
    public static NewSprite balloon_right_2 = new NewSprite(SIZE, 0, 0, "balloon-right2");
    public static ArrayList<NewSprite> BalloonRightList = new ArrayList<NewSprite>(Arrays.asList(
            balloon_right, balloon_right_1, balloon_right_2));


    public static NewSprite balloon_left = new NewSprite(SIZE, 0, 0, "balloon-left");
    public static NewSprite balloon_left1 = new NewSprite(SIZE, 0, 0, "balloon-left1");
    public static NewSprite balloon_left2 = new NewSprite(SIZE, 0, 0, "balloon-left2");
    public static ArrayList<NewSprite> BalloonLeftList = new ArrayList<NewSprite>(Arrays.asList(
            balloon_left, balloon_left1, balloon_left2));

    // bat
    public static NewSprite bat_up = new NewSprite(SIZE, 0, 0, "bat-up");
    public static NewSprite bat_up1 = new NewSprite(SIZE, 0, 0, "bat-up1");
    public static NewSprite bat_up2 = new NewSprite(SIZE, 0, 0, "bat-up2");
    public static ArrayList<NewSprite> BatUpList = new ArrayList<>(Arrays.asList(bat_up, bat_up1, bat_up2));

    public static NewSprite bat_down = new NewSprite(SIZE, 0, 0, "bat-down");
    public static NewSprite bat_down1 = new NewSprite(SIZE, 0, 0, "bat-down1");
    public static NewSprite bat_down2 = new NewSprite(SIZE, 0, 0, "bat-down2");
    public static ArrayList<NewSprite> BatDownList = new ArrayList<>(Arrays.asList(bat_down, bat_down1, bat_down2));

    public static NewSprite bat_left = new NewSprite(SIZE, 0, 0, "bat-left");
    public static NewSprite bat_left1 = new NewSprite(SIZE, 0, 0, "bat-left1");
    public static NewSprite bat_left2 = new NewSprite(SIZE, 0, 0, "bat-left2");
    public static ArrayList<NewSprite> BatLeftList = new ArrayList<>(Arrays.asList(bat_left, bat_left1, bat_left2));

    public static NewSprite bat_right = new NewSprite(SIZE, 0, 0, "bat-right");
    public static NewSprite bat_right1 = new NewSprite(SIZE, 0, 0, "bat-right1");
    public static NewSprite bat_right2 = new NewSprite(SIZE, 0, 0, "bat-right2");
    public static ArrayList<NewSprite> BatRightList = new ArrayList<>(Arrays.asList(bat_right, bat_right1, bat_right2));


    // frog
    public static NewSprite frog = new NewSprite(SIZE, 0, 0, "frog");
    public static NewSprite frog1 = new NewSprite(SIZE, 0, 0, "frog1");
    public static NewSprite frog2 = new NewSprite(SIZE, 0, 0, "frog2");
    public static ArrayList<NewSprite> frogList = new ArrayList<>(Arrays.asList(frog, frog1, frog2));


    //enemy dead
    public static NewSprite enemy_dead = new NewSprite(SIZE, 0, 0, "enemy-dead");
    public static NewSprite enemy_dead1 = new NewSprite(SIZE, 0, 0, "enemy-dead1");
    public static NewSprite enemy_dead2 = new NewSprite(SIZE, 0, 0, "enemy-dead2");
    public static NewSprite enemy_dead3 = new NewSprite(SIZE, 0, 0, "enemy-dead3");
    public static NewSprite enemy_dead4 = new NewSprite(SIZE, 0, 0, "enemy-dead4");

    public static NewSprite balloon_dead_ = new NewSprite(SIZE, 0, 0, "balloon-dead");
    public static NewSprite bat_dead_ = new NewSprite(SIZE, 0, 0, "bat-dead");
    public static NewSprite frog_dead_ = new NewSprite(SIZE, 0, 0, "frog-dead");

    public static ArrayList<NewSprite> frog_Dead = new ArrayList<>(Arrays.asList(frog_dead_, enemy_dead, enemy_dead1, enemy_dead2, enemy_dead3, enemy_dead4));
    public static ArrayList<NewSprite> balloon_dead = new ArrayList<>(Arrays.asList(balloon_dead_, enemy_dead, enemy_dead1, enemy_dead2, enemy_dead3, enemy_dead4));
    public static ArrayList<NewSprite> bat_dead = new ArrayList<>(Arrays.asList(bat_dead_, enemy_dead, enemy_dead1, enemy_dead2, enemy_dead3, enemy_dead4));

    /**
     * Info Bar
     */
    //digits
    public static NewSprite digit_0 = new NewSprite(8, 14, "0");
    public static NewSprite digit_1 = new NewSprite(8, 14, "1");
    public static NewSprite digit_2 = new NewSprite(8, 14, "2");
    public static NewSprite digit_3 = new NewSprite(8, 14, "3");
    public static NewSprite digit_4 = new NewSprite(8, 14, "4");
    public static NewSprite digit_5 = new NewSprite(8, 14, "5");
    public static NewSprite digit_6 = new NewSprite(8, 14, "6");
    public static NewSprite digit_7 = new NewSprite(8, 14, "7");
    public static NewSprite digit_8 = new NewSprite(8, 14, "8");
    public static NewSprite digit_9 = new NewSprite(8, 14, "9");

    //bars
    public static NewSprite startBar= new NewSprite(272,32,"bar");
    public static NewSprite inGameBar= new NewSprite(272,32,"bar1");

    public static NewSprite speed_item = new NewSprite(SIZE, 0, 0, "speed-item");
    public static NewSprite speed_item1 = new NewSprite(SIZE, 0, 0, "speed-item1");
    public static ArrayList<NewSprite> speedItem = new ArrayList<>(Arrays.asList(speed_item, speed_item1));

    public static NewSprite flame_item = new NewSprite(SIZE, 0, 0, "flame-item");
    public static NewSprite flame_item1 = new NewSprite(SIZE, 0, 0, "flame-item1");
    public static ArrayList<NewSprite> flameItem = new ArrayList<>(Arrays.asList(flame_item, flame_item1));

    public static NewSprite bomb_item = new NewSprite(SIZE, 0, 0, "bomb-item");
    public static NewSprite bomb_item1 = new NewSprite(SIZE, 0, 0, "bomb-item1");
    public static ArrayList<NewSprite> bombItem = new ArrayList<>(Arrays.asList(bomb_item, bomb_item1));


    public static NewSprite movingSprite(ArrayList<NewSprite> spritesList, int animate, int time) {
        int calc = animate % time;
        double diff = time / (spritesList.size());
        int index = calc / ((int) diff + 1);
        return spritesList.get(index);

    }

    public int getDistanceToTopLeftX() {
        return distanceToTopLeftX;
    }

    public int getDistanceToTopLeftY() {
        return distanceToTopLeftY;
    }

    public static Image getMoveSprite(Image x0, Image x1, Image x2, int animate, int time) {
        int calc = animate % time;
        int diff = time / 3;

        if (calc < diff) {
            return x0;
        }
        if (calc < diff * 2) {
            return x1;
        }
        return x2;


    }

}
