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
    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    @Override
    public void run() {
        init();
        //the game loop
        while(isRunning){
            update();
            render();
        }
    }

    private void init() {
        display = new Display(title, width, height);
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

        //drawing ends here
        bufferStrategy.show();
        graphics.dispose();
    }
}
