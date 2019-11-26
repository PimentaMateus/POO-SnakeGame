import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Configuracao implements Serializable {

    private static final long serialVersionUID = 42L;

    private static final String NOME_ARQUIVO_CONFIGURACAO = "configuracao.obj";
    private static Configuracao instance = null;

    public Dimension tamanho = new Dimension(800,600);
    public Dificuldade dificuldade = Dificuldade.MEDIO;
    public int pontucaoMaxima = 10;

    private Configuracao () {

    }

    public static Configuracao instance() {
        if (instance == null) {
            carregarConfig();

            if (instance == null)
                instance = new Configuracao();
        }

        return instance;
    }

    public static void salvar() {
        try (ObjectOutputStream ios = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO_CONFIGURACAO))) {
            ios.writeObject(instance);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de configuração não existe, será criado um novo ao salvar");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Não foi possível ler arquivo: " + e.getLocalizedMessage(),
                    "Erro ao ler arquivo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void carregarConfig() {
        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO_CONFIGURACAO))) {
            instance = (Configuracao) ios.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de configuração não existe, será criado um novo ao salvar");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Não foi possível ler arquivo: " + e.getLocalizedMessage(),
                    "Erro ao ler arquivo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
