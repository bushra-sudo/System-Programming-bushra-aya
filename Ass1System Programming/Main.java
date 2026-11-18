public class Main {

    public static void main(String[] args) {

        // 1. Create items
        Item grimoire = new Item("Grimoire", 5, true);
        Item iceSword = new Item("Ice Sword", 3, true);
        Item shield = new Item("Guardian Shield", 4, false);
        Item wand = new Item("Wand of Winds", 6, true);

        // 2. Create players (health 10) and add items with addItem
        Player elara = new Player("Elara the Enchanter", 10, 4);
        elara.addItem(grimoire);
        elara.addItem(iceSword);

        Player kael = new Player("Kael the Windcaller", 10, 1);
        kael.addItem(shield);
        kael.addItem(wand);

        // 3. Create an enemy
        Enemy goblin = new Enemy("Goblin", 10, 2, 3);

        // 4. Create the game world
        Player[] players = { elara, kael };
        Enemy[] enemies = { goblin };
        GameWorld world = new GameWorld("Crystalpath", players, enemies, 2);

        System.out.println(world);
        System.out.println();

        // 5. Print all players
        world.printAllPlayers();

        // 6. Total item value for each player
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + " - inventory value: "
                    + players[i].calculateInventoryValue());
        }
        System.out.println("Total value of world: " + world.getTotalValueOfWorld());
        System.out.println();

        // 7 + 8. Battle simulation and results
        simulateBattle(elara, goblin);
        System.out.println();
        simulateBattle(kael, goblin);
    }

    // Compares levels; the winner goes up one level
    public static void simulateBattle(Player player, Enemy enemy) {
        System.out.println(player.getName() + " - level : " + player.getLevel()
                + " VS " + enemy.getName() + " - level : " + enemy.getLevel());

        if (player.getLevel() > enemy.getLevel()) {
            player.levelUp();
            System.out.println(player.getName() + " wins!");
        } else if (enemy.getLevel() > player.getLevel()) {
            enemy.levelUp();
            System.out.println(enemy.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}

