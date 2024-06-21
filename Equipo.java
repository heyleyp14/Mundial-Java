
import java.util.List;

public class Equipo {
    private String nombre;
    private String entrenador;
    private List<Jugador> jugadores;

    public Equipo(String nombre, String entrenador, List<Jugador> jugadores) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public String getNombre() {
        return nombre;
    }

    public String mostrarInfo() {
        StringBuilder infoJugadores = new StringBuilder();
        for (Jugador jugador : jugadores) {
            infoJugadores.append(jugador.mostrarInfo()).append(", ");
        }
        return "Equipo: " + nombre + ", Entrenador: " + entrenador + ", Jugadores: " + infoJugadores.toString();
    }
}

