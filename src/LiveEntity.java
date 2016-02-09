
public abstract class LiveEntity extends Entity{

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_ENTITY_WIDTH = 64, DEFAULT_ENTITY_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public LiveEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        if (!checkEntityCollisions(xMove, 0f)) {
            moveX();
        }
        if(!checkEntityCollisions(0f, yMove)) {
            moveY();
        }
    }

    public void moveX(){
        if(xMove > 0){//moving right
            int temporalX = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if(!collisionWithTile(temporalX,(int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(temporalX,(int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
                x += xMove;
            } else{//this is here to fix a problem that stems from having speed>1, so if the box tries to move 3 pixels being 2 pixels away, a collision is detected and the box will stay 2 pixels away
                x = temporalX * Tile.TILE_WIDTH -bounds.x - bounds.width - 1;
            }
        } else if(xMove < 0){//moving left
            int temporalX = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if(!collisionWithTile(temporalX,(int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(temporalX,(int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
                x += xMove;
            } else{//same fix as above
                x = temporalX * Tile.TILE_WIDTH + Tile.TILE_WIDTH -bounds.x;
            }
        }
    }

    public void moveY() {
        if(yMove < 0){//moving up
            int temporalY = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, temporalY) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, temporalY)){
                y += yMove;
            } else{//same problem as moveX
                y = temporalY * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT -bounds.y;
            }
        } else if(yMove > 0){//moving down
            int temporalY = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, temporalY) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, temporalY)) {
                y += yMove;
            } else{//same fix as above
                y = temporalY * Tile.TILE_HEIGHT - bounds.y - bounds.height -1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
