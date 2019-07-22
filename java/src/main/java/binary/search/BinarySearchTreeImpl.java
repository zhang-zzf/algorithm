package binary.search;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import lombok.Data;

@Data
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

    private Node<T> root;

    /**
     * 向树中插入一个元素，插入后，树依旧保持二叉搜索树的属性
     */
    public void insert(T data) {
        if (root == null) {
            Node<T> node = Node.build(data);
            setRoot(node);
        } else {
            recursiveInsert(root, data);
        }
    }

    @Override
    public void delete(T data) {
        Node<T> node = search(data);
        if (node == null) {
            return;
        }

        Node<T> n;
        if (!node.hasLeft() && !node.hasRight()) {
            // node没有左右子树
            n = null;
        } else if (node.hasLeft() && node.hasRight()) {
            // 有左子树，右子树
            // 把node的左子树挂到右子树中最小值节点的左子树上
            Node<T> minimumNode = findMinimum(node.getRight());

            Node<T> leftNode = node.getLeft();
            minimumNode.setLeft(leftNode);
            leftNode.setParent(minimumNode);

            // 然后把node的右子树替代node
            n = node.getRight();
        } else {
            // 只有左子树/只有右子树
            n = node.getLeft() == null ? node.getRight() : node.getLeft();
        }

        if (n != null) {
            n.setParent(node.getParent());
        }
        if (node.getParent() == null) {
            root = n;
        } else {
            if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(n);
            } else {
                node.getParent().setRight(n);
            }
        }
        // clear the deleted node;
        node.setLeft(null);
        node.setParent(null);
        node.setRight(null);
        node.setData(null);
    }

    private Node<T> findMinimum(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (!node.hasLeft()) {
            return node;
        } else {
            return findMinimum(node.getLeft());
        }
    }

    @Override
    public BinarySearchTree.Node<T> search(T data) {
        return recursiveSearch(root, data);
    }

    private Node<T> recursiveSearch(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (node.getData().compareTo(data) == 0) {
            return node;
        } else if (node.getData().compareTo(data) > 0) {
            return recursiveSearch(node.getLeft(), data);
        } else {
            return recursiveSearch(node.getRight(), data);
        }
    }

    @Override
    public T minimum() {
        if (root == null) {
            return null;
        }
        return recursiveMinimum(root);
    }

    private T recursiveMinimum(Node<T> node) {
        if (node.hasLeft()) {
            return recursiveMinimum(node.getLeft());
        } else {
            return node.getData();
        }
    }

    @Override
    public T maximum() {
        if (root == null) {
            return null;
        }
        return recursiveMaximum(root);
    }

    private T recursiveMaximum(Node<T> node) {
        if (node.hasRight()) {
            return recursiveMaximum(node.getRight());
        } else {
            return node.getData();
        }

    }

    @Override
    public T predecessor(T data) {
        if (root == null) {
            return null;
        }
        return recursivePredecessor(root, data);
    }

    private T recursivePredecessor(Node<T> node, T data) {
        T d = node.getData();
        // 当前node的元素比data大，去左子树中查找
        if (d.compareTo(data) >= 0) {
            if (node.hasLeft()) {
                return recursivePredecessor(node.getLeft(), data);
            } else {
                return null;
            }
        } else {
            Node<T> n = findMinimum(node.getRight());
            if (n == null) {
                return node.getData();
            } else if (n.getData().compareTo(data) >= 0) {
                return node.getData();
            } else {
                return recursivePredecessor(node.getRight(), data);
            }
        }

    }

    @Override
    public T successor(T data) {
        if (root == null) {
            return null;
        }
        return recursiveSuccessor(root, data);
    }

    @Override
    public void clear() {
        setRoot(null);
        // 更详细点可以清空树中的每个元素
    }

    private T recursiveSuccessor(Node<T> node, T data) {
        if (node.getData().compareTo(data) <= 0) {
            if (node.hasRight()) {
                return recursiveSuccessor(node.getRight(), data);
            } else {
                return null;
            }
        } else {
            // 若左子树中元素都小于等于data
            Node<T> maximumNode = findMaximum(node.getLeft());
            if (maximumNode == null) {
                return node.getData();
            } else if (maximumNode.getData().compareTo(data) <= 0) {
                return node.getData();
            } else {
                return recursiveSuccessor(node.getLeft(), data);
            }
        }
    }

    private Node<T> findMaximum(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.hasRight()) {
            return findMinimum(node.getRight());
        } else {
            return node;
        }

    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("[");
        if (root != null) {
            recursivePrint(buf, root);
            buf.delete(buf.length() - 2, buf.length());
        }
        buf.append("]");
        return buf.toString();
    }

    public String toStringBetter() {
        StringBuilder buf = new StringBuilder("[");
        recursivePrintBetter(buf, root);
        if (root != null) {
            buf.delete(buf.length() - 2, buf.length());
        }
        return buf.toString();
    }

    private void recursivePrintBetter(StringBuilder buf, Node<T> node) {
        // 基线条件
        if (node != null) {
            // 输出左子树
            recursivePrintBetter(buf, node.getLeft());
            // 输出本节点
            buf.append(node.getData()).append(", ");
            // 输出右子树
            recursivePrintBetter(buf, node.getRight());
        }
    }

    private void recursiveInsert(Node<T> root, T data) {
        if (data.compareTo(root.getData()) <= 0) {
            if (!root.hasLeft()) {
                root.setLeft(Node.build(data, root));
            } else {
                recursiveInsert(root.getLeft(), data);
            }
        } else {
            if (!root.hasRight()) {
                root.setRight(Node.build(data, root));
            } else {
                recursiveInsert(root.getRight(), data);
            }
        }
    }


    private void recursivePrint(StringBuilder buf, Node node) {
        if (node.hasLeft()) {
            recursivePrint(buf, node.getLeft());
        }
        buf.append(node.getData()).append(", ");
        if (node.hasRight()) {
            recursivePrint(buf, node.getRight());
        }
    }

    public String toStringWithWhile() {
        StringBuilder buf = new StringBuilder("[");
        Node<T> curNode = root;
        Node<T> lastDealtLeftNode = null;
        while (curNode != null) {
            if (curNode.hasLeft() && curNode.getLeft() != lastDealtLeftNode) {
                curNode = curNode.getLeft();
                continue;
            }

            buf.append(curNode.getData()).append(", ");

            if (curNode.hasRight()) {
                curNode = curNode.getRight();
                continue;
            }

            Node<T> parent = curNode.getParent();
            if (parent != null && curNode == parent.getLeft()) {
                // 当前node是父node左节点，向上回滚一层
                lastDealtLeftNode = curNode;
                curNode = parent;
                continue;
            }

            while (curNode.getParent() != null && curNode == curNode.getParent().getRight()) {
                // 右节点一直向上回滚
                curNode = curNode.getParent();
            }
            if (curNode == root) {
                break;
            } else {
                // 当前节点不是root节点且是父节点的左节点
                lastDealtLeftNode = curNode;
                curNode = curNode.getParent();
            }
        }

        if (root != null) {
            buf.delete(buf.length() - 2, buf.length());
        }
        buf.append("]");
        return buf.toString();
    }

    public String toStringWithStack() {
        StringBuilder buf = new StringBuilder("[");
        if (root != null) {
            // printWithStack(buf, root);
            printWithStack2(buf, root);
            buf.delete(buf.length() - 2, buf.length());
        }
        buf.append("]");
        return buf.toString();
    }

    // algorithm is wrong
    // algorithm is wrong
    // algorithm is wrong
    // 算法是错误的
    private void printWithStack(StringBuilder buf, Node node) {
        Deque<Node> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node peek = stack.peek();
            if (peek.hasLeft()) {
                // 存在左子树
                stack.push(peek.getLeft());
            } else {
                // 没有左子树
                buf.append(peek.getData()).append(", ");
                stack.pop(); // 弹出栈顶元素
                if (peek.hasRight()) {
                    stack.push(peek.getRight());
                }
            }
        }
    }

    private void printWithStack2(StringBuilder buf, Node node) {
        Deque<Node> stack = new LinkedList<>();
        stack.push(node);
        while (true) {
            Node peek = stack.peek();
            if (peek.hasLeft()) {
                stack.push(peek.getLeft());
            } else {
                break;
            }
        }
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            buf.append(pop.getData()).append(", ");
            if (pop.hasRight()) {
                Node right = pop.getRight();
                stack.push(right);
                while (true) {
                    Node peek = stack.peek();
                    if (peek.hasLeft()) {
                        stack.push(peek.getLeft());
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
