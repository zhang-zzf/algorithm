package search;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/17
 */
public class Median {


    /**
     * 找出数组中第 k 小的数
     *
     * @param array 数组
     * @param k     序号
     * @return 第 k 小的数
     */
    public int findMedian(int[] array, int k) {
        return findRecurse(array, 0, array.length - 1, k);
    }

    private int findRecurse(int[] array, int left, int right, int k) {
        int pivotIndex = partition(array, left, right);
        if (pivotIndex == k) {
            return array[pivotIndex];
        } else if (pivotIndex < k) {
            // 从右边找
            return findRecurse(array, pivotIndex + 1, right, k);
        } else {
            return findRecurse(array, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[] array, int left, int right) {
        int min = left - 1;
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]) {
                swap(array, ++min, i);
            }
        }
        int pivotIndex = min + 1;
        swap(array, pivotIndex, right);
        return pivotIndex;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}

