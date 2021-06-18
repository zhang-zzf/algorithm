package search;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/17
 */
public class SecondMinimum {

    /**
     * 正确的算法
     *
     * @param array
     * @return
     */
    public int findSecondMinimum(int[] array) {
        int m = Integer.MAX_VALUE, sm = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < m) {
                sm = m;
                m = array[i];
            } else if (array[i] < sm) {
                sm = array[i];
            }
        }
        return sm;
    }

    /**
     * 错误的算法
     *
     * @param array
     * @return
     */
    public int findSecondMinimum1(int[] array) {
        int m = 0, sm = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[m]) {
                sm = m;
                m = i;
            }
            // 如果 array[i] < 最小值了，那么 array[i] < array[sm] 也一定成立
            // 最终 sm 指向的是最小值
            if (array[i] < array[sm]) {
                sm = i;
            }
        }
        return array[sm];
    }

    /**
     * 错误的算法
     *
     * @param array
     * @return
     */
    public int findSecondMinimum2(int[] array) {
        int m = 0, sm = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[m]) {
                sm = m;
                m = i;
            } else if (array[i] < array[sm]) {
                sm = i;
            }
        }
        return array[sm];
    }

}

