package array;

import org.junit.Test;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/23
 */
public class ArrayRotateKTest {

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        new ArrayRotateK().rotate(array, 3);
        then(array).containsExactly(5, 6, 7, 1, 2, 3, 4);
    }

}