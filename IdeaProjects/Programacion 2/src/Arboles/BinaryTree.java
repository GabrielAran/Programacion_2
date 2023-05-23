package Arboles;

public class BinaryTree implements IBinaryTree{
    private BinaryTreeNode root; // creo el nodo raiz, (inicial).

    public void create(int value) {
        this.root = new BinaryTreeNode(value, null, null); // constructor para crear nodo raiz
    }

    public Integer getValueRoot() { // DEVUELVE LA RAIZ
        if(this.root == null) {
            throw new RuntimeException("The tree is empty"); // si root es null, el tree esta vacio
        }
        return this.root.getValue();
    }

    public boolean isEmpty() { // esta vacio?
        return this.root == null;
    }

    public void addLeft(int value) { // añade hijo a la izquierda
        if(this.root == null) {
            throw new RuntimeException("The tree is empty"); // si root es null, el tree esta vacio
        }
        BinaryTree tree = new BinaryTree();
        tree.create(value); // al añadir un hijo estas creando otro arbol, y la raiz es el value \\ crea un arbol
        this.root.setLeft(tree); // setea el arbol nuevo como hijo izquierdo
    }

    public void addRight(int value) { // añade hijo a la derecha
        if(this.root == null) {
            throw new RuntimeException("The tree is empty"); // si root es null, el tree esta vacio
        }
        BinaryTree tree = new BinaryTree();
        tree.create(value); // al añadir un hijo estas creando otro arbol, y la raiz es el value \\ crea un arbol
        this.root.setRight(tree); // setea el arbol nuevo como hijo derecho
    }

    public void removeLeft() { // setea al hijo izquierdo como null
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setLeft(null);
    }

    public void removeRight() { // setea al hijo derecho como null
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setRight(null);
    }

    public IBinaryTree getLeft() { // devuelve el hijo izquierdo
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getLeft(); // getLeft(): metodo del nodo
    }

    public IBinaryTree getRight() { // devuelve el hijo derecho
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getRight(); // getRight(): metodo del nodo
    }
}
