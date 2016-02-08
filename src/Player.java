import java.awt.*;

public class Player extends LiveEntity{

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, DEFAULT_ENTITY_WIDTH, DEFAULT_ENTITY_HEIGHT);
        this.game = game;
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up){
            yMove = -speed;
        }
        if(game.getKeyManager().down){
            yMove = speed;
        }
        if(game.getKeyManager().left){
            xMove = -speed;
        }
        if(game.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void update() {
        getInput();
        move();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Asset.player, (int) x, (int) y, width, height,null);
    }
}
