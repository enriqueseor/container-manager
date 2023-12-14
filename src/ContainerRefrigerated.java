public class ContainerRefrigerated extends Container {
    private final String temperatura;

    public ContainerRefrigerated(String numero, String capacidad, String estado, String temperatura) {
        super(numero, capacidad, estado);
        this.temperatura= temperatura;
    }

    public String toString() {
        return super.toString() + "\nTemperatura: " + temperatura;
    }
}
