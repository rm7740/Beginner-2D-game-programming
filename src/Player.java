import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends LiveEntity{

    private Animation playerUp;
    private Animation playerRight;
    private Animation playerDown;
    private Animation playerLeft;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, DEFAULT_ENTITY_WIDTH, DEFAULT_ENTITY_HEIGHT);

        bounds.x = 20;
        bounds.y = 30;
        bounds.width = 24;
        bounds.height = 24;

        playerUp = new Animation(100, Asset.playerUp);
        playerRight = new Animation(100, Asset.playerRight);
        playerDown = new Animation(100, Asset.playerDown);
        playerLeft = new Animation(100, Asset.playerLeft);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void update() {
        playerUp.update();
        playerRight.update();
        playerDown.update();
        playerLeft.update();

        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height,null);
        graphics.setColor(Color.BLUE);
        graphics.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return playerLeft.getCurrentAnimationFrame();
        } else if(xMove > 0){
            return playerRight.getCurrentAnimationFrame();
        } else if(yMove < 0){
            return playerUp.getCurrentAnimationFrame();
        } else if(yMove > 0){
            return playerDown.getCurrentAnimationFrame();
        } else{
            return playerDown.getFixedAnimationFrame(0);
        }
    }
}
