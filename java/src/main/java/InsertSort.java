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

  public static void recursiveInsert(int[] array, int length) {
    if (length > 1) {
      recursiveInsert(array, length - 1);
      _insert(array, length - 1);
    }
  }

  private static void _insert(int[] array, int index) {
    int key = array[index];
    for (int i = index - 1; i >= 0; i--) {
      if (array[i] > key) {
        array[i + 1] = array[i];
      } else {
        array[i + 1] = key;
        break;
      }
    }
  }


}
