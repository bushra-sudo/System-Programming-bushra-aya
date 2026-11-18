public class Character {

    // Fields (private)
    private String name;
    private int health; // 0 - 10
    private int level;  // 0 - 5

    // Limits
    private static final int MAX_HEALTH = 10;
    private static final int MAX_LEVEL = 5;

    // Default constructor
    public Character() {
        this.name = "Unknown";
        this.health = 0;
        this.level = 0;
    }

    // Constructor with parameters (checks health and level)
    public Character(String name, int health, int level) {
        this.name = name;

        if (health < 0) {
            this.health = 0;
        } else if (health > MAX_HEALTH) {
            this.health = MAX_HEALTH;
        } else {
            this.health = health;
        }

        if (level < 0) {
            this.level = 0;
        } else if (level > MAX_LEVEL) {
            this.level = MAX_LEVEL;
        } else {
            this.level = level;
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    // Raises the level by one, without passing the maximum
    public void levelUp() {
        if (level < MAX_LEVEL) {
            level++;
        }
    }

    // Raises health by amount, without passing the maximum
    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        health += amount;
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    // General description of the character
    @Override
    public String toString() {
        return "Name: " + name + "\n"
             + "Health: " + health + "\n"
             + "Level: " + level;
    }
}

