package binary.search;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public interface BinarySearchTree<T extends Comparable<T>> {

    /**
     * 以一个列表构建一颗二叉搜索树
     */
    default void addAll(List<T> dataList) {
        for (T data : dataList) {
            this.insert(data);
        }
    }

    /**
     * 获取node节点的前序节点
     *
     * @param node 参照节点，不能为null
     * @return 前序节点；null-参照节点无前序节点
     */
    default Node<T> predecessorNode(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.hasLeft()) {
            // 存在左子树
            return maximum(node.getLeft());
        } else {
            // 向上找出比当前节点小的元素
            Node<T> x = node, y = node.getParent();
            while (y != null && x == y.getLeft()) {
                x = y;
                y = y.getParent();
            }
            return y;
        }
    }

    default Node<T> successorNode(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.hasRight()) {
            // 右子树中的最小值
            return minimum(node.getRight());
        } else {
            Node<T> x = node, y = x.getParent();
            while (y != null && x == y.getRight()) {
                x = y;
                y = y.getParent();
            }
            return y;
        }
    }

    /**
     * 最小节点
     */
    default Node<T> minimum(Node<T> root) {
        Node<T> min = root;
        while (min.hasLeft()) {
            min = min.getLeft();
        }
        return min;
    }

    /**
     * 最大节点
     */
    default Node<T> maximum(Node<T> root) {
        Node<T> max = root;
        while (max.hasRight()) {
            max = max.getRight();
        }
        return max;
    }


    /**
     * 插入数据，完成插入后依旧是一颗二分搜索树
     *
     * @param data 需要插入的数据
     */
    void insert(T data);

    /**
     * 删除数据，操作完成后依旧是一颗二叉搜索树
     * <p>存在data删除；不存在，什么都不做</p>
     */
    void delete(T data);

    /**
     * 按中序输出二分搜索树
     * <p>自然排序</p>
     *
     * @return 二叉搜索树的中序输出
     */
    @Override
    String toString();

    /**
     * 搜索二叉树
     *
     * @param data 搜索的数据
     * @return 包含与data相同数据的Node；null-树中不存在data数据
     */
    Node<T> search(T data);

    /**
     * 树中的最小值
     *
     * @return 树中的最小值
     */
    T minimum();

    /**
     * 树中的最大值
     *
     * @return 树中的最大值
     */
    T maximum();

    /**
     * 先驱
     */
    T predecessor(T data);


    /**
     * 后序
     */
    T successor(T data);

    /**
     * 清空
     */
    void clear();


    @Getter
    @Setter
    class Node<T> {

        private Node<T> parent;
        private T data;
        private Node<T> left;
        private Node<T> right;

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }

        public boolean hasParent() {
            return parent != null;
        }

        public static <T extends Comparable<T>> Node<T> build(T data) {
            return build(data, null);
        }

        public static <T extends Comparable<T>> Node<T> build(T data, Node<T> parent) {
            Node n = new Node();
            n.setData(data);
            n.setParent(parent);
            return n;

        }

        public String toString() {
            return data.toString();
        }

    }
}
