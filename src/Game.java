import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    private int width, height;
    private String title;

    private Thread thread;
    private boolean isRunning;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    int x=0;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    @Override
    public void run() {
        init();
        //the game loop
        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int updates = 0;

        while(isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            timer += (now - lastTime);
            lastTime = now;
            if (delta >= 1) {
                update();
                render();
                updates++;
                delta--;
            }
            if(timer >= 1000000000){
                System.out.println("Updates and frames: " + updates);
                timer = 0;
                updates = 0;
            }
        }
        stop();
    }

    private void init() {
        display = new Display(title, width, height);
        Asset.init();
    }

    public synchronized void start(){
        if(isRunning) {
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!isRunning) {
            return;
        }
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update(){
        x+=1;
    }

    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        //clear the screen
        graphics.clearRect(0, 0, width, height);
        //drawing begins here
        graphics.drawImage(Asset.town, 0, 0, null);
        graphics.drawImage(Asset.pokemon, 100, 20, null);
        graphics.drawImage(Asset.player, x, 100, null);
        //drawing ends here
        bufferStrategy.show();
        graphics.dispose();
    }
}
