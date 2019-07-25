import static org.junit.Assert.*;

import org.junit.Test;

public class RandomizedSelectTest {

    @Test
    public void test() {
        for (int[] array : AlgorithmTest.rank) {
            assertEquals(-100, RandomizedSelect.select(array, 0));
            assertEquals(-33, RandomizedSelect.select(array, 1));
            assertEquals(1, RandomizedSelect.select(array, 3));
            assertEquals(1, RandomizedSelect.select(array, 4));
            assertEquals(9, RandomizedSelect.select(array, 7));
        }
    }

}