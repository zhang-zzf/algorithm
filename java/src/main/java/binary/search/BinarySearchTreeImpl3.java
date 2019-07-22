package binary.search;

/**
 * 提供优化版插入算法
 */
public class BinarySearchTreeImpl3<T extends Comparable<T>> extends
    BinarySearchTreeImpl<T> implements BinarySearchTree<T> {

    /**
     * 代码更紧凑，更简洁
     *
     * @param data 需要插入的数据
     */
    @Override
    public void insert(T data) {
        Node<T> x = getRoot(), y = null;
        while (x != null) {
            y = x;
            if (x.getData().compareTo(data) >= 0) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        Node<T> n = Node.build(data, y);
        if (y == null) {
            setRoot(n);
        } else if (y.getData().compareTo(data) >= 0) {
            y.setLeft(n);
        } else {
            y.setRight(n);
        }
    }

    @Override
    public void delete(T data) {
        Node<T> node = search(data);
        if (node == null) {
            return;
        }
        if (!node.hasRight()) {
            // 右子树为空
            // node的左子树替换node
            nodeTransplant(node, node.getLeft());
        } else if (!node.hasLeft()) {
            nodeTransplant(node, node.getRight());
        } else {
            // 找到右子树中的最小值
            Node<T> y = minimum(node.getRight());
            if (y.getParent() != node) {
                // 平衡树
                nodeTransplant(y, y.getRight());
                y.setRight(node.getRight());
                node.getRight().setParent(y);
            }
            // node的左节点 -> y的左节点
            y.setLeft(node.getLeft());
            node.getLeft().setParent(y);

            // y 替代 node
            nodeTransplant(node, y);
        }
    }

    private void nodeTransplant(Node<T> u, Node<T> v) {
        if (u.getParent() == null) {
            setRoot(v);
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }

        if (v != null) {
            //先 clear v父节点的向下指针
            if (v.getParent() == null) {
            } else if (v == v.getParent().getLeft()) {
                v.getParent().setLeft(null);
            } else {
                v.getParent().setRight(null);
            }
            v.setParent(u.getParent());
        }
        // clear
        u.setParent(null);
    }
}
