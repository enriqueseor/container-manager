public class ContainerRefrigerated extends Container {
    private final String temperature;

    public ContainerRefrigerated(String number, String capacity, String state, String temperature) {
        super(number, capacity, state);
        this.temperature = temperature;
    }

    public String toString() {
        return super.toString() + "\nTemperature: " + temperature;
    }
}
