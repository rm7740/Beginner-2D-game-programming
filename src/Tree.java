import java.awt.*;

public class Tree extends StaticEntity{

    public Tree(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, Tile.TILE_WIDTH * 3, Tile.TILE_HEIGHT * 4);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Asset.greenTree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
