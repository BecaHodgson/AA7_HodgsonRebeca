
public class CargaLiviana extends Vehiculo {

    public static final double MONTO_PEAJE = 200.0;

    public CargaLiviana(String pPlaca, String pMarca,
                        String pModelo, int pAnnio) {
        super(pPlaca, "carga liviana", pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }
}
