package uet.oop.bomberman.graphics;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;


public class Sprite {

    private static final int SIZE = 16;
    public static final int SCALED_SIZE = SIZE * 36 / 16;
    public static double SCALED_FACTOR = 2.25;
    private int distanceToTopLeftX;
    private int distanceToTopLeftY;
    private Image image;
    private String name;//tạm thời


    public Sprite(int originalSize, int distanceToTopLeftX, int distanceToTopLeftY, String name) {
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

    public Sprite(int originalSize, int distanceToTopLeftX, int distanceToTopLeftY, double originalWidth, double originalHeight, String name) {
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

    public Sprite(double originalWidth, double originalHeight, String name) {
        String path;
        if (name.length() == 1) {
            path = "./newsprites/digits/" + name + ".png";
        } else {
            path = "./newsprites/InfoBar/" + name + ".png";
        }
        try {
            image = new Image(path, (double) (originalWidth) * SCALED_FACTOR, (double) (originalHeight) * SCALED_FACTOR, false, false);
            System.out.println((double) (originalWidth) * SCALED_FACTOR + " " + (double) (originalHeight) * SCALED_FACTOR + " " + name);
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
    public static Sprite bomb_exploded = new Sprite(SIZE, 0, 0, "bomb-exploded");
    public static Sprite bomb_exploded_1 = new Sprite(SIZE, 0, 0, "bomb-exploded1");
    public static Sprite bomb_exploded_2 = new Sprite(SIZE, 0, 0, "bomb-exploded2");
    public static Sprite bomb_exploded_3 = new Sprite(SIZE, 0, 0, "bomb-exploded3");
    public static Sprite bomb_exploded_4 = new Sprite(SIZE, 0, 0, "bomb-exploded4");

    public static ArrayList<Sprite> bombExplosionCentral = new ArrayList<Sprite>(Arrays.asList(bomb_exploded, bomb_exploded_1, bomb_exploded_2, bomb_exploded_3, bomb_exploded_4
    ));
    public static ArrayList<Sprite> newBombExplosionCentral = new ArrayList<Sprite>(Arrays.asList(
            bomb_exploded, bomb_exploded_1, bomb_exploded_2, bomb_exploded_3, bomb_exploded_4,
            bomb_exploded_3, bomb_exploded_2, bomb_exploded_1, bomb_exploded
    ));

    public static Sprite bomb1_1 = new Sprite(SIZE, 0, 0, "1-bomb-1");
    public static Sprite bomb1_2 = new Sprite(SIZE, 0, 0, "1-bomb-2");
    public static Sprite bomb1_3 = new Sprite(SIZE, 0, 0, "1-bomb-3");

    public static Sprite bomb2_1 = new Sprite(SIZE, 0, 0, "2-bomb-1");
    public static Sprite bomb2_2 = new Sprite(SIZE, 0, 0, "2-bomb-2");
    public static Sprite bomb2_3 = new Sprite(SIZE, 0, 0, "2-bomb-3");

    public static ArrayList<Sprite> bombExplosion1 = new ArrayList<Sprite>(Arrays.asList(bomb1_1, bomb1_2, bomb1_3
    ));

    public static ArrayList<Sprite> bombExplosion2 = new ArrayList<Sprite>(Arrays.asList(bomb2_1, bomb2_2, bomb2_3
    ));
    //new bomb
    public static ArrayList<Sprite> normalBomb = new ArrayList<Sprite>(Arrays.asList(
            bomb1_1, bomb1_2, bomb1_3,
            bomb1_2, bomb1_1,
            bomb1_1, bomb1_2, bomb1_3
    ));
    public static ArrayList<Sprite> powerBomb = new ArrayList<Sprite>(Arrays.asList(
            bomb2_1, bomb2_2, bomb2_3,
            bomb2_2, bomb2_1,
            bomb2_1, bomb2_2, bomb2_3
    ));


    public static Sprite explosion_horizontal = new Sprite(SIZE, 0, 0, "explosion-horizontal");
    public static Sprite explosion_horizontal_1 = new Sprite(SIZE, 0, 0, "explosion-horizontal1");
    public static Sprite explosion_horizontal_2 = new Sprite(SIZE, 0, 0, "explosion-horizontal2");
    public static Sprite explosion_horizontal_3 = new Sprite(SIZE, 0, 0, "explosion-horizontal3");
    public static Sprite explosion_horizontal_4 = new Sprite(SIZE, 0, 0, "explosion-horizontal4");

    public static Sprite explosion_horizontal_left_last = new Sprite(SIZE, 0, 0, "explosion-horizontal-leftlast");
    public static Sprite explosion_horizontal_left_last_1 = new Sprite(SIZE, 0, 0, "explosion-horizontal-leftlast1");
    public static Sprite explosion_horizontal_left_last_2 = new Sprite(SIZE, 0, 0, "explosion-horizontal-leftlast2");
    public static Sprite explosion_horizontal_left_last_3 = new Sprite(SIZE, 0, 0, "explosion-horizontal-leftlast3");
    public static Sprite explosion_horizontal_left_last_4 = new Sprite(SIZE, 0, 0, "explosion-horizontal-leftlast4");

    public static Sprite explosion_horizontal_right_last = new Sprite(SIZE, 0, 0, "explosion-horizontal-rightlast");
    public static Sprite explosion_horizontal_right_last_1 = new Sprite(SIZE, 0, 0, "explosion-horizontal-rightlast1");
    public static Sprite explosion_horizontal_right_last_2 = new Sprite(SIZE, 0, 0, "explosion-horizontal-rightlast2");
    public static Sprite explosion_horizontal_right_last_3 = new Sprite(SIZE, 0, 0, "explosion-horizontal-rightlast3");
    public static Sprite explosion_horizontal_right_last_4 = new Sprite(SIZE, 0, 0, "explosion-horizontal-rightlast4");

    public static Sprite explosion_vertical = new Sprite(SIZE, 0, 0, "explosion-vertical");
    public static Sprite explosion_vertical_1 = new Sprite(SIZE, 0, 0, "explosion-vertical1");
    public static Sprite explosion_vertical_2 = new Sprite(SIZE, 0, 0, "explosion-vertical2");
    public static Sprite explosion_vertical_3 = new Sprite(SIZE, 0, 0, "explosion-vertical3");
    public static Sprite explosion_vertical_4 = new Sprite(SIZE, 0, 0, "explosion-vertical4");

    public static Sprite explosion_vertical_bot_last = new Sprite(SIZE, 0, 0, "explosion-vertical-botlast");
    public static Sprite explosion_vertical_bot_last_1 = new Sprite(SIZE, 0, 0, "explosion-vertical-botlast1");
    public static Sprite explosion_vertical_bot_last_2 = new Sprite(SIZE, 0, 0, "explosion-vertical-botlast2");
    public static Sprite explosion_vertical_bot_last_3 = new Sprite(SIZE, 0, 0, "explosion-vertical-botlast3");
    public static Sprite explosion_vertical_bot_last_4 = new Sprite(SIZE, 0, 0, "explosion-vertical-botlast4");

    public static Sprite explosion_vertical_top_last = new Sprite(SIZE, 0, 0, "explosion-vertical-toplast");
    public static Sprite explosion_vertical_top_last_1 = new Sprite(SIZE, 0, 0, "explosion-vertical-toplast1");
    public static Sprite explosion_vertical_top_last_2 = new Sprite(SIZE, 0, 0, "explosion-vertical-toplast2");
    public static Sprite explosion_vertical_top_last_3 = new Sprite(SIZE, 0, 0, "explosion-vertical-toplast3");
    public static Sprite explosion_vertical_top_last_4 = new Sprite(SIZE, 0, 0, "explosion-vertical-toplast4");

    //flame

    public static ArrayList<Sprite> bomb1List = new ArrayList<Sprite>(Arrays.asList(bomb1_1, bomb1_2, bomb1_3));
    public static ArrayList<Sprite> bomb2List = new ArrayList<Sprite>(Arrays.asList(bomb2_1, bomb2_2, bomb2_3));
    public static ArrayList<Sprite> bombExplosionVertical = new ArrayList<Sprite>(Arrays.asList(explosion_vertical, explosion_vertical_1, explosion_vertical_2, explosion_vertical_3, explosion_vertical_4
    ));
    public static ArrayList<Sprite> bombExplosionVerticalTop = new ArrayList<Sprite>(Arrays.asList(explosion_vertical_top_last, explosion_vertical_top_last_1, explosion_vertical_top_last_2, explosion_vertical_top_last_3, explosion_vertical_top_last_4
    ));
    public static ArrayList<Sprite> bombExplosionHorizontalBot = new ArrayList<Sprite>(Arrays.asList(explosion_vertical_bot_last, explosion_vertical_bot_last_1, explosion_vertical_bot_last_2, explosion_vertical_bot_last_3, explosion_vertical_bot_last_4
    ));

    //new flame
    public static ArrayList<Sprite> newBombExplosionVertical = new ArrayList<Sprite>(Arrays.asList(explosion_vertical, explosion_vertical_1, explosion_vertical_2, explosion_vertical_3, explosion_vertical_4
            , explosion_vertical_3, explosion_vertical_2, explosion_vertical_1, explosion_vertical
    ));
    public static ArrayList<Sprite> newBombExplosionVerticalTopLast = new ArrayList<Sprite>(Arrays.asList(
            explosion_vertical_top_last, explosion_vertical_top_last_1, explosion_vertical_top_last_2, explosion_vertical_top_last_3, explosion_vertical_top_last_4
            , explosion_vertical_top_last_3, explosion_vertical_top_last_2, explosion_vertical_top_last_1, explosion_vertical_top_last
    ));
    public static ArrayList<Sprite> newBombExplosionVerticalBotLast = new ArrayList<Sprite>(Arrays.asList(
            explosion_vertical_bot_last, explosion_vertical_bot_last_1, explosion_vertical_bot_last_2, explosion_vertical_bot_last_3, explosion_vertical_bot_last_4,
            explosion_vertical_bot_last_3, explosion_vertical_bot_last_2, explosion_vertical_bot_last_1, explosion_vertical_bot_last
    ));
    public static ArrayList<Sprite> newBombExplosionHorizontal = new ArrayList<Sprite>(Arrays.asList(
            explosion_horizontal, explosion_horizontal_1, explosion_horizontal_2, explosion_horizontal_3, explosion_horizontal_4,
            explosion_horizontal_3, explosion_horizontal_2, explosion_horizontal_1, explosion_horizontal
    ));
    public static ArrayList<Sprite> newBombExplosionHorizontalRightLast = new ArrayList<Sprite>(Arrays.asList(
            explosion_horizontal_right_last, explosion_horizontal_right_last_1, explosion_horizontal_right_last_2, explosion_horizontal_right_last_3, explosion_horizontal_right_last_4,
            explosion_horizontal_right_last_3, explosion_horizontal_right_last_2, explosion_horizontal_right_last_1, explosion_horizontal_right_last
    ));
    public static ArrayList<Sprite> newBombExplosionHorizontalLeftLast = new ArrayList<Sprite>(Arrays.asList(
            explosion_horizontal_left_last, explosion_horizontal_left_last_1, explosion_horizontal_left_last_2, explosion_horizontal_left_last_3, explosion_horizontal_left_last_4,
            explosion_horizontal_left_last_3, explosion_horizontal_left_last_2, explosion_horizontal_left_last_1, explosion_horizontal_left_last
    ));

    //brick
    public static Sprite brick = new Sprite(SIZE, 0, 0, "brick");

    public static Sprite brick_broken_1 = new Sprite(SIZE, 0, 0, "brick-1");
    public static Sprite brick_broken_2 = new Sprite(SIZE, 0, 0, "brick-2");
    public static Sprite brick_broken_3 = new Sprite(SIZE, 0, 0, "brick-3");
    public static Sprite brick_broken_4 = new Sprite(SIZE, 0, 0, "brick-4");
    public static Sprite brick_broken_5 = new Sprite(SIZE, 0, 0, "brick-5");
    public static Sprite brick_broken_6 = new Sprite(SIZE, 0, 0, "brick-6");

    public static ArrayList<Sprite> brickBrokenList = new ArrayList<Sprite>(Arrays.asList(
            brick_broken_1, brick_broken_2, brick_broken_3, brick_broken_4, brick_broken_5, brick_broken_6));


    //portal
    public static Sprite portal_1 = new Sprite(SIZE, 0, 0, "portal");
    public static Sprite portal_2 = new Sprite(SIZE, 0, 0, "portal1");
    public static Sprite portal_3 = new Sprite(SIZE, 0, 0, "portal2");
    public static Sprite portal_4 = new Sprite(SIZE, 0, 0, "portal3");
    public static Sprite portal_5 = new Sprite(SIZE, 0, 0, "portal4");
    public static Sprite portal_6 = new Sprite(SIZE, 0, 0, "portal5");
    public static Sprite portal_7 = new Sprite(SIZE, 0, 0, "portal6");

    public static ArrayList<Sprite> portalList = new ArrayList<Sprite>(Arrays.asList(
            portal_1, portal_2, portal_3, portal_4, portal_3, portal_2, portal_1, portal_5, portal_6, portal_7, portal_6, portal_5));

    //ground
    public static Sprite ground = new Sprite(SIZE, 0, 0, "ground");

    //wall
    public static Sprite wall = new Sprite(SIZE, 0, 0, "wall");

    //stage
    public static Sprite stage_bot = new Sprite(SIZE, 0, 0, "stage-bot");
    public static Sprite stage_bot_left = new Sprite(SIZE, 0, 0, "stage-botleft");
    public static Sprite stage_top = new Sprite(SIZE, 0, 0, "stage-top");
    public static Sprite stage_top_left = new Sprite(SIZE, 0, 0, "stage-topleft");
    public static Sprite stage_left_1 = new Sprite(SIZE, 0, 0, "stage-left");
    public static Sprite stage_left_2 = new Sprite(SIZE, 0, 0, "stage-left1");
    public static Sprite stage_bot_right = new Sprite(SIZE, 0, 0, "stage-botright");
    public static Sprite stage_top_right = new Sprite(SIZE, 0, 0, "stage-topright");
    public static Sprite stage_right_1 = new Sprite(SIZE, 0, 0, "stage-right");

    //sky
    public static Sprite sky_left_1 = new Sprite(SIZE, 0, 0, "sky-left");
    public static Sprite sky_left_2 = new Sprite(SIZE, 0, 0, "sky-left1");
    public static Sprite sky_left_3 = new Sprite(SIZE, 0, 0, "sky-left2");
    public static Sprite sky_left_4 = new Sprite(SIZE, 0, 0, "sky-left3");
    public static Sprite sky_left_5 = new Sprite(SIZE, 0, 0, "sky-left4");
    public static Sprite sky_left_6 = new Sprite(SIZE, 0, 0, "sky-left5");
    public static Sprite sky_left_7 = new Sprite(SIZE, 0, 0, "sky-left6");
    public static Sprite sky_left_8 = new Sprite(SIZE, 0, 0, "sky-left7");
    public static Sprite sky_left_9 = new Sprite(SIZE, 0, 0, "sky-left8");
    public static Sprite sky_left_10 = new Sprite(SIZE, 0, 0, "sky-left9");

    public static Sprite sky_right_1 = new Sprite(SIZE, 0, 0, "sky-right");
    public static Sprite sky_right_2 = new Sprite(SIZE, 0, 0, "sky-right1");
    public static Sprite sky_right_3 = new Sprite(SIZE, 0, 0, "sky-right2");
    public static Sprite sky_right_4 = new Sprite(SIZE, 0, 0, "sky-right3");
    public static Sprite sky_right_5 = new Sprite(SIZE, 0, 0, "sky-right4");
    public static Sprite sky_right_6 = new Sprite(SIZE, 0, 0, "sky-right5");
    public static Sprite sky_right_7 = new Sprite(SIZE, 0, 0, "sky-right6");
    public static Sprite sky_right_8 = new Sprite(SIZE, 0, 0, "sky-right7");
    public static Sprite sky_right_9 = new Sprite(SIZE, 0, 0, "sky-right8");
    public static Sprite sky_right_10 = new Sprite(SIZE, 0, 0, "sky-right9");

    /**
     * player
     */
    public static Sprite player_down_1 = new Sprite(SIZE, 0, 5, 17, 20, "player-down");
    public static Sprite player_down_2 = new Sprite(SIZE, -1, 5, 17, 20, "player-down1");
    public static Sprite player_down_3 = new Sprite(SIZE, 1, 5, 17, 20, "player-down2");
    public static ArrayList<Sprite> playerDownList = new ArrayList<Sprite>(Arrays.asList(
            player_down_1, player_down_3, player_down_1, player_down_2
    ));

    public static Sprite player_left_1 = new Sprite(SIZE, 0, 5, 18, 21, "player-left");
    public static Sprite player_left_2 = new Sprite(SIZE, 1, 5, 17, 21, "player-left1");
    public static Sprite player_left_3 = new Sprite(SIZE, 1, 5, 18, 21, "player-left2");
    public static ArrayList<Sprite> playerLeftList = new ArrayList<Sprite>(Arrays.asList(
            player_left_1, player_left_3, player_left_1, player_left_2
    ));

    public static Sprite player_right_1 = new Sprite(SIZE, 2, 5, 18, 21, "player-right");
    public static Sprite player_right_2 = new Sprite(SIZE, 0, 5, 17, 21, "player-right1");
    public static Sprite player_right_3 = new Sprite(SIZE, 1, 5, 18, 21, "player-right2");
    public static ArrayList<Sprite> playerRightList = new ArrayList<Sprite>(Arrays.asList(
            player_right_1, player_right_3, player_right_1, player_right_2
    ));

    public static Sprite player_up_1 = new Sprite(SIZE, 0, 5, 17, 20, "player-up");
    public static Sprite player_up_2 = new Sprite(SIZE, -1, 5, 17, 20, "player-up1");
    public static Sprite player_up_3 = new Sprite(SIZE, 1, 5, 17, 20, "player-up2");
    public static ArrayList<Sprite> playerUpList = new ArrayList<Sprite>(Arrays.asList(
            player_up_1, player_up_3, player_up_1, player_up_2
    ));

    public static Sprite player_dead_1 = new Sprite(SIZE, 2, 5, 20, 20, "player-dead");
    public static Sprite player_dead_2 = new Sprite(SIZE, 1, 5, 19, 20, "player-dead1");
    public static Sprite player_dead_3 = new Sprite(SIZE, 2, 5, 21, 21, "player-dead2");
    public static Sprite player_dead_4 = new Sprite(SIZE, 1, 5, 19, 21, "player-dead3");
    public static Sprite player_dead_5 = new Sprite(SIZE, 1, 5, 19, 21, "player-dead4");
    public static Sprite player_dead_6 = new Sprite(SIZE, 2, 5, 21, 21, "player-dead5");
    public static Sprite player_dead_7 = new Sprite(SIZE, 3, 5, 22, 22, "player-dead6");

    public static ArrayList<Sprite> playerDeadList = new ArrayList<>(Arrays.asList(
            player_dead_1, player_dead_2, player_dead_3, player_dead_4, player_dead_5, player_dead_6, player_dead_7
    ));

    /**
     * enemies
     */

    //enemy dead
    public static Sprite enemy_dead_1 = new Sprite(SIZE, 0, 0, "enemy-dead");
    public static Sprite enemy_dead_2 = new Sprite(SIZE, 0, 0, "enemy-dead1");
    public static Sprite enemy_dead_3 = new Sprite(SIZE, 0, 0, "enemy-dead2");
    public static Sprite enemy_dead_4 = new Sprite(SIZE, 0, 0, "enemy-dead3");
    public static Sprite enemy_dead_5 = new Sprite(SIZE, 0, 0, "enemy-dead4");

    public static ArrayList<Sprite> enemyDeadList = new ArrayList<>(Arrays.asList(
            enemy_dead_1, enemy_dead_2, enemy_dead_3, enemy_dead_4, enemy_dead_5
    ));
    //balloon

    public static Sprite balloon_right = new Sprite(SIZE, 0, 0, "balloon-right");
    public static Sprite balloon_right_1 = new Sprite(SIZE, 0, 0, "balloon-right1");
    public static Sprite balloon_right_2 = new Sprite(SIZE, 0, 0, "balloon-right2");
    public static ArrayList<Sprite> BalloonRightList = new ArrayList<Sprite>(Arrays.asList(
            balloon_right, balloon_right_1, balloon_right_2));


    public static Sprite balloon_left = new Sprite(SIZE, 0, 0, "balloon-left");
    public static Sprite balloon_left1 = new Sprite(SIZE, 0, 0, "balloon-left1");
    public static Sprite balloon_left2 = new Sprite(SIZE, 0, 0, "balloon-left2");
    public static ArrayList<Sprite> BalloonLeftList = new ArrayList<Sprite>(Arrays.asList(
            balloon_left, balloon_left1, balloon_left2));

    //Oneal
    public static Sprite oneal_left = new Sprite(SIZE, 0, 0, "oneal");
    public static Sprite oneal_left1 = new Sprite(SIZE, 0, 0, "oneal-1");
    public static Sprite oneal_left2 = new Sprite(SIZE, 0, 0, "oneal-2");
    public static ArrayList<Sprite> OnealList = new ArrayList<>(Arrays.asList(oneal_left,oneal_left1,oneal_left2));

    // bat
    public static Sprite bat_up = new Sprite(SIZE, 0, 0, "bat-up");
    public static Sprite bat_up1 = new Sprite(SIZE, 0, 0, "bat-up1");
    public static Sprite bat_up2 = new Sprite(SIZE, 0, 0, "bat-up2");
    public static ArrayList<Sprite> BatUpList = new ArrayList<>(Arrays.asList(bat_up, bat_up1, bat_up2));

    public static Sprite bat_down = new Sprite(SIZE, 0, 0, "bat-down");
    public static Sprite bat_down1 = new Sprite(SIZE, 0, 0, "bat-down1");
    public static Sprite bat_down2 = new Sprite(SIZE, 0, 0, "bat-down2");
    public static ArrayList<Sprite> BatDownList = new ArrayList<>(Arrays.asList(bat_down, bat_down1, bat_down2));

    public static Sprite bat_left = new Sprite(SIZE, 0, 0, "bat-left");
    public static Sprite bat_left1 = new Sprite(SIZE, 0, 0, "bat-left1");
    public static Sprite bat_left2 = new Sprite(SIZE, 0, 0, "bat-left2");
    public static ArrayList<Sprite> BatLeftList = new ArrayList<>(Arrays.asList(bat_left, bat_left1, bat_left2));

    public static Sprite bat_right = new Sprite(SIZE, 0, 0, "bat-right");
    public static Sprite bat_right1 = new Sprite(SIZE, 0, 0, "bat-right1");
    public static Sprite bat_right2 = new Sprite(SIZE, 0, 0, "bat-right2");
    public static ArrayList<Sprite> BatRightList = new ArrayList<>(Arrays.asList(bat_right, bat_right1, bat_right2));


    // frog
    public static Sprite frog = new Sprite(SIZE, 0, 0, "frog");
    public static Sprite frog1 = new Sprite(SIZE, 0, 0, "frog1");
    public static Sprite frog2 = new Sprite(SIZE, 0, 0, "frog2");
    public static ArrayList<Sprite> frogList = new ArrayList<>(Arrays.asList(frog, frog1, frog2));
    public static ArrayList<Sprite> frogMove = new ArrayList<>(Arrays.asList(frog2, frog1, frog));

    // eye
    public static Sprite pink_eye = new Sprite(SIZE, 0, 0, "pink-eye");
    public static Sprite pink_eye1 = new Sprite(SIZE, 0, 0, "pink-eye1");
    public static Sprite pink_eye2 = new Sprite(SIZE, 0, 0, "pink-eye2");
    public static ArrayList<Sprite> pinkEyeList = new ArrayList<>(Arrays.asList(pink_eye, pink_eye1, pink_eye2));

    public static Sprite red_eye = new Sprite(SIZE, 0, 0, "red-eye");
    public static Sprite red_eye1 = new Sprite(SIZE, 0, 0, "red-eye1");
    public static Sprite red_eye2 = new Sprite(SIZE, 0, 0, "red-eye2");
    public static ArrayList<Sprite> redEyeList = new ArrayList<>(Arrays.asList(red_eye, red_eye1, red_eye2));

    public static ArrayList<Sprite> EyeList = new ArrayList<>(Arrays.asList(red_eye, pink_eye, red_eye1, pink_eye1, red_eye2, pink_eye2));


    // ghost
    public static Sprite ghost_up = new Sprite(SIZE, 0, 0, "ghost-up");
    public static Sprite ghost_up1 = new Sprite(SIZE, 0, 0, "ghost-up1");
    public static Sprite ghost_up2 = new Sprite(SIZE, 0, 0, "ghost-up2");
    public static ArrayList<Sprite> GhostUpList = new ArrayList<>(Arrays.asList(ghost_up, ghost_up1, ghost_up2));

    public static Sprite ghost_down = new Sprite(SIZE, 0, 0, "ghost-down");
    public static Sprite ghost_down1 = new Sprite(SIZE, 0, 0, "ghost-down1");
    public static Sprite ghost_down2 = new Sprite(SIZE, 0, 0, "ghost-down2");
    public static ArrayList<Sprite> GhostDownList = new ArrayList<>(Arrays.asList(ghost_down, ghost_down1, ghost_down2));

    public static Sprite ghost_left = new Sprite(SIZE, 0, 0, "ghost-left");
    public static Sprite ghost_left1 = new Sprite(SIZE, 0, 0, "ghost-left1");
    public static ArrayList<Sprite> GhostLeftList = new ArrayList<>(Arrays.asList(ghost_left, ghost_left1));

    public static Sprite Ghost_right = new Sprite(SIZE, 0, 0, "ghost-right");
    public static Sprite Ghost_right1 = new Sprite(SIZE, 0, 0, "ghost-right1");
    public static ArrayList<Sprite> GhostRightList = new ArrayList<>(Arrays.asList(Ghost_right, Ghost_right1));


    //enemy dead
    public static Sprite enemy_dead = new Sprite(SIZE, 0, 0, "enemy-dead");
    public static Sprite enemy_dead1 = new Sprite(SIZE, 0, 0, "enemy-dead1");
    public static Sprite enemy_dead2 = new Sprite(SIZE, 0, 0, "enemy-dead2");
    public static Sprite enemy_dead3 = new Sprite(SIZE, 0, 0, "enemy-dead3");
    public static Sprite enemy_dead4 = new Sprite(SIZE, 0, 0, "enemy-dead4");

    public static Sprite enemy_a_dead = new Sprite(SIZE, 0, 0, "enemy-a-dead");
    public static Sprite enemy_a_dead1 = new Sprite(SIZE, 0, 0, "enemy-a-dead1");
    public static Sprite enemy_a_dead2 = new Sprite(SIZE, 0, 0, "enemy-a-dead2");
    public static Sprite enemy_a_dead3 = new Sprite(SIZE, 0, 0, "enemy-a-dead3");
    public static Sprite enemy_a_dead4 = new Sprite(SIZE, 0, 0, "enemy-a-dead4");

    public static Sprite oneal_dead_1 = new Sprite(SIZE, 0, 0, "oneal-dead");
    public static Sprite oneal_dead_2 = new Sprite(SIZE, 0, 0, "oneal-dead1");

    public static Sprite ghost_dead_ = new Sprite(SIZE, 0, 0, "ghost-dead");
    public static Sprite ghost_dead1 = new Sprite(SIZE, 0, 0, "ghost-dead1");
    public static Sprite ghost_dead2 = new Sprite(SIZE, 0, 0, "ghost-dead2");
    public static Sprite ghost_dead3 = new Sprite(SIZE, 0, 0, "ghost-dead3");

    public static Sprite eye_dead_ = new Sprite(SIZE, 0, 0, "eye-dead");
    public static Sprite eye_dead_1 = new Sprite(SIZE, 0, 0, "eye-dead1");
    public static Sprite eye_dead_2 = new Sprite(SIZE, 0, 0, "eye-dead2");
    public static Sprite eye_dead_3 = new Sprite(SIZE, 0, 0, "eye-dead3");
    public static Sprite eye_dead_4 = new Sprite(SIZE, 0, 0, "eye-dead4");
    public static Sprite eye_dead_5 = new Sprite(SIZE, 0, 0, "eye-dead5");
    public static Sprite eye_dead_6 = new Sprite(SIZE, 0, 0, "eye-dead6");

    public static Sprite balloon_dead = new Sprite(SIZE, 0, 0, "balloon-dead");
    public static Sprite bat_dead_ = new Sprite(SIZE, 0, 0, "bat-dead");
    public static Sprite frog_dead_ = new Sprite(SIZE, 0, 0, "frog-dead");

    public static ArrayList<Sprite> frog_Dead = new ArrayList<>(Arrays.asList(frog_dead_, enemy_dead, enemy_dead1, enemy_dead2, enemy_dead3, enemy_dead4));
    public static ArrayList<Sprite> balloonDeadList = new ArrayList<>(Arrays.asList(balloon_dead, enemy_dead, enemy_dead1, enemy_dead2, enemy_dead3, enemy_dead4));
    public static ArrayList<Sprite> bat_dead = new ArrayList<>(Arrays.asList(bat_dead_, enemy_dead, enemy_dead1, enemy_dead2, enemy_dead3, enemy_dead4));
    public static ArrayList<Sprite> ghost_dead = new ArrayList<>(Arrays.asList(ghost_dead_, ghost_dead1, ghost_dead2, ghost_dead3));
    public static ArrayList<Sprite> oneal_dead = new ArrayList<>(Arrays.asList(oneal_dead_1,oneal_dead_2, enemy_a_dead, enemy_a_dead1, enemy_a_dead2, enemy_a_dead3, enemy_a_dead4));
    public static ArrayList<Sprite> eye_dead = new ArrayList<>(Arrays.asList(eye_dead_,eye_dead_1, eye_dead_2, eye_dead_3, eye_dead_4, eye_dead_5, eye_dead_6));

    /**
     * Info Bar
     */
    //digits
    public static Sprite digit_10 = new Sprite(8, 14, "p");
    public static Sprite digit_0 = new Sprite(8, 14, "0");
    public static Sprite digit_1 = new Sprite(8, 14, "1");
    public static Sprite digit_2 = new Sprite(8, 14, "2");
    public static Sprite digit_3 = new Sprite(8, 14, "3");
    public static Sprite digit_4 = new Sprite(8, 14, "4");
    public static Sprite digit_5 = new Sprite(8, 14, "5");
    public static Sprite digit_6 = new Sprite(8, 14, "6");
    public static Sprite digit_7 = new Sprite(8, 14, "7");
    public static Sprite digit_8 = new Sprite(8, 14, "8");
    public static Sprite digit_9 = new Sprite(8, 14, "9");

    //bars
    public static Sprite startBar = new Sprite(272, 32, "bar");
    public static Sprite startBar_1 = new Sprite(272, 32, "bar2");
    public static Sprite inGameBar = new Sprite(272, 32, "bar1");

    public static ArrayList<Sprite> startBarList = new ArrayList<>(Arrays.asList(startBar, startBar_1));
    //clock
    public static Sprite clock = new Sprite(32, 14, "clock");

    public static Sprite speed_item = new Sprite(SIZE, 0, 0, "speed-item");
    public static Sprite speed_item1 = new Sprite(SIZE, 0, 0, "speed-item1");
    public static ArrayList<Sprite> speedItem = new ArrayList<>(Arrays.asList(speed_item, speed_item1));

    public static Sprite flame_item = new Sprite(SIZE, 0, 0, "flame-item");
    public static Sprite flame_item1 = new Sprite(SIZE, 0, 0, "flame-item1");
    public static ArrayList<Sprite> flameItem = new ArrayList<>(Arrays.asList(flame_item, flame_item1));

    public static Sprite bomb_item = new Sprite(SIZE, 0, 0, "bomb-item");
    public static Sprite bomb_item1 = new Sprite(SIZE, 0, 0, "bomb-item1");
    public static ArrayList<Sprite> bombItem = new ArrayList<>(Arrays.asList(bomb_item, bomb_item1));

    public static Sprite stage_1 = new Sprite(49, 9, "stage");
    public static Sprite stage_2 = new Sprite(51, 9, "stage_2");
    public static Sprite game_over = new Sprite(94, 16, "gameover");

    public static Sprite movingSprite(ArrayList<Sprite> spritesList, int animate, int time) {
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
