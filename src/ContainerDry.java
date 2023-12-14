public class ContainerDry extends Container {
    private final String color;

    public ContainerDry(String numero, String capacidad, String estado, String color) {
        super(numero, capacidad, estado);
        this.color = color;
    }

    public String toString() {
        return super.toString() + "\nColor: " + color;
    }
}
