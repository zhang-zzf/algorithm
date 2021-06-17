package search;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/17
 */
public class SecondMinimum {

    public int findSecondMinimum(int[] array) {
        int m = 0, sm = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[m]) {
                sm = m;
                m = i;
            }
            if (array[i] < array[sm]) {
                sm = i;
            }
        }
        return array[sm];
    }
}
