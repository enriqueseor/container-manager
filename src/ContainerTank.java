public class ContainerTank extends Container {
    private final String volumen;

    public ContainerTank(String numero, String capacidad, String estado, String volumen) {
        super(numero, capacidad, estado);
        this.volumen = volumen;
    }

    public String toString() {
        return super.toString() + "\nVolumen: " + volumen;
    }
}
