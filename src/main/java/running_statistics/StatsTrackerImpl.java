package running_statistics;

/**
 * Created by crespis on 1/25/2016.
 */
public class StatsTrackerImpl implements StatsTracker {

    private static final int SIZE = 1000;
    private int[] occurrences = new int[SIZE];

    private int partialSum = 0;
    private int counter = 0;

    public void insertInt(int input) {
        partialSum += input;
        counter++;

        occurrences[input] = occurrences[input] + 1;
    }

    public double getMean() {
        if (counter > 0) {
            return ((double)partialSum)/counter;
        } else {
            return -1;
        }
    }

    // mean of 2 central values if even
    public double getMedian() {
        if (counter == 0) {
            return -1;
        }
        boolean evenFlag = counter % 2 == 0;
        int medianCount = (counter / 2) + 1;
        for (int i = 0; i < occurrences.length; i++) {
            if (medianCount > occurrences[i]) {
                if (evenFlag && medianCount == occurrences[i]+1) {
                    // mean i , next i occurrences[i] <> 0
                    int j = i+1;
                    for (; j < occurrences.length && occurrences[j] == 0; j++) {}
                    return ((double) i+j)/2;
                }
                medianCount -= occurrences[i];
            } else if (medianCount <= occurrences[i]) {
                return i;
            }
        }
        return -1;
    }
}