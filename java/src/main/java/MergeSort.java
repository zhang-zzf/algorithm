public class MergeSort {

  public static void sort(int[] array) {
    _sort(array, 0, array.length - 1);
  }

  private static void _sort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = (left + right) / 2;
    _sort(array, left, mid);
    _sort(array, mid + 1, right);
    _merge(array, left, mid, right);
  }

  private static void _merge(int[] array, int left, int mid, int right) {
    int[] tmp = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j <= right) {
      if (array[i] <= array[j]) {
        tmp[k++] = array[i++];
      } else {
        tmp[k++] = array[j++];
      }
    }
    while (i <= mid) {
      tmp[k++] = array[i++];
    }
    while (j <= right) {
      tmp[k++] = array[j++];
    }

    i = left;
    k = 0;
    while (i <= right) {
      array[i++] = tmp[k++];
    }
  }

}
