import javax.swing.*;
import java.awt.*;

public class Character extends JPanel {
    public Character() {
        setPreferredSize(new Dimension(150,150));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
//        g.setPaintMode();
        g.drawRect(0,0, 150,150);
    }

}
