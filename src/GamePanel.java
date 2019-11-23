//import com.sun.tools.javac.comp.Enter;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(1000 / 60, this);
    //GameObject go;
    Font titleFont;
    Font subtitleFont;
    final int MENU_STATE = 0;
    final int GAME_STATE = 1;
    final int END_STATE = 2;
    int currentState = MENU_STATE;
    Rocketship rs = new Rocketship(225, 700, 50, 50, 30);
    ObjectManager om = new ObjectManager(rs);

    GamePanel() {
        //go = new GameObject(1, 2, 3, 4);
        titleFont = new Font("Arial", Font.PLAIN, 48);
        subtitleFont = new Font("Arial", Font.PLAIN, 25);
    }

    public void updateMenuState() {
    }

    public void updateGameState() {
        rs.update();
        om.checkCollision();
        om.purgeObjects();
        om.manageEnemies();
        om.update();
        if (rs.isAlive == false) {
            currentState = END_STATE;
        }
    }

    public void updateEndState() {
    }

    public void drawMenuState(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 500, 800);
        g.setColor(Color.YELLOW);
        g.setFont(titleFont);
        g.drawString("LEAGUE INVADERS", 25, 400);
    }

    public void drawGameState(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 800);
        rs.draw(g);
        om.draw(g);
    }

    public void drawEndState(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 500, 800);
        g.setColor(Color.YELLOW);
        g.setFont(titleFont);
        g.drawString("GAME OVER", 90, 400);
       // g.setFont(subtitleFont);
        //g.drawString("Score: " + , 90, 400);
    }

    public void actionPerformed(ActionEvent e) {
        if (currentState == MENU_STATE) {
            updateMenuState();
        } else if (currentState == GAME_STATE) {
            updateGameState();
        } else if (currentState == END_STATE) {
            updateEndState();
        }
        //go.update();
        repaint();
    }

    public void startGame() {
        timer.start();
    }

    public void paintComponent(Graphics g) {
        if (currentState == MENU_STATE) {
            drawMenuState(g);
        } else if (currentState == GAME_STATE) {
            drawGameState(g);
        } else if (currentState == END_STATE) {
            drawEndState(g);
        }
        //go.draw(g);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (currentState == MENU_STATE) {
                currentState = GAME_STATE;
            } else if (currentState == GAME_STATE) {
                currentState = END_STATE;
            } else if (currentState == END_STATE) {
                currentState = MENU_STATE;
            }
            if (currentState == END_STATE) {
                rs = new Rocketship(225, 700, 50, 50, 30);
                om = new ObjectManager(rs);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            rs.y = rs.y - rs.speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            rs.y = rs.y + rs.speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rs.x = rs.x - rs.speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rs.x = rs.x + rs.speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            om.addProjectile(new Projectile(rs.x + 20, rs.y, 10, 10, 10));
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
