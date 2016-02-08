import java.awt.*;

public class Player extends LiveEntity{

    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Asset.player, (int) x, (int) y, null);
    }
}
