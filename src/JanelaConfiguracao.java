import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.BOTH;

public class JanelaConfiguracao extends JPanel{
    private JTextField campoAltura;
    private JTextField campoLargura;
    private JComboBox<Dificuldade> comboDificuldade;
    private JTextField maxPontos;

    public JanelaConfiguracao(String titulo, boolean estado){
        JFrame frame = new JFrame(titulo);
        JPanel painel = new JPanel();
        montarFormConfiguracao(painel);
        preencheValoresSalvos();

        frame.add(painel);
        frame.pack();
        frame.setVisible(estado);
    }

    public void preencheValoresSalvos() {
        maxPontos.setText(String.valueOf(Configuracao.instance().pontucaoMaxima));
        campoAltura.setText(String.valueOf(Configuracao.instance().tamanho.height));
        campoLargura.setText(String.valueOf(Configuracao.instance().tamanho.width));
        comboDificuldade.getModel().setSelectedItem(Configuracao.instance().dificuldade);
    }

    private void montarFormConfiguracao(JPanel painel) {
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        maxPontos = campoPontuacao(painel, c);

        rotuloTerritorio(painel, c);

        campoAltura = campoAltura(painel, c);

        campoLargura = campoComprimento(painel, c);

        comboDificuldade = campoDificuldade(painel, c);

        botoes(painel, c);
    }

    private void botoes(JPanel painel, GridBagConstraints c) {
        JButton botaoSalvar = new JButton("Salvar");
        c.gridx = 3;
        c.gridy = 4;
        c.fill = BOTH;
        painel.add(botaoSalvar, c);
        botaoSalvar.addActionListener( l -> {
            Configuracao.instance().tamanho = new Dimension(Integer.parseInt(campoLargura.getText().trim()), Integer.parseInt(campoAltura.getText().trim()));
            Configuracao.instance().pontucaoMaxima = Integer.parseInt(maxPontos.getText().trim());
            Configuracao.instance().dificuldade = (Dificuldade) comboDificuldade.getSelectedItem();
            Configuracao.salvar();
        });
    }

    private void rotuloTerritorio(JPanel painel, GridBagConstraints c) {
        JLabel rotuloTerritorio = new JLabel("Tamanho do Territorio:");
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 4;
        painel.add(rotuloTerritorio, c);
    }

    private JComboBox<Dificuldade> campoDificuldade(JPanel painel, GridBagConstraints c) {
        JLabel rotuloDificuldade = new JLabel("Nivel de Dificuldade:");
        Insets insets = new Insets(3, 3, 3, 3);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = insets;
        painel.add(rotuloDificuldade, c);

        JComboBox<Dificuldade> comboDificuldade = new JComboBox<>();
        comboDificuldade.addItem(Dificuldade.FACIL);
        comboDificuldade.addItem(Dificuldade.MEDIO);
        comboDificuldade.addItem(Dificuldade.DIFICIL);
        c.gridx = 1;
        c.gridy = 3;
        c.ipadx = 3;
        c.fill = BOTH;
        c.insets = insets;
        painel.add(comboDificuldade, c);

        return comboDificuldade;
    }

    private JTextField campoComprimento(JPanel painel, GridBagConstraints c) {
        JLabel rotuloComprimento = new JLabel("Comprimento:");
        c.gridx = 2;
        c.gridy = 2;
        painel.add(rotuloComprimento, c);

        JTextField campoComprimento = new JTextField(20);
        c.gridx = 3;
        c.gridy = 2;
        c.fill = BOTH;
        painel.add(campoComprimento, c);
        return campoComprimento;
    }

    private JTextField campoAltura(JPanel painel, GridBagConstraints c) {
        JLabel rotuloAltura = new JLabel("Altura:");
        c.gridx = 0;
        c.gridy = 2;
        painel.add(rotuloAltura, c);

        JTextField campoAltura = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        painel.add(campoAltura, c);
        return campoAltura;
    }

    private JTextField campoPontuacao(JPanel painel, GridBagConstraints c) {
        JLabel rotuloPontos = new JLabel("Pontuação máxima");
        c.gridx = 0;
        c.gridy = 0;
        painel.add(rotuloPontos, c);

        JTextField maxPontos = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        c.fill = BOTH;
        painel.add(maxPontos, c);

        maxPontos.setText(Integer.toString(Configuracao.instance().pontucaoMaxima));
        return maxPontos;
    }
}
