import java.awt.*;

public class GameObject {
    int x;
    int y;
    int width;
    int height;
    boolean isAlive = true;
    Rectangle collisionBox;



    GameObject(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    collisionBox = new Rectangle(x, y, width, height);
    }

    public void update() {
        collisionBox.setBounds(x, y, width, height);
    }

    public void draw(Graphics g) {
       
    }
}
