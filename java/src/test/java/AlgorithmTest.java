import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmTest {

    @Test
    public void binarySearch() {
        int[] sortedList = {1, 3, 5, 7, 9};
        int index = Algorithm.binarySearch(sortedList, 7);
        assertEquals(3, index);
        index = Algorithm.binarySearch(sortedList, 10);
        assertEquals(-1, index);

        index = Algorithm.binarySearch(sortedList, 3);
        assertEquals(1, index);
    }
}