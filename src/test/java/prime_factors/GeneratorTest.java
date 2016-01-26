package prime_factors;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by crespis on 1/26/2016.
 */
public class GeneratorTest {

    Generator generator;

    private List<Integer> list(int... ints) {
        List<Integer> list = new ArrayList<>();
        for (int i : ints) {
            list.add(i);
        }
        return list;
    }

    @Before
    public void setup() {
        generator = new GeneratorImpl();
    }

    @Test
    public void testOne() throws Exception {
        assertEquals(list(),generator.generate(1));
    }

    @Test
    public void testTwo() throws Exception {
        assertEquals(list(2),generator.generate(2));
    }

    @Test
    public void testThree() throws Exception {
        assertEquals(list(3),generator.generate(3));
    }

    @Test
    public void testFour() throws Exception {
        assertEquals(list(2,2),generator.generate(4));
    }

    @Test
    public void testSix() throws Exception {
        assertEquals(list(2,3),generator.generate(6));
    }

    @Test
    public void testEight() throws Exception {
        assertEquals(list(2,2,2),generator.generate(8));
    }

    @Test
    public void testNine() throws Exception {
        assertEquals(list(3,3),generator.generate(9));
    }

    @Test
    public void testfourteen() throws Exception {
        assertEquals(list(2,7),generator.generate(14));
    }

}
