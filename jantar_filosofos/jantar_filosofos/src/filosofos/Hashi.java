package filosofos;

public class Hashi {
    private boolean emUso;

    public synchronized void pegar() throws InterruptedException {
        while (emUso) {
            wait();
        }
        emUso = true;
    }

    public synchronized void largar() {
        emUso = false;
        notifyAll();
    }
}
