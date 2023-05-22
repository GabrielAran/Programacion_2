package Arboles;

public class BinaryTree {
    private NodeTree root;

    public void create(int value) {
        this.root = new NodeTree(value, null, null);
    }

    public int getValue() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getValue();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void addLeft(int value) {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTreeStatic binaryTreeStatic = new BinaryTreeStatic();
        binaryTreeStatic.create(value);
        this.root.setLeft(binaryTreeStatic);
    }

    public void addRight(int value) {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTreeStatic binaryTreeStatic = new BinaryTreeStatic();
        binaryTreeStatic.create(value);
        this.root.setRight(binaryTreeStatic);
    }

    public void removeLeft() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setLeft(null);
    }

    public void removeRight() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setRight(null);
    }

    public BinaryTreeStatic getLeft() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getLeft();
    }

    public BinaryTreeStatic getRight() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getRight();
    }
}
