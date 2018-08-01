import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Algorithm {

    /**
     * 阶乘
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must >= 0");
        }
        int ret = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                ret *= i;
            }
        }
        return ret;

    }

    public static List<int[]> rank(int[] array) {
        List<int[]> ret = new LinkedList<>();
        _rank(ret, Arrays.copyOf(array, array.length), 0, array.length - 1);
        return ret;
    }

    /**
     * 排列算法
     *
     * @param ret
     * @param array
     * @return
     */
    private static void _rank(List<int[]> ret, int[] array, int left, int right) {
        // 基线条件
        if (left >= right) {
            ret.add(array);
            //System.out.println(Arrays.toString(array));
            return;
        }

        for (int i = left; i <= right; i++) {
            if (i > left) {
                array = Arrays.copyOf(array, array.length);
            }
            _swap(array, left, i);
            _rank(ret, array, left + 1, right);
        }


    }

    /**
     * dual pivot quick sort Dual-Pivot快排
     *
     * @param array
     */
    public static void dualPivotQuickSort(int[] array) {
        _dualPivotQuickSort(array, 0, array.length - 1);
    }

    private static void _dualPivotQuickSort(int[] array, int left, int right) {
        if (right - left <= 0) {
            return;
        }

        // 排序核心算法
        int minPivot = Math.min(array[left], array[right]);
        int maxPivot = Math.max(array[left], array[right]);
        int minIndex = left + 1, maxIndex = right - 1, i = minIndex;
        while (i <= maxIndex) {
            if (array[i] < minPivot) {
                // 移动小值到左边
                _swap(array, minIndex++, i);
            } else if (array[i] > maxPivot) {
                while (i < maxIndex && array[maxIndex] > maxPivot) {
                    maxIndex -= 1;
                }

                // 移动大值到右边
                _swap(array, i, maxIndex--);

                // 移动后重新判断
                if (array[i] < minPivot) {
                    _swap(array, minIndex++, i);
                }
            }

            i += 1;
        }

        // 修复索引值
        minIndex -= 1;  // minIndex和左边的值都比minPivot小
        maxIndex += 1;  // maxIndex和右边的值都比maxPivot大

        // pivot 归位
        array[left] = array[minIndex];
        array[minIndex] = minPivot;
        array[right] = array[maxIndex];
        array[maxIndex] = maxPivot;


        _dualPivotQuickSort(array, left, minIndex - 1);
        _dualPivotQuickSort(array, minIndex + 1, maxIndex - 1);
        _dualPivotQuickSort(array, maxIndex + 1, right);
    }

    /**
     * 二分查找/折半查找
     *
     * @param sortedList
     * @param value
     * @return index/-1
     */
    public static int binarySearch(int[] sortedList, int value) {
        int low = 0, high = sortedList.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = sortedList[mid];
            if (value == guess) {
                return mid;
            } else if (guess < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 选择排序
     *
     * @param list
     */
    public static void selectionSort(int[] list) {
        for (int index = 0; index < list.length; index++) {
            int maxValueIndex = index;
            for (int searchIndex = index + 1; searchIndex < list.length; searchIndex++) {
                if (list[searchIndex] > list[maxValueIndex]) {
                    maxValueIndex = searchIndex;
                }
            }
            _swap(list, index, maxValueIndex);
        }
    }

    /**
     * 快速排序（递归实现）
     *
     * @param array
     */
    public static void recursionQuickSort(int[] array, int start, int end) {
        int low = start, high = end - 1;
        // 基线条件
        if (low >= high) {
            return;
        }
        int index = _partSortBest(array, low, high);
        recursionQuickSort(array, start, index);
        recursionQuickSort(array, index + 1, end);
    }

    /**
     * 快速排序算法
     *
     * @param array
     */
    public static void quickSort(int[] array, int start, int end) {
        Deque<Integer> stack = new LinkedList<>();
        int low = start, high = end - 1;
        stack.push(high);
        stack.push(low);
        while (stack.size() > 0) {
            low = stack.poll();
            high = stack.poll();
            int index = _partSortBest(array, low, high);
            if (low < index - 1) {
                stack.push(index - 1);
                stack.push(low);
            }
            if (index + 1 < high) {
                stack.push(high);
                stack.push(index + 1);
            }
        }
    }

    /**
     * 最大公约数递归实现（欧几里德算法）
     *
     * @param a
     * @param b
     * @return
     */
    public static int recursionGcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return recursionGcd(b, a % b);
    }

    /**
     * 最大公约数（欧几里德算法）
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        for (int r = a % b; r != 0; r = a % b) {
            a = b;
            b = r;
        }
        return b;
    }

    private static int _partSortBest(int[] array, int left, int right) {
        int pivotIndex = left;
        for (int i = pivotIndex + 1; i <= right; i++) {
            if (array[i] < array[left]) {
                _swap(array, ++pivotIndex, i);
            }
        }
        _swap(array, left, pivotIndex);
        return pivotIndex;
    }

    private static int _partSort(int[] array, int low, int high) {
        int index = low;
        int pivot = array[index];

        while (low < index || high > index) {
            while (low < index) {
                if (array[low] > pivot) {
                    _swap(array, low, index);
                    index = low;
                } else {
                    low += 1;
                }
            }
            while (high > index) {
                if (array[high] < pivot) {
                    _swap(array, index, high);
                    index = high;
                } else {
                    high -= 1;
                }
            }
        }
        return index;
    }

    /**
     * better than _partSort
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int _partSort2(int[] array, int left, int right) {

        int pivotIndex = right;
        int pivot = array[pivotIndex];
        while (left < right) {
            while (left < right && array[left] <= pivot) {
                left += 1;
            }
            while (left < right && array[right] >= pivot) {
                right -= 1;
            }
            _swap(array, left, right);
        }
        _swap(array, left, pivotIndex);

        return left;
    }

    private static void _swap(int[] list, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int tmp = list[index1];
        list[index1] = list[index2];
        list[index2] = tmp;
    }


}
