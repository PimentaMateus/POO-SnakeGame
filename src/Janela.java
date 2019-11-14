import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class Janela extends JPanel {

    private static final int ALTURA_BARRA_TITULO = 20;
    private JFrame frame;
    private int contador = 0;
    //Container c = JFrame.getContentPane();

    public Janela(String nome){
            frame = new JFrame(nome);
            frame.add(this);
            this.setBackground(Color.green);
            frame.setSize(400, 300 + ALTURA_BARRA_TITULO );
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Comic Sans", Font.BOLD, 16));
        g2d.drawString("Tamanho: " + String.valueOf(contador), 10, 30);
}}
