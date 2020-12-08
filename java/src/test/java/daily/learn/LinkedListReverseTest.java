package daily.learn;

import data.structure.LinkedList;
import org.junit.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class LinkedListReverseTest {

    @Test
    public void reverse() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        then(list).containsExactly("d", "c", "b", "a");
        LinkedListReverse.reverse(list);
        then(list).containsExactly("a", "b", "c", "d");
    }
}