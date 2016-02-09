import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage[] playerUp;
    public static BufferedImage[] playerRight;
    public static BufferedImage[] playerDown;
    public static BufferedImage[] playerLeft;
    public static BufferedImage grass;
    public static BufferedImage rock;
    public static BufferedImage dirt;

    private static final int playerSide = 64;
    private static final int grassSide = 32;
    private static final int rockSide = 32;
    private static final int dirtSide = 32;
    //Loads the necessary sprite sheets and crops them
    public static void init(){
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/BODY_skeleton.png"));
        SpriteSheet grassSheet = new SpriteSheet(ImageLoader.loadImage("/textures/grass.png"));
        SpriteSheet rockSheet = new SpriteSheet(ImageLoader.loadImage("/textures/rock.png"));
        SpriteSheet dirtSheet = new SpriteSheet(ImageLoader.loadImage("/textures/dirt.png"));

        playerUp = new BufferedImage[9];
        playerUp[0] = playerSheet.crop(0, 0, playerSide, playerSide);
        playerUp[1] = playerSheet.crop(playerSide, 0, playerSide, playerSide);
        playerUp[2] = playerSheet.crop(playerSide * 2, 0, playerSide, playerSide);
        playerUp[3] = playerSheet.crop(playerSide * 3, 0, playerSide, playerSide);
        playerUp[4] = playerSheet.crop(playerSide * 4, 0, playerSide, playerSide);
        playerUp[5] = playerSheet.crop(playerSide * 5, 0, playerSide, playerSide);
        playerUp[6] = playerSheet.crop(playerSide * 6, 0, playerSide, playerSide);
        playerUp[7] = playerSheet.crop(playerSide * 7, 0, playerSide, playerSide);
        playerUp[8] = playerSheet.crop(playerSide * 8, 0, playerSide, playerSide);
        playerRight = new BufferedImage[9];
        playerRight[0] = playerSheet.crop(0, playerSide, playerSide, playerSide);
        playerRight[1] = playerSheet.crop(playerSide, playerSide, playerSide, playerSide);
        playerRight[2] = playerSheet.crop(playerSide * 2, playerSide, playerSide, playerSide);
        playerRight[3] = playerSheet.crop(playerSide * 3, playerSide, playerSide, playerSide);
        playerRight[4] = playerSheet.crop(playerSide * 4, playerSide, playerSide, playerSide);
        playerRight[5] = playerSheet.crop(playerSide * 5, playerSide, playerSide, playerSide);
        playerRight[6] = playerSheet.crop(playerSide * 6, playerSide, playerSide, playerSide);
        playerRight[7] = playerSheet.crop(playerSide * 7, playerSide, playerSide, playerSide);
        playerRight[8] = playerSheet.crop(playerSide * 8, playerSide, playerSide, playerSide);
        playerDown = new BufferedImage[9];
        playerDown[0] = playerSheet.crop(0, playerSide * 2, playerSide, playerSide);
        playerDown[1] = playerSheet.crop(playerSide, playerSide * 2, playerSide, playerSide);
        playerDown[2] = playerSheet.crop(playerSide * 2, playerSide * 2, playerSide, playerSide);
        playerDown[3] = playerSheet.crop(playerSide * 3, playerSide * 2, playerSide, playerSide);
        playerDown[4] = playerSheet.crop(playerSide * 4, playerSide * 2, playerSide, playerSide);
        playerDown[5] = playerSheet.crop(playerSide * 5, playerSide * 2, playerSide, playerSide);
        playerDown[6] = playerSheet.crop(playerSide * 6, playerSide * 2, playerSide, playerSide);
        playerDown[7] = playerSheet.crop(playerSide * 7, playerSide * 2, playerSide, playerSide);
        playerDown[8] = playerSheet.crop(playerSide * 8, playerSide * 2, playerSide, playerSide);
        playerLeft = new BufferedImage[9];
        playerLeft[0] = playerSheet.crop(0, playerSide * 3, playerSide, playerSide);
        playerLeft[1] = playerSheet.crop(playerSide, playerSide * 3, playerSide, playerSide);
        playerLeft[2] = playerSheet.crop(playerSide * 2, playerSide * 3, playerSide, playerSide);
        playerLeft[3] = playerSheet.crop(playerSide * 3, playerSide * 3, playerSide, playerSide);
        playerLeft[4] = playerSheet.crop(playerSide * 4, playerSide * 3, playerSide, playerSide);
        playerLeft[5] = playerSheet.crop(playerSide * 5, playerSide * 3, playerSide, playerSide);
        playerLeft[6] = playerSheet.crop(playerSide * 6, playerSide * 3, playerSide, playerSide);
        playerLeft[7] = playerSheet.crop(playerSide * 7, playerSide * 3, playerSide, playerSide);
        playerLeft[8] = playerSheet.crop(playerSide * 8, playerSide * 3, playerSide, playerSide);

        grass = grassSheet.crop(0, grassSide * 5, grassSide, grassSide);
        rock = rockSheet.crop(0, 0, rockSide, rockSide);
        dirt = dirtSheet.crop(0, dirtSide* 5, dirtSide, dirtSide);
    }
}
