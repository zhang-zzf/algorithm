/**
 * binary search.
 */
public class BinarySearch {

  public static int recursiveSearch(int[] array, int key, int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      return -1;
    } else {
      int mid = (startIndex + endIndex) / 2;
      if (array[mid] == key) {
        return mid;
      } else if (array[mid] > key) {
        return recursiveSearch(array, key, mid + 1, endIndex);
      } else {
        return recursiveSearch(array, key, startIndex, mid - 1);
      }
    }
  }

  /**
   * binary search you known.
   *
   * @param array the array need to be searched.
   * @param value value
   * @return the index of the value in the array or -1 if the value not exists in the array.
   */
  public static int search(int[] array, int value) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (array[mid] == value) {
        return mid;
      } else if (array[mid] < value) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }


  /**
   * 尽量向右吞，若value在array中存在，则必须是在left-1的位置.
   * <p>并且若array中存在多个value，left-1位置是value在array中的最大index</p>
   * <p>注意判断越界问题</p>
   *
   * @param array 从小到大有序列表
   */
  public static int search2(int[] array, int value) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      // 先动左指针
      if (array[mid] <= value) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    int bestGuess = left - 1;
    if (bestGuess >= 0 && array[bestGuess] == value) {
      return bestGuess;
    }
    return -1;
  }

  /**
   * 先动右指针，尽量向左吞，若存在value，则一定在right+1位置.
   * <p>并且若array中存在多个value，right+1位置是value在array中的最小index</p>
   * <p>注意判断数组越界问题</p>
   *
   * @param array 由小到大有序列表
   * @param value v
   */
  public static int search3(int[] array, int value) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      // 先动右指针
      if (array[mid] >= value) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    int bestGuest = right + 1;
    if (bestGuest < array.length && array[bestGuest] == value) {
      return bestGuest;
    }
    return -1;
  }

  /**
   * array中找到第一个比value大的index.
   *
   * @param array 自然列表
   */
  public static int search4(int[] array, int value) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (array[mid] <= value) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    int bestGuess = left;
    if (bestGuess < array.length) {
      return bestGuess;
    }
    return -1;
  }

  /**
   * array 中找到第一个比value小的index
   * @param array 自然列表
   * @param value
   * @return
   */
  public static int search5(int[] array, int value) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (array[mid] >= value) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    int bestGuess = right;
    if (bestGuess >= 0) {
      return bestGuess;
    }
    return -1;
  }

  // TODO 还有2种情况

  /**
   * <=
   * 先动左指针  尽量向右吞
   *
   * left-1>=0&&array[left-1]==value 时，left-1位置即为value在array中最大的index
   * 不满足以上条件时，array中不存在value
   *
   * left<array.length时，left位置即为array中第一个大于value的index
   *
   */

  /**
   * >=
   * 先动右指针  尽量向坐吞
   *
   * right+1<array.length && array[right+1]==value 时，right+1位置为value在array中的最小index
   * 不满足以上条件时，array中不存在value
   *
   * right>=0 right位置为array中最后一个小于value的index
   */

  /**
   * <
   * 先动左指针  尽量少吞
   * 和第二种情况一样
   */

  /**
   * >
   * 先动右指针  尽量少吞
   * 和第一种情况一样
   */
  /**
   * 综上所述，二分查找可以查找4个位置
   * array中等于value的最小index和最大index
   * array中小于value的最大index和大于value的最小index
   *
   */

}
