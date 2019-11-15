import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Menu extends JPanel{
    private static int posLabel = 150;
    private  static  int tamLabel = 80;
    private JFrame frame;


    public Menu(String titulo, boolean estado){
        frame = new JFrame(titulo);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLUE);//Não funciona: Rever
        JPanel painel = new JPanel();
        frame.add(painel);
        inserirDados(painel);
        frame.setVisible(estado);

    }
    public void inserirDados(JPanel painel) {
        painel.setLayout(null);
        // rótulos e campos
        JLabel rotuloPontos = new JLabel("Pontuação máxima");
        rotuloPontos.setBounds(10, 10, 300, 25);
        painel.add(rotuloPontos);

        JTextField maxPontos = new JTextField(20);
        maxPontos.setBounds(posLabel, 10, tamLabel, 25);
        painel.add(maxPontos);

        JLabel rotuloTerritorio = new JLabel("Tamanho do Territorio:");
        rotuloTerritorio.setBounds(10, 40, 300, 25);
        painel.add(rotuloTerritorio);

        JLabel rotuloAltura = new JLabel("Altura:");
        rotuloAltura.setBounds(100, 70, 80, 25);
        painel.add(rotuloAltura);

        JTextField campoAltura = new JTextField(20);
        campoAltura.setBounds(posLabel, 70, tamLabel, 25);
        painel.add(campoAltura);

        JLabel rotuloComprimento = new JLabel("Comprimento:");
        rotuloComprimento.setBounds(240, 70, 100, 25);
        painel.add(rotuloComprimento);

        JTextField campoComprimento = new JTextField(20);
        campoComprimento.setBounds(posLabel + 180, 70, tamLabel, 25);
        painel.add(campoComprimento);

        JLabel rotuloDificuldade = new JLabel("Nivel de Dificuldade 1-3");
        rotuloDificuldade.setBounds(10, 100, 300, 25);
        painel.add(rotuloDificuldade);

        JTextField campoDificuldade = new JTextField(20);
        campoDificuldade.setBounds(posLabel, 100, tamLabel, 25);
        painel.add(campoDificuldade);

        JButton botaoIr = new JButton("Começar");
        botaoIr.setBounds(10, 130, 120, 25);
        painel.add(botaoIr);

        ActionListener leitor_botoes = new BotaoMenu();
        botaoIr.addActionListener(leitor_botoes);

        }
}
