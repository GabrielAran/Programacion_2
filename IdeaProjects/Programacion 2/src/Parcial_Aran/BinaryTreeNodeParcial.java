package Parcial_Aran;

public class BinaryTreeNodeParcial {
    private int value;
    private IBinaryTreeParcial left;
    private IBinaryTreeParcial right;

    public BinaryTreeNodeParcial(int value, IBinaryTreeParcial left, IBinaryTreeParcial right) {
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

    public IBinaryTreeParcial getLeft() {
        return left;
    }

    public void setLeft(IBinaryTreeParcial left) {
        this.left = left;
    }

    public IBinaryTreeParcial getRight() {
        return right;
    }

    public void setRight(IBinaryTreeParcial right) {
        this.right = right;
    }
}
