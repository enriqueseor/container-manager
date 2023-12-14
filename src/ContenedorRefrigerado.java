public class ContenedorRefrigerado extends Contenedor {
    private final String temperatura;

    public ContenedorRefrigerado(String numero, String capacidad, String estado, String temperatura) {
        super(numero, capacidad, estado);
        this.temperatura= temperatura;
    }

    public String toString() {
        return super.toString() + "\nTemperatura: " + temperatura;
    }
}
