import java.awt.*;
import java.util.Random;

public class Frutinha extends EntidadeJogo {
    final int tam = 20;
    private boolean estragada = false;

    private int contagemTicks = 0;
    private final int x;
    private final int y;

    public Frutinha() {
        x = new Random().nextInt(Configuracao.instance().tamanho.width / tam) * tam;
        y = new Random().nextInt(Configuracao.instance().tamanho.height / tam) * tam;

        int dir = new Random().nextInt(Movimentacao.values().length);
        m = Movimentacao.values()[dir];
    }

    enum Movimentacao {
        HORIZONTAL,
        VERTICAL,
        DIAGONAL
    }

    Movimentacao m;

    @Override
    public void desenhar(Graphics g) {
        contagemTicks++;

        estragada = calculaEstragada();

        g.setColor(estragada ? Color.RED : Color.GREEN);


        g.fillOval(x,y, tam, tam);
    }

    private boolean calculaEstragada() {
        switch (Configuracao.instance().dificuldade) {
            case FACIL:
                return contagemTicks >= 20;
            case MEDIO:
                return contagemTicks >= 10;
            case DIFICIL:
                return contagemTicks >= 5;

        }
        return false;
    }

    private void mover() {

    }


}
