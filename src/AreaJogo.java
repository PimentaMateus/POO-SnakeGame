import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AreaJogo extends JPanel {
    Character c;
    private Timer timer;
    private int ultimaTecla = KeyEvent.VK_RIGHT;
    private Set<Integer> teclas;
    private Integer pontuacao = 0;
    private List<Frutinha> frutinhas = new ArrayList<>();
    private int ticks = 0;

    public AreaJogo() {
        teclas = new HashSet<>();
        teclas.add(KeyEvent.VK_UP);
        teclas.add(KeyEvent.VK_DOWN);
        teclas.add(KeyEvent.VK_LEFT);
        teclas.add(KeyEvent.VK_RIGHT);
        novoJogo();
    }

    public void novoJogo() {
        pontuacao = 0;
        ticks = 0;
        this.c = new Character();
        timer = new Timer(500, this::refreshArea);
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

        mostrarPontuacao(g);

        c.setKey(ultimaTecla);
        c.desenhar(g);

        for (Frutinha frutinha : frutinhas) {
            frutinha.desenhar(g);
        }

        c.avaliar(new Validavel() {
            @Override
            public void pos(int x, int y, int alt, int larg) {
                if (x < 0 || y < 0 || x + larg > getWidth() || y+alt > getHeight())
                    throw new FimDeJogo();
            }
        });
    }

    private void mostrarPontuacao(Graphics g) {
        g.setColor(Color.RED);
        String pontuacao = "Pontuação: " + this.pontuacao.toString();
        g.drawChars(pontuacao.toCharArray(), 0, pontuacao.length(), 10, 10);
    }

    protected void processarTecla(KeyEvent e) {
        if (teclas.contains(e.getKeyCode()))
            ultimaTecla = e.getKeyCode();
    }

    private void refreshArea(ActionEvent actionEvent) {

        if (ticks % 5 == 0) {
            frutinhas.add(new Frutinha());
        }
        try {
            repaint();
            ticks++;
        } catch (FimDeJogo fimDeJogo) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "ACABOU");
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public static class FimDeJogo extends RuntimeException {

    }
}
