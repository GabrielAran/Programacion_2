package Arboles;

public class BinaryTreeStatic implements IBinaryTree {

    private final Integer[] array; // array donde se guardan los valores del BTree
    private final int rootIndex; // pos de la raiz
    private final int MAX_CAPACITY = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 - 1;

    // TENER EN CUENTA QUE UN ARBOL BINARIO ESTA FORMADO POR ARBOLES BINARIOS XD

    public BinaryTreeStatic() {
        this.array = new Integer[MAX_CAPACITY];
        this.rootIndex = 0;
    }

    private BinaryTreeStatic(Integer[] array, int rootIndex) { // constructor
        this.array = array;
        this.rootIndex = rootIndex;
    }

    @Override
    public void create(int value) {
        this.array[rootIndex] = value; // pone el value en la pos del root
        for (int i = 1; i < this.array.length; i++) {
            this.array[i] = null; // va al final del array y pone un null ¿¿¿porqué???
        }
    }

    @Override
    public Integer getValueRoot() { // DEVUELVE LA RAIZ DEL ARBOL
        return this.array[rootIndex];
    }

    @Override
    public boolean isEmpty() {
        return this.array[rootIndex] == null; // si la raiz es null entonces el arbol esta vacio
    }

    @Override
    public void addLeft(int value) {
        if (rootIndex * 2 + 1 > MAX_CAPACITY) {
            throw new RuntimeException("Excedida la altura del arbol");
        }
        this.array[rootIndex * 2 + 1] = value;
        clean((rootIndex * 2 + 1) * 2 + 1);
        clean((rootIndex * 2 + 1) * 2 + 2);
    }

    @Override
    public void addRight(int value) {
        if (rootIndex * 2 + 2 > MAX_CAPACITY) {
            throw new RuntimeException("Excedida la altura del arbol");
        }
        this.array[rootIndex * 2 + 2] = value;
        clean((rootIndex * 2 + 2) * 2 + 1);
        clean((rootIndex * 2 + 2) * 2 + 2);
    }

    @Override
    public void removeLeft() {
        clean(rootIndex * 2 + 1);
    }

    @Override
    public void removeRight() {
        clean(rootIndex * 2 + 2);
    }

    @Override
    public BinaryTreeStatic getLeft() {
        if (rootIndex * 2 + 1 > MAX_CAPACITY) {
            return null;
        }
        BinaryTreeStatic candidate = new BinaryTreeStatic(this.array, rootIndex * 2 + 1);
        if (candidate.isEmpty()) {
            return null;
        }
        return candidate;
    }

    @Override
    public BinaryTreeStatic getRight() {
        if (rootIndex * 2 + 2 > MAX_CAPACITY) {
            return null;
        }
        BinaryTreeStatic candidate = new BinaryTreeStatic(this.array, rootIndex * 2 + 2);
        if (candidate.isEmpty()) {
            return null;
        }
        return candidate;
    }

    private void clean(int index) {
        if (index >= this.array.length) {
            return;
        }
        this.array[index] = null;
        clean(index * 2 + 1);
        clean(index * 2 + 2);
    }
}
