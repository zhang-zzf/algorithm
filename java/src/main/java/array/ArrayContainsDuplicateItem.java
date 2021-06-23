package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/23
 */
public class ArrayContainsDuplicateItem {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i< nums.length;i++) {
            boolean notContain = set.add(nums[i]);
            if (!notContain) {
                return true;
            }
        }
        return false;
    }

}
