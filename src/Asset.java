import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage player;

    private static final int playerWidth = 64, playerHeight = 64;
    //Loads the necessary sprite sheets and crops them
    public static void init(){
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/simple_clothes.gif"));

        player = playerSheet.crop(0, playerHeight*2, playerWidth, playerHeight);
    }
}
