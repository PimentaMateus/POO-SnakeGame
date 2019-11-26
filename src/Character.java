import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Character {
    int x= 0, y = 0;
    private int tam = 20;
    private boolean mudouDir = false;

    private int key = KeyEvent.VK_RIGHT;

    private Map<Integer, Runnable> movimentos;

    public void setKey (int key) {
        mudouDir = this.key != key;
        this.key = key;
    }

    public Character() {
        movimentos = new HashMap<>();
        movimentos.put(KeyEvent.VK_UP, () -> y-=tam);
        movimentos.put(KeyEvent.VK_DOWN, () -> y+=tam);
        movimentos.put(KeyEvent.VK_LEFT, () -> x-=tam);
        movimentos.put(KeyEvent.VK_RIGHT, () -> x+=tam);
    }

    protected void desenhar(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        g.setColor(Color.BLUE);
        int angle = getAngle();
        g.fillArc(x,y,tam,tam, angle + 30, 300);
        if (!mudouDir) {
            mover();
        }
    }

    public void avaliar(Validavel aval) {
        aval.pos(x,y,tam, tam);
    }

    private void mover() {
        movimentos.get(key).run();
    }

    private int getAngle() {
        if (key == KeyEvent.VK_RIGHT) return 0;
        if (key == KeyEvent.VK_LEFT) return 180;
        if (key == KeyEvent.VK_UP) return 90;
        if (key == KeyEvent.VK_DOWN) return 270;
        return 0;
    }

}
