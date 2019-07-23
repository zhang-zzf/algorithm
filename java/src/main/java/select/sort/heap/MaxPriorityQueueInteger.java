package select.sort.heap;

import java.util.AbstractQueue;
import java.util.Iterator;

import static select.sort.heap.HeapUtil.*;

public class MaxPriorityQueueInteger extends AbstractQueue<Integer> {

    private Integer[] array = new Integer[4];
    private int size = 0;

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(Integer integer) {
        if (integer == null) {
            throw new NullPointerException();
        }
        ensureCapacity();
        array[size] = integer;
        adjustHeapUp(array, size);
        size += 1;
        return true;
    }

    private void ensureCapacity() {
        if (size + 1 >= array.length) {
            Integer[] newA = new Integer[array.length * 2];
            System.arraycopy(array, 0, newA, 0, array.length);
            array = newA;
        }
    }

    @Override
    public Integer poll() {
        if (size == 0) {
            return null;
        } else {
            Integer x = array[0];
            array[0] = array[--size];
            adjustHeap(array, 0, size);
            return x;
        }
    }

    @Override
    public Integer peek() {
        if (size == 0) {
            return null;
        } else {
            return array[0];
        }
    }
}
