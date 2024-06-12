package contabancaria;

public class Banco {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria(1000);
        ContaBancaria conta2 = new ContaBancaria(500);

        Thread t1 = new Deposito(conta1, 200);
        Thread t2 = new Saque(conta1, 100);
        Thread t3 = new Transferencia(conta1, conta2, 300);
        Thread t4 = new CreditoJuros(conta1, 0.05);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
