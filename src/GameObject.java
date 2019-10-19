import java.awt.*;

public class GameObject {
    int x;
    int y;
    int width;
    int height;

    GameObject(int x, int y, int width, int height) {

    }
    public void update() {
    x = x + 10;
    y = y + 10;
    }
    public void draw(Graphics g) {
        g.fillRect(x, y, 100, 100);
    }
}
