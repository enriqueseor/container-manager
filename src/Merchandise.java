public class Merchandise {
    public String numContainer, description, quantity;

    public Merchandise(String numContainer, String description, String quantity) {
        this.numContainer = numContainer;
        this.description = description;
        this.quantity = quantity;
    }

    public String toString() { return "Merchandise: " + description + "\nQuantity: " + quantity; }
}
