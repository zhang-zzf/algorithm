package array;

import org.junit.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.*;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/23
 */
public class ArrayContainsDuplicateItemTest {

    @Test
    public void test() {
        final ArrayContainsDuplicateItem service = new ArrayContainsDuplicateItem();
        then(service.containsDuplicate(new int[]{1, 2, 3, 1})).isTrue();
        then(service.containsDuplicate(new int[]{2, 3, 1})).isFalse();
    }

}