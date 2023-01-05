package tree;

import java.beans.PropertyEditorSupport;

public class RedBlackTree {
    private Node root;

    public boolean add(int... values) {
        boolean result = true;
        for (int val : values) {
            result = result && add(val);
        }
        return result;
    }

    public boolean add(int value) {
        if (root == null) {
            Node node = new Node();
            node.value = value;
            node.color = Color.BLACK;
            root = node;
            return true;
        } else {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value)
            return false;
        else {
            if (node.value > value) {
                if (node.left == null) {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                } else {
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                }
            } else {
                if (node.right == null) {
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                    return true;
                } else {
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                }
            }

        }

    }

    private Node rebalance(Node node) {
        Node temp = node;
        boolean flagRebalance;

        do {
            flagRebalance = false;

            if (temp.right != null && temp.right.color == Color.RED && (temp.left == null || temp.left.color == Color.BLACK)) {
                temp = rightRotate(temp);
                flagRebalance = true;
            }

            if (temp.left != null && temp.left.color == Color.RED && temp.left.left != null && temp.left.left.color == Color.RED) {
                temp = leftRotate(temp);
                flagRebalance = true;
            }

            if (temp.left != null && temp.left.color == Color.RED && temp.right != null && temp.right.color == Color.RED) {
                changeColor(temp);
                flagRebalance = true;
            }

        } while (flagRebalance);

        return temp;
    }

    private Node leftRotate(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;

        node.color = Color.RED;
        temp.color = Color.BLACK;

        return temp;
    }

    private Node rightRotate(Node node) {
        Node temp = node.right;
        node.right = node.right.left;
        temp.left = node;
        temp.color = Color.BLACK;
        node.color = Color.RED;
        return temp;
    }

    private void changeColor(Node node) {
        node.color = Color.RED;
        node.left.color = node.right.color = Color.BLACK;

    }

    public boolean exist(int value) {
        return findNode(root, value) != null;
    }

    private Node findNode(Node node, int value) {
        if (node == null)
            return null;
        if (node.value == value)
            return node;
        if (value < node.value)
            return findNode(node.left, value);
        else
            return findNode(node.right, value);

    }

    private class Node {
        private int value;
        private Color color;
        private Node left;
        private Node right;
    }

    private enum Color {
        RED, BLACK
    }

}
