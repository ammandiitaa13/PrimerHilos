package programacionhilos;
import java.util.*;

public class gestionCochesSinHilos {
    public static void main(String[] args) {
        List<Coche> coches = crearCoches();
        long inicio = System.currentTimeMillis();       // Tiempo de inicio de ejecución 
        long fin;      // Tiempo de finalización de la ejecución
        for (Coche coche : coches) {
            procesarCoche(coche);       // Procesar cada coche individualmente
        }
        fin = System.currentTimeMillis();
        System.out.println("Tiempo total (sin hilos): " + (fin - inicio) + " ms");      // Tiempo total de ejecución 
    }

    //Crear lista de coches
    private static List<Coche> crearCoches() {
        List<Coche> coches = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            coches.add(new Coche("Marca" + i, 1000 + i, 2000 + i));
        }
        return coches;
    }

    // Procesamiento de un coche 
    private static void procesarCoche(Coche coche) {
        try {
            System.out.println("Procesando coche: " + coche);
            Thread.sleep(2000);     // Retraso de 2 s para el procesamiento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

