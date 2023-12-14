public class Mercancia {
    public String numserie, descripcion, cantidad;

    public Mercancia(String numserie, String descripcion,String cantidad) {
        this.numserie = numserie;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public String toString() { return "Mercancia: " + descripcion + "\nCantidad: " + cantidad; }
}
