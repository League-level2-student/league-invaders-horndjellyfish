import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(1000 / 60, this);
    GameObject go = new GameObject(1, 2, 3, 4);

    public void actionPerformed(ActionEvent e) {
        go.update();
        repaint();
    }

    public void startGame() {
        timer.start();
    }

    public void paintComponent(Graphics g) {
        go.draw(g);
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("a message");
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("a message");
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("a message");
    }
}
