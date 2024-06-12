package bar;

import java.util.Queue;

public class Bartender {
    public synchronized void receberPedidos(Garcom garcom, Queue<Cliente> pedidos) throws InterruptedException {
        System.out.println("Bartender está preparando os pedidos do Garçom " + garcom.getGarcomId());
        Thread.sleep(3000);  // Simulando tempo para preparar os pedidos
        for (Cliente cliente : pedidos) {
            System.out.println("Pedido do Cliente " + cliente.getIdCliente() + " está pronto.");
        }
        System.out.println("Garçom " + garcom.getGarcomId() + " pegou os pedidos e está indo entregar.");
    }
}
