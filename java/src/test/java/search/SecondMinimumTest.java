package search;

import base.Algorithm;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.*;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/17
 */
public class SecondMinimumTest {

    @Test
    public void test() {
        int[] a = {1, 5, 10, 100, -5, -100, 88};
        final List<int[]> rank = Algorithm.rank(a);
        for (int[] array : rank) {
            final int secondMinimum = new SecondMinimum().findSecondMinimum(array);
            then(secondMinimum).isEqualTo(-5);
        }
    }

    @Test
    public void test2() {
        int[] a = {1, 5, 10, 100, -5, -100, 88};
        final List<int[]> rank = Algorithm.rank(a);
        for (int[] array : rank) {
            final int secondMinimum = new SecondMinimum().findSecondMinimum1(array);
            then(secondMinimum).isEqualTo(-100);
        }
    }



}