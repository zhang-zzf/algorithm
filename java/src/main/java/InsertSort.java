public class InsertSort {

  /**
   * 非降序排序
   * @param array
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

  /** 非升序排序 */
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

}
