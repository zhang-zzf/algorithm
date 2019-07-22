package binary.search;

public class BinarySearchTreeImpl2<T extends Comparable<T>> extends BinarySearchTreeImpl<T>
    implements BinarySearchTree<T> {

    @Override
    public void insert(T data) {
        if (getRoot() == null) {
            setRoot(Node.build(data, null));
        } else {
            Node<T> n = getRoot();
            while (true) {
                if (n.getData().compareTo(data) >= 0) {
                    if (n.hasLeft()) {
                        n = n.getLeft();
                    } else {
                        n.setLeft(Node.build(data, n));
                        break;
                    }
                } else {
                    if (n.hasRight()) {
                        n = n.getRight();
                    } else {
                        n.setRight(Node.build(data, n));
                        break;
                    }
                }
            }
        }
    }

    @Override
    public Node<T> search(T data) {
        Node<T> n = getRoot();
        while (n != null) {
            int cmp = n.getData().compareTo(data);
            if (cmp == 0) {
                break;
            } else if (cmp > 0) {
                n = n.getLeft();
            } else {
                n = n.getRight();
            }
        }
        return n;
    }

    @Override
    public void delete(T data) {
        super.delete(data);
    }

    @Override
    public T maximum() {
        if (getRoot() == null) {
            return null;
        }
        return findMaximum(getRoot()).getData();
    }

    private Node<T> findMaximum(Node<T> node) {
        if (node == null) {
            return null;
        }
        while (node.hasRight()) {
            node = node.getRight();
        }
        return node;
    }

    @Override
    public String toString() {
        return super.toStringWithWhile();
    }

}
