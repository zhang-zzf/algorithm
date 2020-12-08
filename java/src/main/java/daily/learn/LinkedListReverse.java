package daily.learn;

import data.structure.LinkedList;
import data.structure.Node;

/**
 * 单链表反转
 */
public class LinkedListReverse {

    public static <T> void reverse(LinkedList<T> list) {
        Node<T> cur = list.getHead(),
            prev = null;
        while (cur != null) {
            Node<T> next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        list.setHead(prev);
    }


}
