
public class Game {

    private Display display;
    private int width, height;//I think this is unnecessary

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        display = new Display(title, width, height);
    }

}
