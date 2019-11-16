import java.awt.*;

public class Rocketship extends GameObject {
    int speed;

    Rocketship(int x, int y, int width, int height, int speed) {
        super(x, y, width, height);
        this.speed = speed;

    }

    public void update() {
        super.update();
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
