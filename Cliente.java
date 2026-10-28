
public class Cliente {

    private String nombre;
    private String condicion;

    public Cliente(String pNombre, String pCondicion) {
        nombre = pNombre;
        condicion = pCondicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCondicion() {
        return condicion;
    }

    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Condición: " + condicion;
    }
}
