package barbearia;

public class BarbeiroDorminhoco {
    public static void main(String[] args) {
        Barbearia barbearia = new Barbearia(5); // Neste exemplo, estamos usando 5 cadeiras na barbearia

        // Iniciar o barbeiro
        Barbeiro barbeiro = new Barbeiro(barbearia);
        barbeiro.start();

        // Iniciar os clientes
        for (int i = 0; i < 10; i++) {
            Cliente cliente = new Cliente(barbearia);
            cliente.start();
            try {
                Thread.sleep((long) (Math.random() * 10000)); // Espera aleatória entre a chegada dos clientes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
