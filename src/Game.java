import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    //Variables related to the display
    private Display display;
    private int width, height;
    private String title;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    //Variables related to the thread that runs the game
    private Thread thread;
    private boolean isRunning;
    //The stateS of the game running on the thread
    private State gameState;
    private State menuState;
    //Input variables
    private KeyManager keyManager;
    //The constructor
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }
    //The job of the thread, the game loop
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
    //Loads all that should be loaded and sets a state for the game
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Asset.init();
        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setCurrentState(gameState);
    }
    //Starts the thread where the game runs
    public synchronized void start(){
        if(isRunning) {
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    //Stops the game by exiting the game loop
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
    //The heart of the game
    private void update(){
        if(State.getCurrentState() != null){
            State.getCurrentState().update();
        }
    }
    //The graphics of the game
    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, width, height);
        //This is what actually renders
        if(State.getCurrentState() != null){
            State.getCurrentState().render(graphics);
        }
        bufferStrategy.show();
        graphics.dispose();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
}
