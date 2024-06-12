package roletas;

public class JogoDasRoletas {
    public static void main(String[] args) {
        int numRoletas = 5;
        int numJogadores = 10;

        Roleta[] roletas = new Roleta[numRoletas];
        for (int i = 0; i < numRoletas; i++) {
            roletas[i] = new Roleta();
        }

        Jogador[] jogadores = new Jogador[numJogadores];
        for (int i = 0; i < numJogadores; i++) {
            jogadores[i] = new Jogador(i, roletas);
            jogadores[i].start();
        }
    }
}

