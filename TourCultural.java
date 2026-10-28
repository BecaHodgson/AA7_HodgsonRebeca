
public class TourCultural extends Tour {

    private String idioma;

    public TourCultural(String pNombre, double pPrecioBase,
                        int pCupoMaximo, Guia pGuia, String pIdioma) {
        super(pNombre, pPrecioBase, pCupoMaximo, pGuia);
        idioma = pIdioma;
    }

    public double calcularPrecioPorPersona() {
        double precio = precioBase;

        for (Atractivo atractivo : atractivos) {
            precio += atractivo.getMontoEntrada();
        }

        return precio;
    }

    public String toString() {
        return super.toString() +
               "Tipo de tour: Cultural\n" +
               "Idioma: " + idioma + "\n";
    }
}
