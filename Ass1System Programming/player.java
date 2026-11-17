
public class Player extends Character {

    // Field (private)
    private Item[] inventory;

    // Constructor: name, health, level, and an empty inventory
    public Player(String name, int health, int level) {
        super(name, health, level);
        this.inventory = new Item[0];
    }

    // Constructor: all fields, including inventory
    public Player(String name, int health, int level, Item[] inventory) {
        super(name, health, level);
        if (inventory == null) {
            this.inventory = new Item[0];
        } else {
            this.inventory = inventory;
        }
    }

    // Adds an item to the array (makes a new array one place bigger)
    public void addItem(Item item) {
        if (item == null) {
            return;
        }
        Item[] newInventory = new Item[inventory.length + 1];
        for (int i = 0; i < inventory.length; i++) {
            newInventory[i] = inventory[i];
        }
        newInventory[inventory.length] = item;
        inventory = newInventory;
    }

    // Returns the total value of all items
    public int calculateInventoryValue() {
        int sum = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                sum += inventory[i].getValue();
            }
        }
        return sum;
    }

    // Returns true if there is at least one magical item
    public boolean hasMagicalItem() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].isMagical()) {
                return true;
            }
        }
        return false;
    }

    // All player info, including item names
    @Override
    public String toString() {
        String items = "";
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                if (!items.isEmpty()) {
                    items += " | ";
                }
                items += inventory[i].getName();
            }
        }
        return super.toString() + "\n"
             + "Inventory: " + items;
    }
}
