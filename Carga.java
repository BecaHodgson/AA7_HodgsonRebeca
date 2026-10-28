
public class Carga extends Vehiculo {

    public static final double MONTO_PEAJE = 500.0;

    public Carga(String pPlaca, String pMarca,
                 String pModelo, int pAnnio) {
        super(pPlaca, "carga", pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }
}
