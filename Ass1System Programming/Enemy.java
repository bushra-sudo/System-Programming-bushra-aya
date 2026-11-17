public class Enemy extends Character {

    // Field (private)
    private int damage; // 1 - 5

    // Limits
    private static final int MIN_DAMAGE = 1;
    private static final int MAX_DAMAGE = 5;

    // Constructor with parameters (uses Character constructor via super)
    public Enemy(String name, int health, int level, int damage) {
        super(name, health, level);

        if (damage < MIN_DAMAGE) {
            this.damage = MIN_DAMAGE;
        } else if (damage > MAX_DAMAGE) {
            this.damage = MAX_DAMAGE;
        } else {
            this.damage = damage;
        }
    }

    // Getter
    public int getDamage() {
        return damage;
    }

    // Name, health, level and damage
    @Override
    public String toString() {
        return super.toString() + "\n"
             + "Damage: " + damage;
    }
}


