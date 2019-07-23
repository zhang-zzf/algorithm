package select.sort.heap;

public class HeapUtil {

    public static int rightChildIdx(int i) {
        return (i + 1) * 2;
    }

    public static int leftChildIdx(int i) {
        return (i + 1) * 2 - 1;
    }

    private static void swap(Integer[] array, int i, int i1) {
        int tmp = array[i];
        array[i] = array[i1];
        array[i1] = tmp;
    }

    public static int parentIdx(int i) {
        return (i + 1) / 2 - 1;
    }

    public static void adjustHeapUp(Integer[] array, int index) {
        Integer key = array[index];
        while (parentIdx(index) >= 0 && array[parentIdx(index)] < key) {
            array[index] = array[parentIdx(index)];
            index = parentIdx(index);
        }
        array[index] = key;
    }

    public static void adjustHeap(Integer[] array, int i, int heapSize) {
        if (leftChildIdx(i) < heapSize) {
            int idx = i;
            if (array[leftChildIdx(i)] > array[idx]) {
                idx = leftChildIdx(i);
            }
            if (rightChildIdx(i) < heapSize
                && array[rightChildIdx(i)] > array[idx]) {
                idx = rightChildIdx(i);
            }
            if (idx != i) {
                swap(array, i, idx);
                adjustHeap(array, idx, heapSize);
            }
        }

    }

}
