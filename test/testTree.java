package test;

import tree.RedBlackTree;

public class testTree {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.add(15, 24, 33, 42, 51, 7, 8, 19);
        tree.printTree();
    }
}
