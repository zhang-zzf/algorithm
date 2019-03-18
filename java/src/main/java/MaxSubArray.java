public class MaxSubArray {

  /**
   * 前提条件是数组有正有负，最大连续子数组肯定大于0
   * <p>此算法无法应用到全负数组</p>
   * <p>加以改造可以应用到全负数组</p>
   * @param array
   * @return
   */
  public static MaxData findMaxDataO_n(int[] array) {
    MaxData m = new MaxData();
    m.setMax(Integer.MIN_VALUE); // important, adapte for all negative array.
    int curSum = 0;
    int lastLeft = 0;
    for (int i = 0; i < array.length; i++) {
      curSum += array[i];
      if (curSum > m.getMax()) {
        m.setMax(curSum);
        m.setLeft(lastLeft);
        m.setRight(i);
      }

      if (curSum < 0) {
        curSum = 0;
        lastLeft = i + 1;
      }
    }
    return m;
  }

  public static MaxData findMaxO_n(int[] array) {

    MaxData max = null;
    for (int i = 0; i < array.length; i++) {
      // MaxData newMax = _findMaxData(array, i);
      MaxData newMax = _findMaxData(array, max, i);
      if (max == null || newMax.getMax() > max.getMax()) {
        max = newMax;
      }
    }
    return max;
  }

  /**
   * 算法是错误的
   * 基本 O(1)
   * @param array
   * @param max
   * @param right
   * @return
   */
  private static MaxData _findMaxData(int[] array, MaxData max, int right) {
    if (right == 0) {
      max = new MaxData();
      max.setMax(array[right]);
      max.setLeft(0);
      max.setRight(right);
      return max;
    }
    int sum = 0;
    int newMax = max.getMax();
    int newLeft = max.getLeft();
    int newRight = max.getRight();
    for (int i = right; i >= max.getLeft(); i--) {
      sum += array[i];
    }
    if (newMax < sum) {
      newRight = right;
      newMax = sum;
    }

    if (newMax < array[right]) {
      newLeft = right;
      newRight = right;
      newMax = array[right];
    }
    max.setLeft(newLeft);
    max.setRight(newRight);
    max.setMax(newMax);
    return max;
  }

  /**
   * 此方法是错误的，不能达到0(n)的时间复杂度
   */
  private static MaxData _findMaxData(int[] array, int right) {
    MaxData d = new MaxData();
    int left = 0;
    int max = array[right];
    int sum = 0;
    for (int i = right - 1; i >= 0; i--) {
      sum += array[i];
      if (sum > 0) {
        max += sum;
        left = i;
        sum = 0;
      }
    }
    d.setMax(max);
    d.setLeft(left);
    d.setRight(right);
    return d;
  }

  public static MaxData findMaxO_nlgn(int[] array) {
    MaxData d = new MaxData();
    for (int i = 0; i < array.length; i++) {
      int max = array[i];
      int left = i;
      int right = i;
      int sum = 0;
      for (int j = i + 1; j < array.length; j++) {
        sum += array[j];
        if (sum > 0) {
          max += sum;
          right = j;
          sum = 0;
        }
      }
      if (i == 0 || max > d.getMax()) {
        d.setLeft(left);
        d.setRight(right);
        d.setMax(max);
      }
    }

    return d;
  }

  public static int max(int[] array) {

    int maxSum = array[0];
    for (int i = 0; i < array.length; i++) {
      int sum = array[i];
      if (sum > maxSum) {
        maxSum = sum;
      }
      for (int j = i + 1; j < array.length; j++) {
        sum += array[j];
        if (sum > maxSum) {
          maxSum = sum;
        }
      }
    }
    return maxSum;
  }

  public static int maxByDivideAndConquer(int[] array) {
    return _findByDaC(array, 0, array.length - 1);
  }

  private static int _findByDaC(int[] array, int left, int right) {
    if (left == right) {
      return array[left];
    }
    int mid = (left + right) / 2;
    int leftMax = _findByDaC(array, left, mid);
    int rightMax = _findByDaC(array, mid + 1, right);
    int allMax = _findMergeMax(array, left, mid, right);
    return Math.max(Math.max(leftMax, rightMax), allMax);
  }

  private static int _findMergeMax(int[] array, int left, int mid, int right) {
    int max = array[mid] + array[mid + 1];
    int sum = 0;
    for (int i = mid - 1; i >= left; i--) {
      sum += array[i];
      if (sum >= 0) {
        max += sum;
        sum = 0;
      }
    }
    // very import, re init the flag
    sum = 0;
    for (int i = mid + 2; i <= right; i++) {
      sum += array[i];
      if (sum >= 0) {
        max += sum;
        sum = 0;
      }
    }
    return max;
  }

  @lombok.Data
  public static class MaxData {

    private int max;
    private int left;
    private int right;

  }

}

