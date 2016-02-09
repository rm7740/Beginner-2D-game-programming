import java.awt.*;

public class Tree extends StaticEntity{

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH * 3, Tile.TILE_HEIGHT * 4);

        bounds.x = 32;
        bounds.y = 80;
        bounds.width = 20;
        bounds.height = 28;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Asset.greenTree, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        //graphics.setColor(Color.BLUE);
        //graphics.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
        //        (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }
}
