import java.awt.*;
import java.util.ArrayList;
public class ObjectManager {
    Rocketship ros;
    ObjectManager (Rocketship ros) {
        this.ros = ros;
    }

     ArrayList<Projectile> projectiles = new ArrayList<>();
    public void addProjectile(Projectile projectile) {
       this.projectiles.add(projectile);
    }
    public void update() {
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).update();
        }ros.update();

    }
    public void draw(Graphics g) {
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).update();
        }
        ros.draw(g);

    }

}
