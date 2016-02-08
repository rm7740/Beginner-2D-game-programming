import java.awt.*;

public abstract class Entity {

    protected float x, y;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract update();
    public abstract render(Graphics graphics);
}
