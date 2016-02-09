import java.awt.*;

public class Player extends LiveEntity{


    public Player(Game game, float x, float y) {
        super(game, x, y, DEFAULT_ENTITY_WIDTH, DEFAULT_ENTITY_HEIGHT);
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
