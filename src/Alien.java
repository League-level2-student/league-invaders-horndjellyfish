import java.awt.*;

public class Alien extends GameObject {
    Alien(int x, int y, int width, int height) {
        super(x, y, width, height);

    }
    public void update() {
        super.update();
        y = y+6;
    }
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
    }
}
