package running_statistics;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by crespis on 1/25/2016.
 */
public class StatsTrackerTest {

    StatsTracker tracker;

    @Before
    public void setup() {
        tracker = new StatsTrackerImpl();
    }

    @Test
    public void getMeanTest() {
        tracker.insertInt(1);
        tracker.insertInt(2);
        tracker.insertInt(3);
        tracker.insertInt(4);
        tracker.insertInt(5);

        assertEquals("Mean should match", 3d, tracker.getMean(), 0.1);
    }

    public void getMeanEmptyTest() {
        assertEquals("Empty mean should match", -1d, tracker.getMean(), 0.1);
    }

    public void getMedianTest() {
        tracker.insertInt(1);
        tracker.insertInt(2);
        tracker.insertInt(3);
        tracker.insertInt(4);
        tracker.insertInt(5);

        assertEquals("Median should match", 3d, tracker.getMedian(), 0.1);
    }

    public void getMedianEvenTest() {
        tracker.insertInt(1);
        tracker.insertInt(2);
        tracker.insertInt(3);
        tracker.insertInt(4);
        tracker.insertInt(5);
        tracker.insertInt(5);

        assertEquals("Median should match", 3.5d, tracker.getMedian(), 0.1);
    }

    public void getMedianEmptyTest() {
        assertEquals("Median should match", -1d, tracker.getMedian(), 0.1);
    }
}