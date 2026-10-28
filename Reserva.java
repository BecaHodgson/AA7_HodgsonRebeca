
public class Reserva {

    private int numero;
    private String nombreCliente;
    private int cantidadPersonas;
    private double monto;

    Reserva(int pNumero, String pNombreCliente,
            int pCantidadPersonas, double pMonto) {
        numero = pNumero;
        nombreCliente = pNombreCliente;
        cantidadPersonas = pCantidadPersonas;
        monto = pMonto;
    }

    int getCantidadPersonas() {
        return cantidadPersonas;
    }

    double getMonto() {
        return monto;
    }

    public String toString() {
        return "Número de reserva: " + numero + "\n" +
               "Cliente: " + nombreCliente + "\n" +
               "Cantidad de personas: " + cantidadPersonas + "\n" +
               "Monto: " + monto;
    }
}
