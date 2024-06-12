package produtorconsumidor;

public class ProdutorMonitor extends Thread {
    private final BufferMonitor buffer;

    public ProdutorMonitor(BufferMonitor buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int item = 0;
            while (true) {
                buffer.produzir(item);
                System.out.println("Produziu " + item);
                item++;
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
