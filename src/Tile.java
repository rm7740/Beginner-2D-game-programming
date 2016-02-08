import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);

    public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
    protected BufferedImage texture;
    protected final int ID;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.ID = id;

        tiles[id] = this;
    }

    public int getID() {
        return ID;
    }

    public void update(){

    }

    public void render(Graphics graphics, int x, int y){
        graphics.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }
}
