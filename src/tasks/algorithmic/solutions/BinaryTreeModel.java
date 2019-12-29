package net.sahet.demo.intw;

import java.util.Objects;
import java.util.Optional;

public class BinaryTreeModel {
    private Object value;
    private BinaryTreeModel left;
    private BinaryTreeModel right;

    public BinaryTreeModel(Object value) {
        this.value = value;
    }

    //https://www.baeldung.com/java-print-binary-tree-diagram
    public static void main(String[] args) {
        BinaryTreeModel root = new BinaryTreeModel("root");

        BinaryTreeModel node1 = new BinaryTreeModel("node1");
        BinaryTreeModel node2 = new BinaryTreeModel("node2");
        root.setLeft(node1);
        root.setRight(node2);

        BinaryTreeModel node3 = new BinaryTreeModel("node3");
        BinaryTreeModel node4 = new BinaryTreeModel("node4");
        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(new BinaryTreeModel("node5"));
        node2.setRight(new BinaryTreeModel("node6"));

        BinaryTreeModel node7 = new BinaryTreeModel("node7");
        node3.setLeft(node7);
        node7.setLeft(new BinaryTreeModel("node8"));
        node7.setRight(new BinaryTreeModel("node9"));
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public BinaryTreeModel getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeModel left) {
        this.left = left;
    }

    public BinaryTreeModel getRight() {
        return right;
    }

    public void setRight(BinaryTreeModel right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return ""; // + Optional<Object>toString(val);
    }
}
