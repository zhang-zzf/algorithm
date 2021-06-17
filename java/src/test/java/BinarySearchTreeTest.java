import static org.junit.Assert.*;

import base.Algorithm;
import binary.search.BinarySearchTree;
import binary.search.BinarySearchTree.Node;
import binary.search.BinarySearchTreeImpl;
import binary.search.BinarySearchTreeImpl2;
import binary.search.BinarySearchTreeImpl3;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> t;

    @Before
    public void init() {
//        t = new BinarySearchTreeImpl<>();
//        t = new BinarySearchTreeImpl2<>();
        t = new BinarySearchTreeImpl3<>();
    }

    @Test
    public void testEmptyTree() {
        assertEquals(null, t.maximum());
        assertEquals(null, t.minimum());
        assertEquals(null, t.search(1));
        assertEquals(null, t.predecessor(1));
        assertEquals(null, t.successor(1));
        assertEquals("[]", t.toString());
        t.delete(1);
    }

    @Test
    public void testOneElementTree() {
        Integer ele = new Integer(1);
        t.insert(ele);
        assertEquals("[1]", t.toString());
        assertEquals(ele, t.maximum());
        assertEquals(ele, t.minimum());
        assertEquals(null, t.predecessor(1));
        assertEquals(null, t.successor(1));
        assertEquals(ele, t.predecessor(2));
        assertEquals(ele, t.successor(0));
        assertEquals(ele, t.search(ele).getData());
        t.delete(ele);
        assertEquals("[]", t.toString());
    }

    @Test
    public void testNElementTree() {
        t.insert(5);
        t.insert(8);
        t.insert(1);
        t.insert(3);
        t.insert(6);
        assertEquals("[1, 3, 5, 6, 8]", t.toString());
        assertEquals(8, t.maximum().intValue());
        assertEquals(1, t.minimum().intValue());
        assertEquals(3, t.predecessor(5).intValue());
        assertEquals(null, t.predecessor(1));
        assertEquals(5, t.predecessor(6).intValue());

        assertEquals(null, t.search(7));
        assertEquals(5, t.search(5).getData().intValue());

        t.delete(2);
        assertEquals("[1, 3, 5, 6, 8]", t.toString());

        t.delete(5);
        assertEquals("[1, 3, 6, 8]", t.toString());

        t.delete(1);
        t.delete(3);
        t.delete(8);
        assertEquals("[6]", t.toString());

        t.delete(6);
        assertEquals("[]", t.toString());
    }


    @Test
    public void testToString() {
        assertEquals("[]", t.toString());
        t.insert(18);
        assertEquals("[18]", t.toString());
        t.clear();

        int[] origin = {18, 1, 5, 6, 100, -88, 3, 2, 4};
        String toString = "[-88, 1, 2, 3, 4, 5, 6, 18, 100]";

        for (int[] array : Algorithm.rank(origin)) {
            List<Integer> list = arrayToList(array);
            t.addAll(list);
            assertEquals(toString, t.toString());
            t.clear();
        }
    }

    @Test
    public void testPredecessorNodeAndSuccessorNode() {
        assertEquals(null, t.predecessorNode(null));
        assertEquals(null, t.successorNode(null));

        // one element
        t.insert(5);
        Node<Integer> result = t.search(5);
        assertEquals(5, result.getData().intValue());
        assertEquals(null, t.predecessorNode(result));
        assertEquals(null, t.successorNode(result));

        t.insert(4);
        t.insert(100);
        assertEquals(4, t.predecessorNode(result).getData().intValue());
        assertEquals(100, t.successorNode(result).getData().intValue());

        assertEquals(null, t.predecessorNode(t.search(4)));
        assertEquals(null, t.successorNode(t.search(100)));

        t.clear();
        // 测试普遍性
        int[] origin = {18, 1, 5, 6, 100, -88, 3, 2, 4};
        for (int[] array : Algorithm.rank(origin)) {
            t.addAll(arrayToList(array));
            assertEquals(null, t.predecessorNode(t.search(-88)));
            assertEquals(null, t.successorNode(t.search(100)));
            assertEquals(4, t.predecessorNode(t.search(5)).getData().intValue());
            assertEquals(6, t.successorNode(t.search(5)).getData().intValue());
            t.clear();
        }
    }

    private List<Integer> arrayToList(int[] array) {
        List<Integer> ret = new ArrayList<>(array.length);
        for (int i : array) {
            ret.add(i);
        }
        return ret;
    }

    @Test
    public void testDelete() {

        String s1 = "[-88, 1, 2, 3, 4, 5, 6, 18, 100]";
        String s2 = "[1, 2, 3, 4, 5, 6, 18, 100]";
        String s3 = "[2, 3, 4, 5, 6, 18, 100]";
        String s4 = "[3, 4, 5, 6, 18, 100]";
        String s5 = "[4, 5, 6, 18, 100]";
        String s6 = "[5, 6, 18, 100]";
        String s7 = "[6, 18, 100]";
        String s8 = "[18, 100]";
        String s9 = "[100]";
        String s0 = "[]";
        // 测试普遍性
        int[] origin = {18, 1, 5, 6, 100, -88, 3, 2, 4};
//            int[] array = origin;
        for (int[] array : Algorithm.rank(origin)) {
            t.addAll(arrayToList(array));
            assertEquals(s1, t.toString());

            t.delete(-88);
            assertEquals(s2, t.toString());

            t.delete(1);
            assertEquals(s3, t.toString());

            t.delete(2);
            assertEquals(s4, t.toString());

            t.delete(3);
            assertEquals(s5, t.toString());

            t.delete(4);
            assertEquals(s6, t.toString());

            t.delete(5);
            assertEquals(s7, t.toString());

            t.delete(6);
            assertEquals(s8, t.toString());

            t.delete(18);
            assertEquals(s9, t.toString());

            t.delete(100);
            assertEquals(s0, t.toString());
            t.clear();
        }
    }
}
