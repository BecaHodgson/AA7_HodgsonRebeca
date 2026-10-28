
public class Moto extends Vehiculo {

    public static final double MONTO_PEAJE = 75.0;

    public Moto(String pPlaca, String pMarca,
                String pModelo, int pAnnio) {
        super(pPlaca, "moto", pMarca, pModelo, pAnnio);
    }

    public double calcularMontoPeaje() {
        return MONTO_PEAJE;
    }
}
