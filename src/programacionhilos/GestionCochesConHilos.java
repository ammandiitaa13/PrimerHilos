package programacionhilos;
import java.util.*;
import java.util.concurrent.*;

public class GestionCochesConHilos {
    public static void main(String[] args) {
        List<Coche> coches = crearCoches();
        long inicio = System.currentTimeMillis();   // Tiempo de inicio de ejecución 
        long fin;  // Tiempo de finalización de ejecución
        int numHilos = Runtime.getRuntime().availableProcessors();  // Nº de núcleos de CPU para el tamaño del pool
        System.out.println("Numero de hilos: " + numHilos);
        ExecutorService executorService = Executors.newFixedThreadPool(numHilos);   // Pool de hilos con el nº anterior obtenido
        for (Coche coche : coches) {
            executorService.execute(() -> procesarCoche(coche));    // Para procesar cada coche en un hilo del pool
        }
        // shutdown para no aceptar más tareas y esperar a que terminen las actuales
        executorService.shutdown();
        while (!executorService.isTerminated()) { // Espera hasta que todos los hilos hayan terminado
        }
        fin = System.currentTimeMillis();
        System.out.println("Tiempo total (con hilos): " + (fin - inicio) + " ms");   // Tiempo total de ejecución
    }

    // Crear lista de coches 
    private static List<Coche> crearCoches() {
        List<Coche> coches = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            coches.add(new Coche("Marca" + i, 1000 + i, 2000 + i));
        }
        return coches;
    }

    // Procesamiento de un coche y sincronización 
    private static void procesarCoche(Coche coche) {
        synchronized (coche) { // Sincroniza los objetos creados
            try {
                System.out.println("Procesando coche: " + coche);   // Coche en procesamiento
                Thread.sleep(2000);     // Retraso de 2 s para representar el procesamiento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
