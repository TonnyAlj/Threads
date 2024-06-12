package filosofos;

public class Filosofo extends Thread {
    private final int id;
    private final Hashi hashiEsquerda;
    private final Hashi hashiDireita;

    public Filosofo(int id, Hashi hashiEsquerda, Hashi hashiDireita) {
        this.id = id;
        this.hashiEsquerda = hashiEsquerda;
        this.hashiDireita = hashiDireita;
    }

    private void meditar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está meditando.");
        Thread.sleep((long) (Math.random() * 10000));
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está com fome.");
        hashiEsquerda.pegar();
        System.out.println("Filósofo " + id + " pegou o hashi esquerdo.");
        hashiDireita.pegar();
        System.out.println("Filósofo " + id + " pegou o hashi direito.");
        System.out.println("Filósofo " + id + " está comendo.");
        Thread.sleep((long) (Math.random() * 10000));
        hashiEsquerda.largar();
        System.out.println("Filósofo " + id + " largou o hashi esquerdo.");
        hashiDireita.largar();
        System.out.println("Filósofo " + id + " largou o hashi direito.");
    }

    @Override
    public void run() {
        try {
            while (true) {
                meditar();
                comer();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

