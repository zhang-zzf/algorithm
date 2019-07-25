public class RandomizedSelect {

    public static int select(int[] array, int k) {
        if (k < 0 || k >= array.length) {
            throw new IllegalArgumentException();
        }
        return _select(array, 0, array.length - 1, k);
    }

    private static int _select(int[] array, int left, int right, int k) {
        int pivotIdx = partition(array, left, right);
        if (pivotIdx == k) {
            return array[k];
        } else if (pivotIdx > k) {
            return _select(array, left, pivotIdx - 1, k);
        } else {
            //return _select(array, pivotIdx + 1, right, k - (pivotIdx + 1));
            //partition 返回的partition是数组中的全局索引
            return _select(array, pivotIdx + 1, right, k);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int j = left - 1;
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]) {
                _swap(array, i, ++j);
            }
        }
        _swap(array, ++j, right);

        return j;
    }

    private static void _swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
