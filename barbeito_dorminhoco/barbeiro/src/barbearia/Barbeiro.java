package barbearia;

public class Barbeiro extends Thread {
    private final Barbearia barbearia;

    public Barbeiro(Barbearia barbearia) {
        this.barbearia = barbearia;
    }

    @Override
    public void run() {
        try {
            while (true) {
                barbearia.cortarCabelo();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
