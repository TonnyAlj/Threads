package contabancaria;

public class Saque extends Thread {
    private final ContaBancaria conta;
    private final int valor;

    public Saque(ContaBancaria conta, int valor) {
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public void run() {
        conta.sacar(valor);
    }
}
