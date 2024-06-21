import java.util.List;

public class Grupo {
    private String nombre;
    private List<Equipo> equipos;

    public Grupo(String nombre, List<Equipo> equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public String mostrarInfo() {
        StringBuilder infoEquipos = new StringBuilder();
        for (Equipo equipo : equipos) {
            infoEquipos.append(equipo.mostrarInfo()).append(", ");
        }
        return "Grupo: " + nombre + ", Equipos: " + infoEquipos.toString();
    }
}


