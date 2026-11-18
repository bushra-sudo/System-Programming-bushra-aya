import java.util.Random;

public class Horse implements Runnable {

    private String name;
    private FinishingLine finishingLine;
    private int distance;
    private Random random = new Random();

    public Horse(String name, FinishingLine f, int distanse) {
        this.name = name;
        this.finishingLine = f;
        this.distance = distanse;
    }

    @Override
    public void run() {
        printDistance();

        while (distance > 0) {
            try {
                Thread.sleep(1000); // sleeps one second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            distance -= random.nextInt(20) + 1; // random number from 1 to 20

            if (distance > 0) {
                printDistance();
            }
        }

        finishingLine.arrive(this);
    }

    public String getHorseName() {
        return name;
    }

    private void printDistance() {
        System.out.printf("%-10s%d meters to finish%n", name + ":", distance);
    }
}

