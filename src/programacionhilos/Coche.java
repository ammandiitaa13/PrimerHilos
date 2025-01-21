package programacionhilos;

public class Coche {
    private String marca;
    private int cilindrada, año;

    public Coche(String marca, int cilindrada, int año) {
        this.marca = marca;
        this.cilindrada = cilindrada;
        this.año = año;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", \nCilindrada: " + cilindrada + ", \nAño: " + año;
    }
}

