package barbearia;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barbearia {
    private final int numCadeiras;
    private int clientesEsperando;
    private boolean barbeiroDormindo;

    private final Lock lock;
    private final Condition barbeiroAcordado;
    private final Condition clienteAtendido;

    public Barbearia(int numCadeiras) {
        this.numCadeiras = numCadeiras;
        this.clientesEsperando = 0;
        this.barbeiroDormindo = true;

        this.lock = new ReentrantLock();
        this.barbeiroAcordado = lock.newCondition();
        this.clienteAtendido = lock.newCondition();
    }

    public void clienteChega() throws InterruptedException {
        lock.lock();
        try {
            if (clientesEsperando == numCadeiras) {
                System.out.println("Não há cadeiras disponíveis. Cliente indo embora.");
                return;
            }
            clientesEsperando++;
            System.out.println("Cliente chegou na barbearia. Clientes esperando: " + clientesEsperando);
            if (barbeiroDormindo) {
                barbeiroDormindo = false;
                barbeiroAcordado.signal();
                System.out.println("Cliente acordou o barbeiro.");
            }
            clienteAtendido.await();
        } finally {
            lock.unlock();
        }
    }

    public void cortarCabelo() throws InterruptedException {
        lock.lock();
        try {
            while (clientesEsperando == 0) {
                System.out.println("Barbeiro dormindo...");
                barbeiroDormindo = true;
                barbeiroAcordado.await();
            }
            System.out.println("Barbeiro cortando o cabelo de um cliente.");
            clientesEsperando--;
            Thread.sleep(2000); // Simula o tempo para cortar o cabelo
            System.out.println("Barbeiro terminou de cortar o cabelo de um cliente.");
            clienteAtendido.signal();
        } finally {
            lock.unlock();
        }
    }
}
