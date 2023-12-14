public class ContenedorCisterna extends Contenedor {
    private final String volumen;

    public ContenedorCisterna(String numero, String capacidad, String estado, String volumen) {
        super(numero, capacidad, estado);
        this.volumen = volumen;
    }

    public String toString() {
        return super.toString() + "\nVolumen: " + volumen;
    }
}
