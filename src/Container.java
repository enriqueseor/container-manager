public abstract class Container {
    private String numContainer, capacity, state;
    private final Merchandise[] merchandises = new Merchandise[100];

    public Container(String numContainer, String capacity, String state) {
        this.numContainer = numContainer;
        this.capacity = capacity;
        this.state = state;
    }

    public void addMerchandise(int i, Merchandise[] merchandises) {
        if (i >= 0) System.arraycopy(merchandises, 0, this.merchandises, 0, i);
    }

    public void setNumContainer(String numContainer){ this.numContainer = numContainer; }
    public void setCapacity(String capacity){ this.capacity = capacity; }
    public void setState(String state){ this.state = state; }

    @Override
    public String toString() {
        return "Number: " + numContainer + "\nCapacity: " + capacity + "\nState: " + state;
    }
}