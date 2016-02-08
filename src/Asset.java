import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage player;
    public static BufferedImage grass;
    public static BufferedImage rock;
    public static BufferedImage dirt;

    private static final int playerSide = 64;
    private static final int grassSide = 32;
    private static final int rockSide = 32;
    private static final int dirtSide = 32;
    //Loads the necessary sprite sheets and crops them
    public static void init(){
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/simple_clothes.gif"));
        SpriteSheet grassSheet = new SpriteSheet(ImageLoader.loadImage("/textures/grass.png"));
        SpriteSheet rockSheet = new SpriteSheet(ImageLoader.loadImage("/textures/rock.png"));
        SpriteSheet dirtSheet = new SpriteSheet(ImageLoader.loadImage("/textures/dirt.png"));
        player = playerSheet.crop(0, playerSide * 2, playerSide, playerSide);
        grass = grassSheet.crop(0, grassSide * 5, grassSide, grassSide);
        rock = rockSheet.crop(0, 0, rockSide, rockSide);
        dirt = dirtSheet.crop(0, dirtSide* 5, dirtSide, dirtSide);
    }
}
