package produtorconsumidor;

public class ConsumidorMonitor extends Thread {
    private final BufferMonitor buffer;

    public ConsumidorMonitor(BufferMonitor buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = buffer.consumir();
                System.out.println("Consumiu " + item);
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
