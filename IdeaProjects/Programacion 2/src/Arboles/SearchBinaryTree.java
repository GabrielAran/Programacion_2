package Arboles;

public class SearchBinaryTree implements ISearchBinaryTree {
    private final IBinaryTree binaryTree;

    public SearchBinaryTree() { // constructor
        this.binaryTree = new BinaryTree();
    }

    private SearchBinaryTree(IBinaryTree binaryTree) { // constructor con arbolito
        this.binaryTree = binaryTree;
    }

    @Override
    public int getRoot() { // devulve la root del tree
        if (this.isEmpty()) {
            System.out.println("SearchBinaryTree is not initialized");
            return -1;
        }
        return this.binaryTree.getValueRoot();
    }

    @Override
    public boolean isEmpty() {
        return this.binaryTree == null || this.binaryTree.isEmpty();
    }

    @Override
    public void add(int element) { // agrega elemento pero hay que ver donde ira, (menor = izq) (mayor = der)
        if (binaryTree.isEmpty()) { // si no hay arbol:
            binaryTree.create(element); // lo crea.
            return; // element sera la root
        }
        if (element > binaryTree.getValueRoot()) { // si el elemento es > root va a la derecha
            if (binaryTree.getRight() == null) { // mientras q la derecha sea null obvio
                binaryTree.addRight(element); // sino seguira para la derecha
                return;
            }
            SearchBinaryTree searchBinaryTree = new SearchBinaryTree(binaryTree.getRight()); // si ya habia arbol a --->
            // ---> la derecha lo agarra en searchBinaryTree
            searchBinaryTree.add(element); // agrega el elemento en el arbol con recursividad
            return; // cuando le pase x recursividad, se le pasa un arbol mas chico que el original
            // cada hijo del arbol termina siendo otro arbol wow (:
        }

        // MISMO CASO PARA LA IZQUIERDA, PERO COMO LA IZQUIERDA ES DE ZURDO NO LO EXPLICO COMO RECIEN
        if (binaryTree.getLeft() == null) {
            binaryTree.addLeft(element);
            return;
        }
        SearchBinaryTree searchBinaryTree = new SearchBinaryTree(binaryTree.getLeft());
        searchBinaryTree.add(element);
    }

    @Override
    public void removeLeft() {
        this.binaryTree.removeLeft();
    }

    @Override
    public void removeRight() {
        this.binaryTree.removeRight();
    }

    @Override
    public ISearchBinaryTree getLeft() {
        try { // el try es x si no hay asi no te comes un error
            SearchBinaryTree candidate = new SearchBinaryTree(this.binaryTree.getLeft()); // trata de agarrar el de la izq
            if (candidate.isEmpty()) {
                return null; // si no hay left retorna null
            }
            return candidate; // si hay left lo retorna
        } catch (RuntimeException e) { // si el try no funciona, entra aca y tira el error de que fallo el try
            throw new RuntimeException("The search binary tree is empty");
        }
    }

    @Override
    public ISearchBinaryTree getRight() {
        try { // el try es x si no hay asi no te comes un error
            SearchBinaryTree candidate = new SearchBinaryTree(this.binaryTree.getRight()); // trata de agarrar el de la izq
            if (candidate.isEmpty()) {
                return null;
            }
            return candidate; // si hay left lo retorna
        } catch (RuntimeException e) { // si el try no funciona, entra aca y tira el error de que fallo el try
            throw new RuntimeException("The search binary tree is empty");
        }
    }

}