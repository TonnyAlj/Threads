package barbearia;

public class Cliente extends Thread {
    private final Barbearia barbearia;

    public Cliente(Barbearia barbearia) {
        this.barbearia = barbearia;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 15000)); // Tempo aleatório para chegar na barbearia
            barbearia.clienteChega();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
