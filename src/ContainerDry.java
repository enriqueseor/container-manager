public class ContainerDry extends Container {
    private final String color;

    public ContainerDry(String number, String capacity, String state, String color) {
        super(number, capacity, state);
        this.color = color;
    }

    public String toString() {
        return super.toString() + "\nColor: " + color;
    }
}
