package uet.oop.bomberman.graphics;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;



public class NewSprite {

    private static final int SIZE = 16;
    public static final int SCALED_SIZE = SIZE * 36 / 16;
    public static double SCALED_FACTOR =2.25;
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
            System.out.println(name + " " + originalWidth + " " + originalWidth * SCALED_FACTOR + " "
                    + originalHeight + " " + originalHeight * SCALED_FACTOR);
        } catch (Exception e) {

            System.out.println("khong tim thay file sprite " + name);
        }
        this.distanceToTopLeftX = distanceToTopLeftX;
        this.distanceToTopLeftY = distanceToTopLeftY;
        this.name=name;

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
    public static NewSprite bomb1_1 = new NewSprite(SIZE, 0, 0, "1-bomb-1");
    public static NewSprite bomb1_2 = new NewSprite(SIZE, 0, 0, "1-bomb-2");
    public static NewSprite bomb1_3 = new NewSprite(SIZE, 0, 0, "1-bomb-3");

    public static NewSprite bomb2_1 = new NewSprite(SIZE, 0, 0, "2-bomb-1");
    public static NewSprite bomb2_2 = new NewSprite(SIZE, 0, 0, "2-bomb-2");
    public static NewSprite bomb2_3 = new NewSprite(SIZE, 0, 0, "2-bomb-3");

    public static ArrayList<NewSprite> bomb1List = new ArrayList<NewSprite>(Arrays.asList(bomb1_1, bomb1_2, bomb1_3));
    public static ArrayList<NewSprite> bomb2List = new ArrayList<NewSprite>(Arrays.asList(bomb2_1, bomb2_2, bomb2_3));

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

    //explosion
    public static NewSprite explosion_horizontal_1 = new NewSprite(SIZE, 0, 0, "explosion-horizontal");
    public static NewSprite explosion_horizontal_2 = new NewSprite(SIZE, 0, 0, "explosion-horizontal1");

    public static NewSprite explosion_horizontal_left_last_1 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-leftlast");
    public static NewSprite explosion_horizontal_left_last_2 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-leftlast1");

    public static NewSprite explosion_horizontal_right_last_1 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-rightlast");
    public static NewSprite explosion_horizontal_right_last_2 = new NewSprite(SIZE, 0, 0, "explosion-horizontal-leftlast1");

    public static NewSprite explosion_vertical_1 = new NewSprite(SIZE, 0, 0, "explosion-vertical");
    public static NewSprite explosion_vertical_2 = new NewSprite(SIZE, 0, 0, "explosion-vertical1");

    public static NewSprite explosion_vertical_top_last_1 = new NewSprite(SIZE, 0, 0, "explosion-vertical-toplast");
    public static NewSprite explosion_vertical_top_last_2 = new NewSprite(SIZE, 0, 0, "explosion-vertical-toplast1");

    public static NewSprite explosion_vertical_bot_last_1 = new NewSprite(SIZE, 0, 0, "explosion-vertical-botlast");
    public static NewSprite explosion_vertical_bot_last_2 = new NewSprite(SIZE, 0, 0, "explosion-vertical-botlast1");

    //portal
    public static NewSprite portal_1 = new NewSprite(SIZE, 0, 0, "portal");
    public static NewSprite portal_2 = new NewSprite(SIZE, 0, 0, "portal1");
    public static NewSprite portal_3 = new NewSprite(SIZE, 0, 0, "portal2");
    public static NewSprite portal_4 = new NewSprite(SIZE, 0, 0, "portal3");
    public static NewSprite portal_5 = new NewSprite(SIZE, 0, 0, "portal4");
    public static NewSprite portal_6 = new NewSprite(SIZE, 0, 0, "portal5");
    public static NewSprite portal_7 = new NewSprite(SIZE, 0, 0, "portal6");

    public static ArrayList<NewSprite> portalList = new ArrayList<NewSprite>(Arrays.asList(
            portal_1, portal_2, portal_3, portal_4, portal_5, portal_6, portal_7));

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

    /**
     * enemies
     */
    //balloon
    public static NewSprite balloon_dead = new NewSprite(SIZE, 0, 0, "balloon-dead");
    public static NewSprite balloon_right = new NewSprite(SIZE, 0, 0, "balloon-right");
    public static NewSprite balloon_right_1 = new NewSprite(SIZE, 0, 0, "balloon-right1");
    public static NewSprite balloon_right_2 = new NewSprite(SIZE, 0, 0, "balloon-right2");

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
