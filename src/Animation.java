import java.awt.image.BufferedImage;

public class Animation {

    private int speed, index;
    private BufferedImage[] animationFrames;
    private long lastTime, timer;

    public Animation(int speed, BufferedImage[] animationFrames) {
        this.speed = speed;
        this.animationFrames = animationFrames;
        index = 1;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public BufferedImage getCurrentAnimationFrame(){
        return animationFrames[index];
    }

    public BufferedImage getFixedAnimationFrame(int index) {
        return animationFrames[index];
    }

    public void update(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer >= speed){
            index++;
            timer = 0;
            if(index >= animationFrames.length){
                index = 1;
            }
        }
    }
}
