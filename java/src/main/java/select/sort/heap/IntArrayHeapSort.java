package select.sort.heap;

/**
 * @author zhanfeng.zhang
 * @email zhanfeng.zhang@xqchuxing.com
 * @date 2018-11-27 10:37
 * @description TODO
 **/
public class IntArrayHeapSort {

  /**
   * @author zhanfeng.zhang
   * @email zhanfeng.zhang@xqchuxing.com
   * @Description heapSort
   **/
  public static void heapSort(int[] array) {
    // build the heap
    for (int i = (array.length - 1) / 2; i >= 0; i--) {
      adjustHeap(array, i, array.length - 1);
    }
    // sort the heap
    for (int i = array.length - 1; i >= 0; i--) {
      swap(array, 0, i);
      adjustHeap(array, 0, i - 1);
    }
  }


  /**
   * @author zhanfeng.zhang
   * @email zhanfeng.zhang@xqchuxing.com
   * @Description TODO
   **/
  private static void adjustHeap(int[] array, int index, int maxIndex) {
    for (; ; ) {
      int leftNodeIndex = 2 * (index + 1) - 1;
      if (!hasNode(leftNodeIndex, maxIndex)) {
        return;
      }
      // has left node
      int minIndex = leftNodeIndex;

      // has right node
      int rightNodeIndex = leftNodeIndex + 1;
      if (hasNode(rightNodeIndex, maxIndex)
          && array[leftNodeIndex] > array[rightNodeIndex]) {
        minIndex = rightNodeIndex;
      }

      if (array[index] <= array[minIndex]) {
        return;
      }
      swap(array, index, minIndex);
      index = minIndex;
    }
  }

  private static void swap(int[] array, int index1, int index2) {
    int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

  private static boolean hasNode(int index, int maxIndex) {
    return index <= maxIndex;
  }
}
