package select.sort.heap;

import java.util.Comparator;

/**
 * @author zhanfeng.zhang
 * @email zhanfeng.zhang@xqchuxing.com
 * @date 2018-11-27 11:26
 * @description TODO
 **/
public class HeapSort {

  public static <T> void heapSort(T[] array, Comparator<T> comparator) {
    // build the heap
    for (int i = (array.length - 1) / 2; i >= 0; i--) {
      adjustHeap(array, i, array.length, comparator);
    }
    // sort the heap
    for (int i = array.length - 1; i >= 0; i--) {
      swap(array, 0, i);
      adjustHeap(array, 0, i, comparator);
    }
  }

  /**
   * @author zhanfeng.zhang
   * @email zhanfeng.zhang@xqchuxing.com
   * @Description 构建大堆
   **/
  private static <T> void adjustHeap(T[] array, int index, int endIndex,
      Comparator<T> comparator) {
    for (; ; ) {
      int leftIndex = (index + 1) * 2 - 1;
      if (leftIndex >= endIndex) {
        return;
      }
      int childIndex = leftIndex;
      int rightIndex = leftIndex + 1;
      if (rightIndex < endIndex) {
        if (comparator.compare(array[leftIndex], array[rightIndex]) < 0) {
          childIndex = rightIndex;
        }
      }
      if (comparator.compare(array[index], array[childIndex]) >= 0) {
        return;
      }
      swap(array, index, childIndex);
      index = childIndex;
    }
  }

  /**
   * @author zhanfeng.zhang
   * @email zhanfeng.zhang@xqchuxing.com
   * @Description 堆排序由小到大
   **/
  public static <T extends Comparable<T>> void heapSort(T[] array) {
    // build the heap
    for (int i = (array.length - 1) / 2; i >= 0; i--) {
      adjustHeap(array, i, array.length);
    }

    // sort the heap
    for (int i = array.length - 1; i >= 0; i--) {
      swap(array, 0, i);
      adjustHeap(array, 0, i);
    }

  }

  /**
   * @author zhanfeng.zhang
   * @email zhanfeng.zhang@xqchuxing.com
   * @Description 大堆序
   **/
  private static <T extends Comparable<T>> void adjustHeap(T[] array,
      int index, int endIndex) {
    for (; ; ) {
      // has left node ?
      int leftIndex = (index + 1) * 2 - 1;
      if (leftIndex >= endIndex) {
        return;
      }
      // has left node
      int maxIndex = leftIndex;
      // has right node?
      int rightIndex = leftIndex + 1;
      if (rightIndex < endIndex) {
        if (array[rightIndex].compareTo(array[leftIndex]) > 0) {
          maxIndex = rightIndex;
        }
      }

      if (array[index].compareTo(array[maxIndex]) >= 0) {
        return;
      }
      swap(array, index, maxIndex);
      index = maxIndex;
    }
  }

  private static <T> void swap(T[] array, int index1,
      int index2) {
    T tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }
}
