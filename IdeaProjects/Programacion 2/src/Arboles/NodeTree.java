package Arboles;

public class NodeTree {
    private int value;
    private BinaryTreeStatic left;
    private BinaryTreeStatic right;

    public NodeTree(int value, BinaryTreeStatic left, BinaryTreeStatic right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeStatic getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeStatic left) {
        this.left = left;
    }

    public BinaryTreeStatic getRight() {
        return right;
    }

    public void setRight(BinaryTreeStatic right) {
        this.right = right;
    }
}
