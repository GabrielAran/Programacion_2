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
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(value);
        this.root.setLeft(binaryTree);
    }

    public void addRight(int value) {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(value);
        this.root.setRight(binaryTree);
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

    public BinaryTree getLeft() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getLeft();
    }

    public BinaryTree getRight() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getRight();
    }
}
