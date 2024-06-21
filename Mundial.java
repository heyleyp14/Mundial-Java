import java.util.ArrayList;
import java.util.List;

public class Mundial {
    private List<Grupo> grupos;
    private List<Estadio> estadios;

    public Mundial() {
        this.grupos = new ArrayList<>();
        this.estadios = new ArrayList<>();
    }

    public void registrarGrupo(Grupo grupo) {
        grupos.add(grupo);
    }

    public void registrarEstadio(Estadio estadio) {
        estadios.add(estadio);
    }

    public String generarFixture() {
        StringBuilder info = new StringBuilder();
        for (Grupo grupo : grupos) {
            List<Equipo> equiposGrupo = grupo.getEquipos();
            for (int i = 0; i < equiposGrupo.size(); i++) {
                for (int j = i + 1; j < equiposGrupo.size(); j++) {
                    Partido partido = new Partido(equiposGrupo.get(i), equiposGrupo.get(j));
                    partido.jugarPartido();
                    info.append(partido.mostrarResultado()).append("\n");
                }
            }
        }
        return info.toString();
    }
}
