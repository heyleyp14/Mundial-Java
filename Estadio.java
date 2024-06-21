public class Estadio {
    private String nombre;
    private String ciudad;
    private int capacidad;

    public Estadio(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }

    public String mostrarInfo() {
        return "Estadio: " + nombre + ", Ciudad: " + ciudad + ", Capacidad: " + capacidad;
    }
}

