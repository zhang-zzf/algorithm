package select.sort.heap;

public class MaxHeapSortIntArray {

    public static void sort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
    }

    private static void adjustHeap(int[] array, int i, int heapSize) {
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

    private static int rightChildIdx(int i) {
        return (i + 1) * 2;
    }

    private static int leftChildIdx(int i) {
        return (i + 1) * 2 - 1;
    }

    private static void swap(int[] array, int i, int i1) {
        int tmp = array[i];
        array[i] = array[i1];
        array[i1] = tmp;
    }

    private static void buildHeap(int[] array) {
        for (int i = parentIdx(array.length - 1); i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
    }

    private static int parentIdx(int i) {
        return (i + 1) / 2 - 1;
    }

}
