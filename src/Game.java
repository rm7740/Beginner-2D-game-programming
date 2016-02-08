import com.sun.prism.impl.paint.PaintUtil;

public class Game implements Runnable {

    private Display display;
    private int width, height;//I think this is unnecessary
    private Thread thread;
    private boolean isRunning;
    private String title;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    @Override
    public void run() {
        init();
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

    }
}
