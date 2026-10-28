
public class Particular extends Vehiculo {

    public static final double MONTO_PEAJE = 100.0;

    public Particular(String pPlaca, String pMarca,
                      String pModelo, int pAnnio) {
        super(pPlaca, "particular", pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }
}
