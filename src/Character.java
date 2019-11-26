import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Character {
    int x= 50, y = 50;

//    Direcao dir;

    public Character() {
    }

    protected void desenhar(Graphics g) {
        g.setColor(Color.BLUE);
//        g.fillOval(x,y, 20,20);
        g.fillArc(x,y,20,20, 30, 300);
//        g.drawOval(x,y, 20,20);
        g.setColor(Color.GREEN);
        g.fillOval(x-10,y, 15, 15);
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
