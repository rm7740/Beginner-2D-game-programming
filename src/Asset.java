import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage player, pokemon, town;

    private static final int playerWidth = 14, playerHeight = 16;
    private static final int pokemonWidth = 56, pokemonHeight = 56;
    private static final int townWidth = 320, townHeight = 288;

    public static void init(){
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Game Boy GBC - Pokemon Gold Silver - Gold.gif"));
        SpriteSheet pokemonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Game Boy GBC - Pokemon Gold Silver - Pokemon Silver Version.png"));
        SpriteSheet townSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Game Boy GBC - Pokemon Gold Silver - Pallet Town.png"));

        player = playerSheet.crop(58, 4, playerWidth, playerHeight);
        pokemon = pokemonSheet.crop(72, 152, pokemonWidth, pokemonHeight);
        town = townSheet.crop(6, 5, townWidth, townHeight);
    }
}
