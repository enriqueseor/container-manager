public class ContainerTank extends Container {
    private final String volume;

    public ContainerTank(String number, String capacity, String state, String volume) {
        super(number, capacity, state);
        this.volume = volume;
    }

    public String toString() {
        return super.toString() + "\nVolume: " + volume;
    }
}
