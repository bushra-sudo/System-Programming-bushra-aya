public class GameWorld {

    // Fields (private)
    private String name;
    private Player[] players;
    private Enemy[] enemies;
    private int difficulty; // Easy: 1, Medium: 2, Hard: 3

    // Default constructor
    public GameWorld() {
        this.name = "Crystalpath";
        this.players = new Player[0];
        this.enemies = new Enemy[0];
        this.difficulty = 1;
    }

    // Constructor with parameters
    public GameWorld(String name, Player[] players, Enemy[] enemies, int difficulty) {
        this.name = name;

        if (players == null) {
            this.players = new Player[0];
        } else {
            this.players = players;
        }

        if (enemies == null) {
            this.enemies = new Enemy[0];
        } else {
            this.enemies = enemies;
        }

        if (difficulty < 1) {
            this.difficulty = 1;
        } else if (difficulty > 3) {
            this.difficulty = 3;
        } else {
            this.difficulty = difficulty;
        }
    }

    // Adds a player to the world (makes a new array one place bigger)
    public void addPlayer(Player player) {
        if (player == null) {
            return;
        }
        Player[] newPlayers = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            newPlayers[i] = players[i];
        }
        newPlayers[players.length] = player;
        players = newPlayers;
    }

    // Prints all players in the world
    public void printAllPlayers() {
        for (int i = 0; i < players.length; i++) {
            System.out.println("------------- Player " + (i + 1) + " -------------");
            System.out.println(players[i]);
            System.out.println();
        }
    }

    // Total value of all items of all players
    public int getTotalValueOfWorld() {
        int total = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                total += players[i].calculateInventoryValue();
            }
        }
        return total;
    }

    // Description of the world
    @Override
    public String toString() {
        return "World Name: " + name + "\n"
             + "Difficulty: " + difficulty + "\n"
             + "Number of players: " + players.length;
    }
}

