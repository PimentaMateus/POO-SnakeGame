import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
public class Main {

    public static void main(String[] args){
//        Menu menuPrincipal = new Menu("Configurações", true);
        //fazer um if para caso o botao seja seleionado abrir a prox tela


        JFrame frame = new JFrame("Snaker");
        JMenuBar menubar = new JMenuBar();
        JMenu menuPrincipal = new JMenu("Principal");

        JMenuItem configuracoes = new JMenuItem("Configurações");

        configuracoes.addActionListener(e -> {
            new Menu("Configurações", true);
        });

        menuPrincipal.add(configuracoes);

        menubar.add(menuPrincipal);
        frame.setJMenuBar(menubar);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBackground(Color.BLUE);//Não funciona: Rever
        frame.setLayout(null);
        Panel gameDrawingAread = new Panel();
        gameDrawingAread.setPreferredSize(new Dimension(800, 600));
        frame.setContentPane(gameDrawingAread);
        Character character = new Character();
//        character.setPreferredSize(new Dimension(800,600));

        gameDrawingAread.add(character);
//        frame.getContentPane().add(comp);

        frame.pack();
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Apertou " + e.getKeyCode());
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Soltou " + e.getKeyCode());
                super.keyReleased(e);
            }
        });

    }

}








