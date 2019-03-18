public class ReversePair {

  public static int count(int[] array) {
    int ret = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j]) {
          ret += 1;
        }
      }
    }
    return ret;
  }

  public static int countByMergeSort(int[] array) {
    int[] array2 = new int[array.length];
    System.arraycopy(array, 0, array2, 0, array.length);
    return _mergeCount(array2, 0, array.length - 1);
  }

  private static int _mergeCount(int[] array, int left, int right) {
    if (left >= right) {
    }
    int mid = (left + right) / 2;
    return _mergeCount(array, left, mid) + _mergeCount(array, mid + 1, right) + _merge(array, left,
        mid, right);
  }

  private static int _merge(int[] array, int left, int mid, int right) {
    int ret = 0;
    int[] tmp = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j <= right) {
      if (array[i] <= array[j]) {
        tmp[k++] = array[i++];
      } else {
        tmp[k++] = array[j++];
        ret += mid - i + 1;
      }
    }
    while (i <= mid) {
      tmp[k++] = array[i++];
    }
    while (j <= right) {
      tmp[k++] = array[j++];
    }
    for (k = 0; k < tmp.length; ) {
      array[left++] = tmp[k++];
    }
    return ret;
  }

}
