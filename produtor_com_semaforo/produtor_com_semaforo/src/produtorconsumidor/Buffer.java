package produtorconsumidor;

import java.util.concurrent.Semaphore;

public class Buffer {
    private final int[] buffer;
    private int in, out, count;
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore items = new Semaphore(0);
    private final Semaphore spaces;

    public Buffer(int size) {
        buffer = new int[size];
        spaces = new Semaphore(size);
        count = 0;
    }

    public void produzir(int item) throws InterruptedException {
        spaces.acquire();
        mutex.acquire();
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        count++;
        mutex.release();
        items.release();
    }

    public int consumir() throws InterruptedException {
        items.acquire();
        mutex.acquire();
        int item = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        mutex.release();
        spaces.release();
        return item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
