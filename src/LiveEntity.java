
public abstract class LiveEntity extends Entity{

    protected int health;

    public LiveEntity(float x, float y) {
        super(x, y);
        health = 10;
    }
}
