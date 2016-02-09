import java.awt.*;

public class World {

    private Game game;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] worldTiles;

    public World(Game game, String path){
        this.game = game;
        loadWorld(path);
    }

    public void update(){

    }

    public void render(Graphics graphics){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                getTile(x, y).render(graphics, (int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
            }
        }
    }

    public Tile getTile(int x, int y){
        Tile theTile = Tile.tiles[worldTiles[x][y]];
        if(theTile == null){
            return Tile.dirtTile;
        }
        return theTile;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        worldTiles = new int[width][height];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                worldTiles[x][y] = Utils.parseInt(tokens[(x + y * width + 4)]);
            }
        }
    }
}
