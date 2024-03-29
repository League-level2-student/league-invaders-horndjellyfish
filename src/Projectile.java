import java.awt.*;

public class Projectile extends GameObject {
    int speed;

    Projectile(int x, int y, int width, int height, int speed) {
        super(x, y, width, height);
        this.speed = 10;
        this.speed = speed;
    }


    public void update() {
        super.update();
        y = y - speed;
        if (y < 0) {
            isAlive = false;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
    }
}
