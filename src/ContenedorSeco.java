public class ContenedorSeco extends Contenedor {
    private final String color;

    public ContenedorSeco(String numero, String capacidad, String estado, String color) {
        super(numero, capacidad, estado);
        this.color = color;
    }

    public String toString() {
        return super.toString() + "\nColor: " + color;
    }
}
