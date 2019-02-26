public class SelectSort {


  /** 非降序 */
  public static void sort(int[] array) {
    for (int i = 0; i < array.length; i++) {        // c1*(n)
      int minIndex = i;                             // c2*(n)
      for (int j = i + 1; j < array.length; j++) {  // c3*(n + (n-1) +...+1)
        if (array[j] < array[i]) {                  // c4*(n +(n-1)+...+1) c4*(0+0+...+0)
          minIndex = j;                             // c5*(同上)
        }
      }
      swap(array, i, minIndex);                     // c6*n
    }
  }

  private static void swap(int[] array, int i, int minIndex) {
  }

}
