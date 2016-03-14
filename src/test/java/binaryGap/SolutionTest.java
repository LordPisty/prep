package binaryGap;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by crespis on 3/14/2016.
 */
public class SolutionTest {

    Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void testOne() throws Exception {
        assertEquals(0,solution.solution(1));
    }

    @Test
    public void testTwo() throws Exception {
        assertEquals(0,solution.solution(2));
    }

    @Test
    public void testThree() throws Exception {
        assertEquals(1,solution.solution(10));
    }

    @Test
    public void testFour() throws Exception {
        assertEquals(3,solution.solution(611));
    }

    @Test
    public void testSix() throws Exception {
        assertEquals(0,solution.solution(-1));
    }

    @Test
    public void testEight() throws Exception {
        assertEquals(2,solution.solution(608));
    }
}
