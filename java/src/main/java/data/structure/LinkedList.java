package data.structure;

import lombok.Getter;
import lombok.Setter;

import java.util.AbstractList;
import java.util.List;

public class LinkedList<T> extends AbstractList<T> implements List<T> {

    @Getter
    @Setter
    private Node<T> head;
    private int size;

    @Override
    public boolean add(T t) {
        Node<T> n = new Node<>(t, head);
        this.head = n;
        size += 1;
        return true;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return cur.getV();
    }

    @Override
    public int size() {
        return size;
    }

}
