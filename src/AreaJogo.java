import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AreaJogo extends JPanel {
    Character c;
    Timer timer;

    public AreaJogo() {

        this.c = new Character();
        timer = new Timer(1000, (actionEvent) -> {
            repaint();
        });
        timer.start();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println(e);
            }
        });
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        c.desenhar(g);
    }

    protected void processarTecla(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) c.moveDown();
        if (e.getKeyCode() == KeyEvent.VK_UP) c.moveUp();
        if (e.getKeyCode() == KeyEvent.VK_LEFT) c.moveLeft();
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) c.moveRight();
    }
}
