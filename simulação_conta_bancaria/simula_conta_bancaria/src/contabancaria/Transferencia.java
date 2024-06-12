package contabancaria;

public class Transferencia extends Thread {
    private final ContaBancaria contaOrigem;
    private final ContaBancaria contaDestino;
    private final int valor;

    public Transferencia(ContaBancaria contaOrigem, ContaBancaria contaDestino, int valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    @Override
    public void run() {
        contaOrigem.transferir(contaDestino, valor);
    }
}
