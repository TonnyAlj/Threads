package contabancaria;

public class CreditoJuros extends Thread {
    private final ContaBancaria conta;
    private final double taxa;

    public CreditoJuros(ContaBancaria conta, double taxa) {
        this.conta = conta;
        this.taxa = taxa;
    }

    @Override
    public void run() {
        conta.creditarJuros(taxa);
    }
}
