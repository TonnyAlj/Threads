package produtorconsumidor;

public class ProdutorConsumidorMonitor {
    public static void main(String[] args) {
        BufferMonitor buffer = new BufferMonitor(10);

        ProdutorMonitor produtor = new ProdutorMonitor(buffer);
        ConsumidorMonitor consumidor = new ConsumidorMonitor(buffer);

        produtor.start();
        consumidor.start();
    }
}

