import java.awt.*;

public class Player extends LiveEntity{

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, DEFAULT_ENTITY_WIDTH, DEFAULT_ENTITY_HEIGHT);
        this.game = game;
    }

    @Override
    public void update() {
        if(game.getKeyManager().up){
            y -= 3;
        }
        if(game.getKeyManager().down){
            y += 3;
        }
        if(game.getKeyManager().left){
            x -= 3;
        }
        if(game.getKeyManager().right){
            x += 3;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Asset.player, (int) x, (int) y, width, height,null);
    }
}
