public class InsertSort {


  /**
   * 非降序排序
   */
  public static void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int key = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j -= 1;
      }
      array[j + 1] = key;
    }
  }

  /**
   * 非升序排序
   */
  public static void sort2(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int key = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] < key) {
        array[j + 1] = array[j];
        j -= 1;
      }
      array[j + 1] = key;
    }
  }


  public static void sort3(int[] array) {
    for (int keyIndex = 1; keyIndex < array.length; keyIndex++) {
      _insert(array, keyIndex);
    }
  }

  public static void recursiveInsert(int[] array, int length) {
    if (length > 1) {
      recursiveInsert(array, length - 1);
      _insert(array, length - 1);
    }
  }

  public static void insertSortWithBinarySearch(int[] array) {
    for (int i = 1; i < array.length; i++) {
      _insertWithBinarySearch(array, i);
    }
  }

  public static void _insert(int[] array, int keyIndex) {
    int key = array[keyIndex];
    int i = keyIndex - 1;
    while (i >= 0 && array[i] > key) {
      array[i + 1] = array[i--];
    }
    array[i + 1] = key;
  }

  private static void _insertWithBinarySearch(int[] array, int keyIndex) {
    int key = array[keyIndex];
    int insertIndex = _binarySearch(array, keyIndex);
    System.arraycopy(array, insertIndex, array, insertIndex + 1, keyIndex - insertIndex);
    array[insertIndex] = key;
  }

  private static int _binarySearch(int[] array, int keyIndex) {
    int key = array[keyIndex];
    int left = 0, right = keyIndex - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (array[mid] <= key) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }


}
