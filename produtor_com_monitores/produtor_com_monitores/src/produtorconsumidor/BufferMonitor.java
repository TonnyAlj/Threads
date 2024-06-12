package produtorconsumidor;

public class BufferMonitor {
    private final int[] buffer;
    private int count, in, out;

    public BufferMonitor(int size) {
        buffer = new int[size];
    }

    public synchronized void produzir(int item) throws InterruptedException {
        while (count == buffer.length) {
            wait();
        }
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized int consumir() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        int item = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        notifyAll();
        return item;
    }
}
