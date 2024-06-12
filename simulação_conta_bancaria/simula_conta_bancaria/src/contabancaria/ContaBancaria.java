package contabancaria;

public class ContaBancaria {
    private int saldo;

    public ContaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(int valor) {
        saldo += valor;
        System.out.println("Depositado: " + valor + " | Saldo: " + saldo);
    }

    public synchronized void sacar(int valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Sacado: " + valor + " | Saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque de " + valor);
        }
    }

    public synchronized void transferir(ContaBancaria contaDestino, int valor) {
        if (saldo >= valor) {
            saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferido: " + valor + " para " + contaDestino + " | Saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para transferir " + valor);
        }
    }

    public synchronized void creditarJuros(double taxa) {
        int juros = (int) (saldo * taxa);
        saldo += juros;
        System.out.println("Juros creditados: " + juros + " | Saldo: " + saldo);
    }
}
