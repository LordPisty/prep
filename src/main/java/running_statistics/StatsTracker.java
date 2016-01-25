package running_statistics;

/**
 * Input: very long stream of integers
 * Goal: track the mean and median of all of the values seen so far
 * requirements:
 * 1) O(1) memory, N values
 * 2) values [0, 1000)
 */
public interface StatsTracker {
    void insertInt(int input);

    double getMean();

    // mean of 2 central values if even
    double getMedian();
}