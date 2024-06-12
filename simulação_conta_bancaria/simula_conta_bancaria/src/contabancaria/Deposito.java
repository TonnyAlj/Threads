package contabancaria;

public class Deposito extends Thread {
    private final ContaBancaria conta;
    private final int valor;

    public Deposito(ContaBancaria conta, int valor) {
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public void run() {
        conta.depositar(valor);
    }
}
