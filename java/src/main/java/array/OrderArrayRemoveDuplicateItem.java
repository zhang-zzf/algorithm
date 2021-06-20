package array;

import static base.Algorithm._swap;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/20
 */
public class OrderArrayRemoveDuplicateItem {

    public int remove(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[j]) {
                _swap(array, ++j, i);
            }
        }
        return j + 1;
    }

}
