import com.sun.tools.javac.comp.Enter;

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
    final int MENU_STATE = 0;
    final int GAME_STATE = 1;
    final int END_STATE = 2;
    int currentState = MENU_STATE;
    GamePanel () {
         //go = new GameObject(1, 2, 3, 4);
        titleFont = new Font("Arial", Font.PLAIN, 48);
    }
    public void updateMenuState() {
    }
    public void updateGameState() {
    }
    public void updateEndState() {
    }
    public void drawMenuState(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0,0, 500, 800);
        g.setColor(Color.YELLOW);
        g.setFont(titleFont);
        g.drawString("LEAGUE INVADERS", 250, 400);
    }
    public void drawGameState(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,500,800);
    }
    public void drawEndState(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0,0,500,800);
    }
    public void actionPerformed(ActionEvent e) {
        if (currentState==MENU_STATE) {
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
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
