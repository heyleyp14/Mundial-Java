public class Jugador {
    private String nombre;
    private int edad;
    private String posicion;

    public Jugador(String nombre, int edad, String posicion) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
    }

    public String mostrarInfo() {
        return "Jugador: " + nombre + ", Edad: " + edad + ", Posición: " + posicion;
    }
}

