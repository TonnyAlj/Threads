package bar;

public class Bar {
    public static void main(String[] args) {
        int numClientes = 10;
        int numGarcons = 2;
        int capacidadeGarcom = 3;
        int rodadas = 5;

        Bartender bartender = new Bartender();
        Garcom[] garcons = new Garcom[numGarcons];
        Cliente[] clientes = new Cliente[numClientes];

        // Inicializa garçons
        for (int i = 0; i < numGarcons; i++) {
            garcons[i] = new Garcom(i, bartender, capacidadeGarcom);
            garcons[i].start();
        }

        // Inicializa clientes
        for (int i = 0; i < numClientes; i++) {
            clientes[i] = new Cliente(i, garcons[i % numGarcons], rodadas);
            clientes[i].start();
        }

        // Aguarda clientes terminarem
        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Para os garçons
        for (Garcom garcom : garcons) {
            garcom.parar();
        }
    }
}
