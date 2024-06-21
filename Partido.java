import java.util.Random;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String resultado;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public void jugarPartido() {
        Random random = new Random();
        int puntuacionLocal = random.nextInt(6);
        int puntuacionVisitante = random.nextInt(6);

        if (puntuacionLocal > puntuacionVisitante) {
            resultado = "Gana " + equipoLocal.getNombre();
        } else if (puntuacionLocal < puntuacionVisitante) {
            resultado = "Gana " + equipoVisitante.getNombre();
        } else {
            resultado = "Empate";
        }
    }

    public String mostrarResultado() {
        if (resultado != null) {
            return "Resultado: " + resultado + ", Equipo Local: " + equipoLocal.getNombre() + ", Equipo Visitante: " + equipoVisitante.getNombre();
        } else {
            return "El partido aún no se ha jugado";
        }
    }
}
