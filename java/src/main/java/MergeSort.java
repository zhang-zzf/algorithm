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

  public static void inserSortThenMerge(int[] array) {
    _inserSortThenMerge(array, 0, array.length - 1, 4);
  }

  private static void _inserSortThenMerge(int[] array, int left, int right, int k) {
    if (right - left + 1 <= k) {
      // insertSort k sequence of the array
      _insertSort(array, left, right);
    } else {
      //
      int mid = (left + right) / 2;
      _inserSortThenMerge(array, left, mid, k);
      _inserSortThenMerge(array, mid + 1, right, k);
      _merge(array, left, mid, right);
    }
  }

  private static void _insertSort(int[] array, int left, int right) {
    for (int i = left; i <= right; i++) {
      InsertSort._insert(array, i);
    }
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
