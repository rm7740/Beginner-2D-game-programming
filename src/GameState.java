import java.awt.*;

public class GameState extends State{

    public GameState() {
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Asset.player, 10, 20, null);
    }
}
