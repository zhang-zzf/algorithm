package data.structure;

import lombok.Getter;

/**
 * @author zhanfeng.zhang
 * 单链表表节点
 */
public class Node<T> {

    @Getter
    private T v;
    private Node<T> next;

    public Node(T value) {
        this(value, null);
    }

    public Node(T value, Node<T> next) {
        this.v = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return v.toString();
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
