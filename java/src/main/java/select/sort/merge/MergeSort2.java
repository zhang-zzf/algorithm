package select.sort.merge;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhanfeng.zhang
 * @email zhanfeng.zhang@xqchuxing.com
 * @date 2018-11-29 16:31
 * @description TODO
 **/
public class MergeSort2 {

    public static void mergeSort2(int[] array) {
        if (array.length < 2) {
            return;
        }
        int[] tmp = new int[array.length];
        int left = 0, right = array.length - 1, mid = (left + right) >> 1;
        Deque<InvokeStack> stack = new LinkedList<>();
        stack.push(InvokeStack.create(left, mid, right));
        while (!stack.isEmpty()) {
            InvokeStack top = stack.peek();
            if (top.left < top.right && top.needMergeChild) {
                // left segment;
                stack.push(InvokeStack.create(top.left,
                    (top.left + top.mid) >> 1, top.mid));
                stack.push(InvokeStack.create(top.mid + 1,
                    (top.mid + 1 + top.right) >> 1, top.right));
                top.needMergeChild = false;
                continue;
            }
            stack.poll();
            merge(array, tmp, top.left, top.mid, top.right);
        }
    }

    public static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        _mergeSort(array, tmp, 0, array.length - 1);
    }

    private static void _mergeSort(int[] array, int[] tmp, int left,
        int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        _mergeSort(array, tmp, left, mid);
        _mergeSort(array, tmp, mid + 1, right);
        merge(array, tmp, left, mid, right);
    }

    private static void merge(int[] array, int[] tmp, int leftStart,
        int leftEnd, int rightEnd) {
        int i = leftStart,
            left = leftStart,
            right = leftEnd + 1;
        while (left <= leftEnd && right <= rightEnd) {
            tmp[i++] = array[left] <= array[right] ? array[left++] :
                array[right++];
        }
        while (left <= leftEnd) {
            tmp[i++] = array[left++];
        }
        while (right <= rightEnd) {
            tmp[i++] = array[right++];
        }
        System.arraycopy(tmp, leftStart, array, leftStart,
            rightEnd - leftStart + 1);
    }
}

class InvokeStack {

    int left;
    int mid;
    int right;
    boolean needMergeChild = true;

    static InvokeStack create(int left, int mid, int right) {
        InvokeStack ret = new InvokeStack();
        ret.left = left;
        ret.mid = mid;
        ret.right = right;
        return ret;
    }
}
