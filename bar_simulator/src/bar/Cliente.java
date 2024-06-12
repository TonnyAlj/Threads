package bar;

import java.util.Random;

public class Cliente extends Thread {
    private final int id;
    private final Garcom garcom;
    private final int rodadas;

    public Cliente(int id, Garcom garcom, int rodadas) {
        this.id = id;
        this.garcom = garcom;
        this.rodadas = rodadas;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < rodadas; i++) {
            try {
                Thread.sleep(random.nextInt(3000)); // Tempo até fazer o pedido
                System.out.println("Cliente " + id + " está fazendo um pedido na rodada " + (i + 1));
                garcom.receberPedido(this); // Cliente faz pedido ao garçom
                Thread.sleep(random.nextInt(5000)); // Tempo de consumo do pedido
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getIdCliente() {
        return id;
    }
}
