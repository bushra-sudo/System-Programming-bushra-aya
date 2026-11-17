public class Item {

    // Fields (private)
    private String name;
    private int value;
    private boolean isMagical;

    // Default constructor
    public Item() {
        this.name = "Unknown";
        this.value = 0;
        this.isMagical = false;
    }

    // Constructor with parameters
    public Item(String name, int value, boolean isMagical) {
        this.name = name;
        setValue(value); // negative value becomes 0
        this.isMagical = isMagical;
    }

    // Description of the item
    @Override
    public String toString() {
        String result = "Name: " + name + "\n"
                      + "Value: " + value + "\n";
        if (isMagical) {
            result += "Magical item";
        } else {
            result += "Not a magical item";
        }
        return result;
    }

    // Returns the value
    public int getValue() {
        return value;
    }

    // Updates the value; a negative value sets it to 0
    public void setValue(int value) {
        if (value < 0) {
            this.value = 0;
        } else {
            this.value = value;
        }
    }

    // Returns whether the item is magical
    public boolean isMagical() {
        return isMagical;
    }

    // Returns the item's name
    public String getName() {
        return name;
    }
}
