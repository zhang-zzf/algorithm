package search;

import base.Algorithm;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/18
 */
public class MedianTest {

    @Test
    public void test() {
        int[] a = {1, 5, 10, 100, -5, -100, 88};
        final List<int[]> rank = Algorithm.rank(a);
        for (int[] array : rank) {
            then(new Median().findMedian(array, 1)).isEqualTo(-5);
            then(new Median().findMedian(array, 0)).isEqualTo(-100);
            then(new Median().findMedian(array, 5)).isEqualTo(88);
            then(new Median().findMedian(array, 6)).isEqualTo(100);
        }
    }

    @Test
    public void test2() {
        int[] a = {1, 5, 10, 100, -5, -100, 88};
        final List<int[]> rank = Algorithm.rank(a);
        for (int[] array : rank) {
            then(new Median().findMedianIterative(array, 1)).isEqualTo(-5);
            then(new Median().findMedianIterative(array, 0)).isEqualTo(-100);
            then(new Median().findMedianIterative(array, 5)).isEqualTo(88);
            then(new Median().findMedianIterative(array, 6)).isEqualTo(100);
        }
    }




}