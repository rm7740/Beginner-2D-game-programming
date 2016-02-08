import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
    protected BufferedImage texture;
    protected final int ID;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public void update(){

    }

    public void render(Graphics graphics, int x, int y){
        graphics.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT,null);
    }
}
