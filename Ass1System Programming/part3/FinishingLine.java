
public class FinishingLine {

    private int place = 0;

    // synchronized: only one horse at a time can arrive,
    // so two horses never get the same place
    public synchronized void arrive(Horse h) {
        place++;

        if (place == 1) {
            // one println, so other horses' lines don't get mixed into the box
            System.out.println("******************************\n"
                    + "====> " + h.getHorseName() + " finished first!\n"
                    + "******************************");
        } else {
            System.out.println("====> " + h.getHorseName() + " finished on " + place + "-th place");
        }
    }
}
