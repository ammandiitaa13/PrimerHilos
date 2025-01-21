package programacionhilos;

public class creacionHilos {
    public static void main(String[] args) {
        Thread hilo1 = new HiloThread();         // Heredando de Thread
        
        // Implementando Runnable
        Runnable hiloRunnable = new HiloRunnable();
        Thread hilo2 = new Thread(hiloRunnable);
        
        // Usando Runnable con Lambda
        Thread hiloLambda = new Thread(() -> {
            Thread current = Thread.currentThread();
            System.out.println("HiloLambda ejecutándose: " + current.getName());
            System.out.println("Estado: " + current.getState());
            System.out.println("Prioridad: " + current.getPriority());
            System.out.println("ID: " + current.getId());
        });

        // Arrancando los hilos
        hilo1.start();
        hilo2.start();
        hiloLambda.start();
    }
}

// Heredando de Thread
class HiloThread extends Thread {
    @Override
    public void run() {
        System.out.println("HiloThread ejecutándose: " + getName());
        System.out.println("Estado: " + getState());
        System.out.println("Prioridad: " + getPriority());
        System.out.println("ID: " + getId());
    }
}

// Implementando Runnable
class HiloRunnable implements Runnable {
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        System.out.println("HiloRunnable ejecutándose: " + current.getName());
        System.out.println("Estado: " + current.getState());
        System.out.println("Prioridad: " + current.getPriority());
        System.out.println("ID: " + current.getId());
    }
}

