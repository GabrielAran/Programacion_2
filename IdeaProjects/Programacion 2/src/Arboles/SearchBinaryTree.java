package Arboles;
public class SearchBinaryTree implements ISearchBinaryTree {

    private final BinaryTreeStatic binaryTreeStatic;

    public SearchBinaryTree() {
        this.binaryTreeStatic = new BinaryTreeStatic();
    }

    private SearchBinaryTree(BinaryTreeStatic binaryTreeStatic) {
        this.binaryTreeStatic = binaryTreeStatic;
    }

    @Override
    public int getValue() {
        if (this.isEmpty()) {
            System.out.println("SearchBinaryTree is not initialized");
            return -1;
        }
        return this.binaryTreeStatic.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.binaryTreeStatic == null || this.binaryTreeStatic.isEmpty();
    }

    @Override
    public void add(int element) {
        if (binaryTreeStatic.isEmpty()) {
            binaryTreeStatic.create(element);
            return;
        }
        if (element > binaryTreeStatic.getValue()) {
            if (binaryTreeStatic.getRight() == null) {
                binaryTreeStatic.addRight(element);
                return;
            }
            SearchBinaryTree searchBinaryTree = new SearchBinaryTree(binaryTreeStatic.getRight());
            searchBinaryTree.add(element);
            return;
        }

        if (binaryTreeStatic.getLeft() == null) {
            binaryTreeStatic.addLeft(element);
            return;
        }
        SearchBinaryTree searchBinaryTree = new SearchBinaryTree(binaryTreeStatic.getLeft());
        searchBinaryTree.add(element);
    }

    @Override
    public void removeLeft() {
        this.binaryTreeStatic.removeLeft();
    }

    @Override
    public void removeRight() {
        this.binaryTreeStatic.removeRight();
    }

    @Override
    public ISearchBinaryTree getLeft() {
        try {
            SearchBinaryTree candidate = new SearchBinaryTree(this.binaryTreeStatic.getLeft());
            if (candidate.isEmpty()) {
                return null;
            }
            return candidate;
        } catch (RuntimeException e) {
            throw new RuntimeException("The search binary tree is empty");
        }
    }

    @Override
    public ISearchBinaryTree getRight() {
        try {
            SearchBinaryTree candidate = new SearchBinaryTree(this.binaryTreeStatic.getRight());
            if (candidate.isEmpty()) {
                return null;
            }
            return candidate;
        } catch (RuntimeException e) {
            throw new RuntimeException("The search binary tree is empty");
        }
    }

}
