public class QuickSort {

  public static void sort(int[] array) {
    int left = 0, right = array.length - 1;
    _sort(array, left, right);
  }

  private static void _sort(int[] array, int left, int right) {
    // baseline
    if (left >= right) {
      return;
    }
    int idx = _partionSort(array, left, right);
    _sort(array, left, idx - 1);
    _sort(array, idx + 1, right);
  }

  private static int _partionSort(int[] array, int left, int right) {
    int pivot = array[right];
    int idx = left;
    for (int i = left; i < right; i++) {
      if (array[i] < pivot) {
        _swap(array, idx, i);
        idx++;
      }
    }
    _swap(array, idx, right);
    return idx;
  }

  private static void _swap(int[] array, int idx, int i) {
    int tmp = array[idx];
    array[idx] = array[i];
    array[i] = tmp;
  }

}
