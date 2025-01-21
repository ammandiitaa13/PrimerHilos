package programacionhilos;

public class GestionHilos {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> ejecutarHilo("Hilo 1"));
        Thread hilo2 = new Thread(() -> ejecutarHilo("Hilo 2"));
        Thread hilo3 = new Thread(() -> ejecutarHilo("Hilo 3"));

        // Iniciar hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            // Esperar a que los hilos terminen
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hilo principal finalizando ");
    }

    private static void ejecutarHilo(String nombre) {
        try {
            System.out.println(nombre + " ejecutándose.");
            Thread.sleep(2000); // Dormir por 2 s
            System.out.println(nombre + " finalizó.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
