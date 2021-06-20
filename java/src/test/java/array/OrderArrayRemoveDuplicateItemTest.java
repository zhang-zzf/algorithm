package array;

import org.junit.Test;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/20
 */
public class OrderArrayRemoveDuplicateItemTest {

    @Test
    public void test() {
        final OrderArrayRemoveDuplicateItem service = new OrderArrayRemoveDuplicateItem();
        then(service.remove(new int[]{1, 2, 2, 3, 4, 5, 5, 5, 7, 8})).isEqualTo(7);
        then(service.remove(new int[]{1})).isEqualTo(1);
        then(service.remove(new int[]{1, 2, 3})).isEqualTo(3);
        then(service.remove(new int[]{1, 1, 1, 2, 3})).isEqualTo(3);
    }

}