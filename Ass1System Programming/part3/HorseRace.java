import java.util.Scanner;

public class HorseRace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance: ");
        int distance = scanner.nextInt();
        scanner.close();

        String[] names = { "One", "Two", "Three", "Four", "Five",
                           "Six", "Seven", "Eight", "Nine", "Ten" };

        FinishingLine finishingLine = new FinishingLine();
        Thread[] threads = new Thread[names.length];

        // Create 10 horses, each one runs in its own thread
        for (int i = 0; i < names.length; i++) {
            Horse horse = new Horse(names[i], finishingLine, distance);
            threads[i] = new Thread(horse);
        }

        // Start the race
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        // Wait for all horses to finish
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

