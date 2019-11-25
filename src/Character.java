import javax.swing.*;
import java.awt.*;

public class Character extends JPanel {
    int x, y = 50;
    @Override
    protected void paintComponent(Graphics g) {
        g.drawRect(x,y, 50,50);
        super.paintComponent(g);
    }

    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

}
