package roletas;

public class Roleta {
    private boolean emUso;

    public synchronized void usar() throws InterruptedException {
        while (emUso) {
            wait();
        }
        emUso = true;
    }

    public synchronized void liberar() {
        emUso = false;
        notifyAll();
    }
}
