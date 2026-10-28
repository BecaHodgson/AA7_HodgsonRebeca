
public class TourAventura extends Tour {

    private static final double PORCENTAJE_SEGURO = 0.15;

    private String nivelDificultad;

    public TourAventura(String pNombre, double pPrecioBase,
                        int pCupoMaximo, Guia pGuia,
                        String pNivelDificultad) {
        super(pNombre, pPrecioBase, pCupoMaximo, pGuia);
        nivelDificultad = pNivelDificultad;
    }

    public TourAventura(String pNombre, double pPrecioBase,
                        int pCupoMaximo, Guia pGuia) {
        this(pNombre, pPrecioBase, pCupoMaximo, pGuia, "medio");
    }

    public double calcularPrecioPorPersona() {
        return precioBase + (precioBase * PORCENTAJE_SEGURO);
    }

    public String toString() {
        return super.toString() +
               "Tipo de tour: Aventura\n" +
               "Nivel de dificultad: " + nivelDificultad + "\n";
    }
}
