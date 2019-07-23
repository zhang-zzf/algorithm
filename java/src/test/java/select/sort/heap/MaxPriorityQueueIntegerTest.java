package select.sort.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaxPriorityQueueIntegerTest {

    private MaxPriorityQueueInteger queue;

    @Before
    public void init() {
        queue = new MaxPriorityQueueInteger();
    }

    @Test
    public void testBasic() {
        assertEquals(null, queue.peek());
        assertEquals(null, queue.poll());

        queue.offer(1);
        assertEquals(1, queue.poll().intValue());
        assertEquals(null, queue.poll());

        for (int i = 0; i < 88; i++) {
            queue.offer(i);
            assertEquals(i, queue.peek().intValue());
        }

        for (int i = 87; i >=0; i--) {
            assertEquals(i, queue.poll().intValue());
        }

    }

    @Test
    public void offer() {
    }

    @Test
    public void poll() {
    }

    @Test
    public void peek() {
    }
}