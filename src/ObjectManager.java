import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
    Rocketship ros;
    int score = 0;

    public int getScore() {
        for (int i = 0; i < aliens.size(); i++) {
            if (aliens.get(i).isAlive = false) {
                this.score = score + 1;
            }
        }
                
        return this.score;
    }

    ObjectManager(Rocketship ros) {
        this.ros = ros;
    }

    ArrayList<Projectile> projectiles = new ArrayList<>();
    ArrayList<Alien> aliens = new ArrayList<>();

    public void addAlien(Alien alien) {
        this.aliens.add(alien);
    }

    public void addProjectile(Projectile projectile) {

        this.projectiles.add(projectile);
    }

    public void update() {
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).update();
        }
        for (int i = 0; i < aliens.size(); i++) {
            aliens.get(i).update();
        }
        ros.update();
    }

    public void draw(Graphics g) {
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).draw(g);
        }
        for (int i = 0; i < aliens.size(); i++) {
            aliens.get(i).draw(g);
        }
        ros.draw(g);

    }

    long enemyTimer = 0;
    int enemySpawnTime = 1000;

    public void manageEnemies() {
        if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
            addAlien(new Alien(new Random().nextInt(500), 0, 50, 50));

            enemyTimer = System.currentTimeMillis();
        }
    }

    public void purgeEnemies() {
        for (int i = 0; i < aliens.size(); i++) {
            if (aliens.get(i).isAlive = false) {
                aliens.remove(i);
            }
        }
    }

    public void checkCollision() {
        for (int i = 0; i < aliens.size(); i++) {
            if (ros.collisionBox.intersects(aliens.get(i).collisionBox)) {
                ros.isAlive = false;
            }

        }
        for (int i = 0; i < projectiles.size(); i++) {
            for (int j = 0; j < aliens.size(); j++) {
                if (aliens.get(j).collisionBox.intersects(projectiles.get(i).collisionBox)) {
                    aliens.get(j).isAlive = false;
                }
            }
        }

    }
}
