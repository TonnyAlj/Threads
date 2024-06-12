package produtorconsumidor;

public class ProdutorConsumidorSemaforo {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);

        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        produtor.start();
        consumidor.start();
    }
}
