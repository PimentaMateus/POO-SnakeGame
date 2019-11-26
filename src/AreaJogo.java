import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class AreaJogo extends JPanel {
    Character c;
    private Timer timer;
    private int ultimaTecla = KeyEvent.VK_RIGHT;
    private Set<Integer> teclas;

    public AreaJogo() {
        teclas = new HashSet<>();
        teclas.add(KeyEvent.VK_UP);
        teclas.add(KeyEvent.VK_DOWN);
        teclas.add(KeyEvent.VK_LEFT);
        teclas.add(KeyEvent.VK_RIGHT);
        this.c = new Character();
        timer = new Timer(100, (actionEvent) -> {
            repaint();
        });
        timer.start();
    }

    protected void togglePause() {
        if (timer.isRunning())
            timer.stop();
        else
            timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        c.setKey(ultimaTecla);
        c.desenhar(g);
    }

    protected void processarTecla(KeyEvent e) {
        if (teclas.contains(e.getKeyCode()))
            ultimaTecla = e.getKeyCode();
    }
}
