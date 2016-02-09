import java.awt.*;

public class GameState extends State{

    private Player player;
    private World world;
    private Tree tree;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
        player = new Player(handler, 100, 100);
        tree = new Tree(handler, 150, 150);
    }

    @Override
    public void update() {
        world.update();
        player.update();
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
        tree.render(graphics);
        player.render(graphics);
    }
}
