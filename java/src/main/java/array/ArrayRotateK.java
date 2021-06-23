package array;

/**
 * @author zhanfeng.zhang
 * @date 2021/06/23
 */
public class ArrayRotateK {

    public void rotate(int[] nums, int k) {
        int idx = 0;
        int cur = nums[idx];
        for (int i = 0; i < nums.length; i++) {
            int nidx = (idx + k) % nums.length;
            int next = nums[nidx];
            nums[nidx] = cur;
            cur = next;
            idx = nidx;
        }
    }
}
