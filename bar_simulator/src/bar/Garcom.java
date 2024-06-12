package bar;

import java.util.LinkedList;
import java.util.Queue;

public class Garcom extends Thread {
    private final int id;
    private final Bartender bartender;
    private final int capacidade;
    private final Queue<Cliente> pedidos;
    private boolean trabalhando;

    public Garcom(int id, Bartender bartender, int capacidade) {
        this.id = id;
        this.bartender = bartender;
        this.capacidade = capacidade;
        this.pedidos = new LinkedList<>();
        this.trabalhando = true;
    }

    public synchronized void receberPedido(Cliente cliente) throws InterruptedException {
        while (pedidos.size() >= capacidade) {
            wait(); // Aguarda se a capacidade máxima já foi alcançada
        }
        pedidos.add(cliente);
        System.out.println("Garçom " + id + " recebeu o pedido do Cliente " + cliente.getIdCliente());
        if (pedidos.size() == capacidade || !trabalhando) {
            notify(); // Notifica que há um novo pedido
        }
    }

    @Override
    public void run() {
        while (trabalhando) {
            synchronized (this) {
                while (pedidos.size() < capacidade) {
                    try {
                        wait(); // Aguarda novos pedidos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                bartender.receberPedidos(this, pedidos); // Garçom leva os pedidos para o bartender
                synchronized (this) {
                    pedidos.clear(); // Limpa a lista de pedidos após entrega
                    notifyAll(); // Notifica que está pronto para receber novos pedidos
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void parar() {
        trabalhando = false;
        synchronized (this) {
            notifyAll(); // Notifica que o garçom está parando
        }
    }

    public int getGarcomId() {
        return id;
    }
}
