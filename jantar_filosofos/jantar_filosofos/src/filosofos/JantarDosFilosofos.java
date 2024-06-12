package filosofos;

public class JantarDosFilosofos {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Filosofo[] filosofos = new Filosofo[numFilosofos];
        Hashi[] hashis = new Hashi[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            hashis[i] = new Hashi();
        }

        for (int i = 0; i < numFilosofos; i++) {
            Hashi hashiEsquerda = hashis[i];
            Hashi hashiDireita = hashis[(i + 1) % numFilosofos];
            filosofos[i] = new Filosofo(i, hashiEsquerda, hashiDireita);
            filosofos[i].start();
        }
    }
}

