import java.awt.*;

public class GameState extends State{

    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
        world = new World(game, "res/worlds/world1.txt");
    }

    @Override
    public void update() {
        player.update();
        game.getGameCamera().move(1, 1);
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
        player.render(graphics);
    }
}
