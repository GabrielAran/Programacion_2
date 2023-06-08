package Parcial_Aran;

public class BinaryTreeParcial implements IBinaryTreeParcial {
    private BinaryTreeNodeParcial root;

    public void create(int value) {
        this.root = new BinaryTreeNodeParcial(value, null, null);
    }

    public Integer getValueRoot() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getValue();
    }

    public boolean isEmpty() { // esta vacio?
        return this.root == null;
    }

    public void addLeft(int value) {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTreeParcial tree = new BinaryTreeParcial();
        tree.create(value);
        this.root.setLeft(tree);
    }

    public void addRight(int value) {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTreeParcial tree = new BinaryTreeParcial();
        tree.create(value);
        this.root.setRight(tree);
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

    public IBinaryTreeParcial getLeft() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getLeft();
    }

    public IBinaryTreeParcial getRight() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getRight();
    }

    public IBinaryTreeParcial subTree(int n){ // EJERCICIO 1.A
        IBinaryTreeParcial arbol = new BinaryTreeParcial();
        arbol = agarrarCopiaArbol(arbol); // copy del arbol
        IBinaryTreeParcial subarbol = buscarHeight(arbol, n);
        int altura = height(arbol);

        if (n < altura){
            return subarbol;
        } else if (n == altura){ // el root solo? (lo veo dudoso)
            arbol.removeRight();
            arbol.removeLeft();
            return arbol;
        } else {
            return arbol;
        }
    }

    public IBinaryTreeParcial buscarHeight(IBinaryTreeParcial arboles, int n){
        if (arboles != null) {
            if (height(arboles) == n) {
                return arboles;
            }
            buscarHeight(arboles.getLeft(), n);
            buscarHeight(arboles.getRight(), n);
        }
        return arboles;
    }
    public IBinaryTreeParcial agarrarCopiaArbol(IBinaryTreeParcial a) {
        if (this.root != null && a.getValueRoot() == null){
            a.create(this.root.getValue());
        }
        if (this.root.getLeft() != null){
            a.addLeft(this.root.getLeft().getValueRoot());
            return agarrarCopiaArbol(this.root.getLeft());
        }
        if (this.root.getRight() != null){
            a.addRight(this.root.getRight().getValueRoot());
            return agarrarCopiaArbol(this.root.getRight());
        }
        return a;
    }

    public static int height(IBinaryTreeParcial binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }
}
