import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
public class Main {

    public static void main(String[] args){
        JFrame frame = new JFrame("Snaker");

        AreaJogo gamePane = new AreaJogo();
        frame.setContentPane(gamePane);
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gamePane.processarTecla(e);
            }
        });

        JMenuBar menubar = new JMenuBar();
        JMenu menuPrincipal = new JMenu("Principal");

        JMenuItem configuracoes = new JMenuItem("Configurações");

        configuracoes.addActionListener(e -> {
            new Menu("Configurações", true);
        });

        menuPrincipal.add(configuracoes);

        menubar.add(menuPrincipal);

        JMenuItem startGame = new JMenuItem("Start game");
        startGame.addActionListener( al -> gamePane.togglePause());
        menubar.add(startGame);

        frame.setJMenuBar(menubar);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}








