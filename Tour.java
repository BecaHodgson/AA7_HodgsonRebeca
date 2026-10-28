
import java.util.ArrayList;

public abstract class Tour {

    private static final String PREFIJO_CODIGO = "TOUR-";
    public static final double DESCUENTO_NACIONAL = 0.20;

    private static int cantidadTours = 0;

    private String codigo;
    private String nombre;
    protected double precioBase;
    private int cupoMaximo;
    private Guia guia;
    protected ArrayList<Atractivo> atractivos;
    private ArrayList<Reserva> reservas;
    private int siguienteNumeroReserva;

    public Tour(String pNombre, double pPrecioBase,
                int pCupoMaximo, Guia pGuia) {
        cantidadTours++;
        codigo = PREFIJO_CODIGO + cantidadTours;
        nombre = pNombre;
        precioBase = pPrecioBase;
        cupoMaximo = pCupoMaximo;
        guia = pGuia;
        atractivos = new ArrayList<>();
        reservas = new ArrayList<>();
        siguienteNumeroReserva = 1;
    }

    public abstract double calcularPrecioPorPersona();

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public static int getCantidadTours() {
        return cantidadTours;
    }

    public void cambiarGuia(Guia pGuia) {
        guia = pGuia;
    }

    public String consultarNombreGuia() {
        return guia.getNombreCompleto();
    }

    public void agregarAtractivo(Atractivo pAtractivo) {
        if (!atractivos.contains(pAtractivo)) {
            atractivos.add(pAtractivo);
        }
    }

    public String consultarNombresAtractivos() {
        String nombres = "";

        for (int i = 0; i < atractivos.size(); i++) {
            if (i > 0) {
                nombres += ", ";
            }
            nombres += atractivos.get(i).getNombre();
        }

        return nombres;
    }

    public int calcularCuposDisponibles() {
        int personasReservadas = 0;

        for (Reserva reserva : reservas) {
            personasReservadas += reserva.getCantidadPersonas();
        }

        return cupoMaximo - personasReservadas;
    }

    public void registrarReserva(Cliente pCliente) {
        registrarReserva(pCliente, 1);
    }

    public void registrarReserva(Cliente pCliente, int pCantidadPersonas) {
        if (pCantidadPersonas > 0 &&
            pCantidadPersonas <= calcularCuposDisponibles()) {

            double monto = calcularPrecioPorPersona() * pCantidadPersonas;

            if (pCliente.getCondicion().equalsIgnoreCase("nacional")) {
                monto = monto * (1 - DESCUENTO_NACIONAL);
            }

            Reserva reserva = new Reserva(
                siguienteNumeroReserva,
                pCliente.getNombre(),
                pCantidadPersonas,
                monto
            );

            reservas.add(reserva);
            siguienteNumeroReserva++;
        }
    }

    public final double calcularIngresoTotal() {
        double total = 0.0;

        for (Reserva reserva : reservas) {
            total += reserva.getMonto();
        }

        return total;
    }

    public String toString() {
        String estado = "Código: " + codigo + "\n" +
                        "Nombre: " + nombre + "\n" +
                        "Guía: " + consultarNombreGuia() + "\n" +
                        "Precio base: " + precioBase + "\n" +
                        "Precio por persona: " + calcularPrecioPorPersona() + "\n" +
                        "Cupo máximo: " + cupoMaximo + "\n" +
                        "Cupos disponibles: " + calcularCuposDisponibles() + "\n" +
                        "Atractivos: " + consultarNombresAtractivos() + "\n";

        estado += "Reservas (" + reservas.size() + "):\n";

        for (Reserva reserva : reservas) {
            estado += reserva + "\n";
        }

        estado += "Ingreso total: " + calcularIngresoTotal() + "\n";

        return estado;
    }
}
