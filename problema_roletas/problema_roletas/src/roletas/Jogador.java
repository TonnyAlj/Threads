package roletas;

public class Jogador extends Thread {
    private final int id;
    private final Roleta[] roletas;

    public Jogador(int id, Roleta[] roletas) {
        this.id = id;
        this.roletas = roletas;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (Roleta roleta : roletas) {
                    roleta.usar();
                    System.out.println("Jogador " + id + " está usando a roleta.");
                    Thread.sleep((long) (Math.random() * 1000));
                    roleta.liberar();
                    System.out.println("Jogador " + id + " liberou a roleta.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

