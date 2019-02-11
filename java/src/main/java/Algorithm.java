import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Algorithm {

  public static int heapFindKMax(int[] array, int k) {
    if (k > array.length) {
      k = array.length;
    }
    int[] minHeap = new int[k];
    int heapSize = 0;
    for (int i = 0; i < array.length; i++) {
      if (heapSize < k) {
        minHeap[heapSize++] = array[i];
        siftUp(minHeap, heapSize - 1);
      } else if (array[i] > minHeap[0]) {
        minHeap[0] = array[i];
        adjustMinHeap(minHeap, heapSize - 1);
      }
    }
    return minHeap[0];
  }

  private static void siftUp(int[] minHeap, int curMax) {
    while (curMax != 0) {
      int parent = (curMax - 1) / 2;
      if (minHeap[curMax] < minHeap[parent]) {
        _swap(minHeap, curMax, parent);
        curMax = parent;
      } else {
        break;
      }
    }
  }

  private static void adjustMinHeap(int[] minHeap, int maxIndex) {
    int cur = 0;
    for (; ; ) {
      int leftNode = 2 * (cur + 1) - 1;
      if (leftNode > maxIndex) {
        break;
      }
      int rightNode = leftNode + 1;
      int minNode = leftNode;
      if (rightNode <= maxIndex && minHeap[rightNode] < minHeap[minNode]) {
        minNode = rightNode;
      }
      if (minHeap[cur] <= minHeap[minNode]) {
        break;
      }
      _swap(minHeap, cur, minNode);
      cur = minNode;
    }

  }

  /**
   * @author zhanfeng.zhang
   * @email zhanfeng.zhang@xqchuxing.com
   * @Description wrong implement
   **/
  public static int findSecondMaxWrong(int[] array) {
    int max = array[0], secondMax = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] >= max) {
        max = array[i];
      }
    }
    for (int i = 0; i < array.length; i++) {
      if (array[i] > secondMax && array[i] < max) {
        secondMax = array[i];
      }
    }
    return secondMax;
  }

  public static int quickSortFindKMax(int[] array, int k) {
    int low = 0, high = array.length - 1;
    k = array.length - k;
    for (; ; ) {
      int index = _partSortBest(array, low, high);
      if (index == k) {
        return array[index];
      } else if (index > k) {
        high = index - 1;
      } else {
        low = index + 1;
      }
    }
  }


  /**
   * 阶乘
   */
  public static int factorial(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must >= 0");
    }
    int ret = 1;
    if (n > 0) {
      for (int i = 1; i <= n; i++) {
        ret *= i;
      }
    }
    return ret;

  }

  public static List<int[]> rank(int[] array) {
    List<int[]> ret = new LinkedList<>();
    _rank(ret, Arrays.copyOf(array, array.length), 0, array.length - 1);
    return ret;
  }

  /**
   * 排列算法
   */
  private static void _rank(List<int[]> ret, int[] array, int left, int right) {
    // 基线条件
    if (left >= right) {
      ret.add(array);
      //System.out.println(Arrays.toString(array));
      return;
    }

    for (int i = left; i <= right; i++) {
      if (i > left) {
        array = Arrays.copyOf(array, array.length);
      }
      _swap(array, left, i);
      _rank(ret, array, left + 1, right);
    }
  }

  /**
   * dual pivot quick sort Dual-Pivot快排
   */
  public static void dualPivotQuickSort(int[] array) {
    _dualPivotQuickSort(array, 0, array.length - 1);
  }

  private static void _dualPivotQuickSort(int[] array, int left, int right) {
    if (right - left <= 0) {
      return;
    }

    // 排序核心算法
    int minPivot = Math.min(array[left], array[right]);
    int maxPivot = Math.max(array[left], array[right]);
    int minIndex = left + 1, maxIndex = right - 1, i = minIndex;
    while (i <= maxIndex) {
      if (array[i] < minPivot) {
        // 移动小值到左边
        _swap(array, minIndex++, i);
      } else if (array[i] > maxPivot) {
        while (i < maxIndex && array[maxIndex] > maxPivot) {
          maxIndex -= 1;
        }

        // 移动大值到右边
        _swap(array, i, maxIndex--);

        // 移动后重新判断
        if (array[i] < minPivot) {
          _swap(array, minIndex++, i);
        }
      }

      i += 1;
    }

    // 修复索引值
    minIndex -= 1;  // minIndex和左边的值都比minPivot小
    maxIndex += 1;  // maxIndex和右边的值都比maxPivot大

    // pivot 归位
    array[left] = array[minIndex];
    array[minIndex] = minPivot;
    array[right] = array[maxIndex];
    array[maxIndex] = maxPivot;

    _dualPivotQuickSort(array, left, minIndex - 1);
    _dualPivotQuickSort(array, minIndex + 1, maxIndex - 1);
    _dualPivotQuickSort(array, maxIndex + 1, right);
  }

  /**
   * 二分查找/折半查找
   *
   * @return index/-1
   */
  public static int binarySearch(int[] sortedList, int value) {
    int low = 0, high = sortedList.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      int guess = sortedList[mid];
      if (value == guess) {
        return mid;
      } else if (guess < value) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  /**
   * 二分查找自然有序数组中和预期值相等的最小的下标值.
   */
  public static int binarySearchSmallestIndex(int[] sortedList, int value) {
    int left = 0, right = sortedList.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (sortedList[mid] >= value) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    int bestIdx = right + 1; // bestIdx = left;
    if (bestIdx < sortedList.length && sortedList[bestIdx] == value) {
      return bestIdx;
    }
    return -1;
  }

  /**
   * 二分查找自然有序数组中等于value的最大下标值.
   */
  public static int binarySearchLargestIndex(int[] sortedList, int value) {
    int left = 0, right = sortedList.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (sortedList[mid] <= value) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    int bestGuess = right;
    if (bestGuess >= 0 && sortedList[bestGuess] == value) {
      return bestGuess;
    }
    return -1;
  }

  public static int binarySearchLqValueThanExpect(int[] sortedList, int expect) {
    int left = 0, right = sortedList.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (sortedList[mid] >= expect) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    int guessIdx = left;
    if (left < sortedList.length) {
      if (sortedList[left] == expect) {
        guessIdx = left;
      } else {
        guessIdx = left - 1;
      }
    } else {
      guessIdx = sortedList.length - 1;
    }
    return guessIdx;
  }

  /**
   * 选择排序
   */
  public static void selectionSort(int[] list) {
    for (int index = 0; index < list.length; index++) {
      int maxValueIndex = index;
      for (int searchIndex = index + 1; searchIndex < list.length; searchIndex++) {
        if (list[searchIndex] > list[maxValueIndex]) {
          maxValueIndex = searchIndex;
        }
      }
      _swap(list, index, maxValueIndex);
    }
  }

  /**
   * 快速排序（递归实现）
   */
  public static void recursionQuickSort(int[] array, int start, int end) {
    int low = start, high = end - 1;
    // 基线条件
    if (low >= high) {
      return;
    }
    int index = _partSortBest(array, low, high);
    recursionQuickSort(array, start, index);
    recursionQuickSort(array, index + 1, end);
  }

  /**
   * 快速排序算法
   */
  public static void quickSort(int[] array, int start, int end) {
    Deque<Integer> stack = new LinkedList<>();
    int low = start, high = end - 1;
    stack.push(high);
    stack.push(low);
    while (stack.size() > 0) {
      low = stack.poll();
      high = stack.poll();
      int index = _partSortBest(array, low, high);
      if (low < index - 1) {
        stack.push(index - 1);
        stack.push(low);
      }
      if (index + 1 < high) {
        stack.push(high);
        stack.push(index + 1);
      }
    }
  }

  /**
   * 最大公约数递归实现（欧几里德算法）
   */
  public static int recursionGcd(int a, int b) {
    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    return recursionGcd(b, a % b);
  }

  /**
   * 最大公约数（欧几里德算法）
   */
  public static int gcd(int a, int b) {
    for (int r = a % b; r != 0; r = a % b) {
      a = b;
      b = r;
    }
    return b;
  }

  private static int _partSortBest(int[] array, int left, int right) {
    int pivotIndex = left;
    for (int i = pivotIndex + 1; i <= right; i++) {
      if (array[i] < array[left]) {
        _swap(array, ++pivotIndex, i);
      }
    }
    _swap(array, left, pivotIndex);
    return pivotIndex;
  }

  private static int _partSort(int[] array, int low, int high) {
    int index = low;
    int pivot = array[index];

    while (low < index || high > index) {
      while (low < index) {
        if (array[low] > pivot) {
          _swap(array, low, index);
          index = low;
        } else {
          low += 1;
        }
      }
      while (high > index) {
        if (array[high] < pivot) {
          _swap(array, index, high);
          index = high;
        } else {
          high -= 1;
        }
      }
    }
    return index;
  }

  /**
   * better than _partSort
   */
  private static int _partSort2(int[] array, int left, int right) {

    int pivotIndex = right;
    int pivot = array[pivotIndex];
    while (left < right) {
      while (left < right && array[left] <= pivot) {
        left += 1;
      }
      while (left < right && array[right] >= pivot) {
        right -= 1;
      }
      _swap(array, left, right);
    }
    _swap(array, left, pivotIndex);

    return left;
  }

  private static void _swap(int[] list, int index1, int index2) {
    if (index1 == index2) {
      return;
    }
    int tmp = list[index1];
    list[index1] = list[index2];
    list[index2] = tmp;
  }


}
