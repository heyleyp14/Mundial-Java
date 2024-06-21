import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MundialGUI {
    private JFrame frame;
    private Mundial mundial;

    public MundialGUI() {
        mundial = new Mundial();
        frame = new JFrame("Mundial de Fútbol");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.getContentPane().setBackground(new Color(197, 202, 233));
        centerWindow(frame, 400, 450);
        
        JLabel label = new JLabel("Bienvenido al Mundial de Fútbol");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon("imagen.png");
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel labelImagen = new JLabel(new ImageIcon(image));
        frame.add(labelImagen, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(197, 202, 233));
        panelBotones.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnRegistrarGrupo = new JButton("Registrar Grupo");
        btnRegistrarGrupo.addActionListener(e -> abrirVentanaRegistrarGrupo());
        panelBotones.add(btnRegistrarGrupo);

        JButton btnRegistrarEstadio = new JButton("Registrar Estadio");
        btnRegistrarEstadio.addActionListener(e -> abrirVentanaRegistrarEstadio());
        panelBotones.add(btnRegistrarEstadio);

        JButton btnGenerarFixture = new JButton("Generar Fixture");
        btnGenerarFixture.addActionListener(e -> generarFixture());
        panelBotones.add(btnGenerarFixture);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> salir());
        panelBotones.add(btnSalir);

        frame.add(panelBotones, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void centerWindow(Window frame, int width, int height) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - width) / 2);
        int y = (int) ((dimension.getHeight() - height) / 2);
        frame.setLocation(x, y);
    }

    private void abrirVentanaRegistrarGrupo() {
        JFrame ventanaRegistrarGrupo = new JFrame("Registrar Grupo");
        ventanaRegistrarGrupo.setSize(400, 300);
        ventanaRegistrarGrupo.getContentPane().setBackground(new Color(232, 234, 246));
        centerWindow(ventanaRegistrarGrupo, 400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBackground(new Color(232, 234, 246));

        JLabel labelNombreGrupo = new JLabel("Nombre del Grupo:");
        labelNombreGrupo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelNombreGrupo);

        JTextField nombreGrupo = new JTextField();
        panel.add(nombreGrupo);

        JLabel labelCantidadEquipos = new JLabel("Cantidad de Equipos:");
        labelCantidadEquipos.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelCantidadEquipos);

        JTextField cantidadEquipos = new JTextField();
        panel.add(cantidadEquipos);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> {
            registrarGrupo(nombreGrupo.getText(), cantidadEquipos.getText());
            ventanaRegistrarGrupo.dispose();
        });
        panel.add(btnRegistrar);

        ventanaRegistrarGrupo.add(panel);
        ventanaRegistrarGrupo.setVisible(true);
    }

    private void abrirVentanaRegistrarEstadio() {
        JFrame ventanaRegistrarEstadio = new JFrame("Registrar Estadio");
        ventanaRegistrarEstadio.setSize(400, 300);
        ventanaRegistrarEstadio.getContentPane().setBackground(new Color(232, 234, 246));
        centerWindow(ventanaRegistrarEstadio, 400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));
        panel.setBackground(new Color(232, 234, 246));

        JLabel labelNombreEstadio = new JLabel("Nombre del Estadio:");
        labelNombreEstadio.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelNombreEstadio);

        JTextField nombreEstadio = new JTextField();
        panel.add(nombreEstadio);

        JLabel labelCiudadEstadio = new JLabel("Ciudad del Estadio:");
        labelCiudadEstadio.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelCiudadEstadio);

        JTextField ciudadEstadio = new JTextField();
        panel.add(ciudadEstadio);

        JLabel labelCapacidadEstadio = new JLabel("Capacidad del Estadio:");
        labelCapacidadEstadio.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelCapacidadEstadio);

        JTextField capacidadEstadio = new JTextField();
        panel.add(capacidadEstadio);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> {
            registrarEstadio(nombreEstadio.getText(), ciudadEstadio.getText(), capacidadEstadio.getText());
            ventanaRegistrarEstadio.dispose();
        });
        panel.add(btnRegistrar);

        ventanaRegistrarEstadio.add(panel);
        ventanaRegistrarEstadio.setVisible(true);
    }

    private void registrarGrupo(String nombreGrupo, String cantidadEquipos) {
        try {
            int cantidad = Integer.parseInt(cantidadEquipos);
            List<Equipo> equipos = new ArrayList<>();
            for (int i = 0; i < cantidad; i++) {
                String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo " + (i + 1) + ":");
                String entrenador = JOptionPane.showInputDialog("Ingrese el nombre del entrenador del equipo " + (i + 1) + ":");
                int cantidadJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores en el equipo " + (i + 1) + ":"));
                List<Jugador> jugadores = new ArrayList<>();
                for (int j = 0; j < cantidadJugadores; j++) {
                    String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador " + (j + 1) + ":");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del jugador " + (j + 1) + ":"));
                    String posicion = JOptionPane.showInputDialog("Ingrese la posición del jugador " + (j + 1) + ":");
                    jugadores.add(new Jugador(nombreJugador, edad, posicion));
                }
                equipos.add(new Equipo(nombreEquipo, entrenador, jugadores));
            }
            Grupo grupo = new Grupo(nombreGrupo, equipos);
            mundial.registrarGrupo(grupo);
            mostrarInfo("Registro", "Grupo registrado con éxito."); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad de equipos debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarEstadio(String nombreEstadio, String ciudadEstadio, String capacidadEstadio) {
        try {
            int capacidad = Integer.parseInt(capacidadEstadio);
            Estadio estadio = new Estadio(nombreEstadio, ciudadEstadio, capacidad);
            mundial.registrarEstadio(estadio);
            mostrarInfo("Registro", "Estadio registrado con éxito.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La capacidad del estadio debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generarFixture() {
        String info = mundial.generarFixture();
        mostrarInfo("Fixture", info);
    }

    private void mostrarInfo(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void salir() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new MundialGUI();
    }
}

