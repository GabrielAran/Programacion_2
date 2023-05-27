package Arboles;
public class Main {
    public static void main(String[] args){
        System.out.println("Esto es arboles papaaaaa");
        BinaryTreeStatic binaryTreeStatic = new BinaryTreeStatic();
        binaryTreeStatic.create(10);
        binaryTreeStatic.addLeft(9);
        binaryTreeStatic.addRight(11);

        binaryTreeStatic.getLeft().addLeft(7);
        binaryTreeStatic.getLeft().getLeft().addLeft(6);
        binaryTreeStatic.getLeft().getLeft().getLeft().addLeft(5);

        // ESTO PRINTEA IN-ORDER, OSEA: LEFT-ROOT-RIGHT
        printInOrder(binaryTreeStatic);
        /*System.out.println("El peso del Arbol es: " + pesoArbol(binaryTreeStatic));
        System.out.println("La altura del Arbol es: " + alturaArbol(binaryTreeStatic));

        // DINAMICO:
        BinaryTree arbolits = new BinaryTree();
        arbolits.create(5);
        arbolits.addLeft(4);
        arbolits.addRight(6);
        arbolits.getLeft().addLeft(2);
        arbolits.getLeft().addRight(3);
        printInOrderDinamic(arbolits); // funciona wow*/
    }

    public static void printInOrder(BinaryTreeStatic binaryTreeStatic) { // PRINT (LEFT - ROOT - RIGHT)
        if(binaryTreeStatic == null || binaryTreeStatic.isEmpty()) {
            return;
        }
        printInOrder(binaryTreeStatic.getLeft());
        System.out.println(binaryTreeStatic.getValueRoot());
        printInOrder(binaryTreeStatic.getRight());
    }

    public static void printInOrderDinamic(IBinaryTree binaryTree) { // PRINT (LEFT - ROOT - RIGHT)
        if(binaryTree == null || binaryTree.isEmpty()) {
            return;
        }
        printInOrderDinamic(binaryTree.getLeft());
        System.out.println(binaryTree.getValueRoot());
        printInOrderDinamic(binaryTree.getRight());
    }

    public static int pesoArbol(BinaryTreeStatic binaryTreeStatic) { // CANTIDAD DE NODOS DEL ARBOL
        if(binaryTreeStatic == null || binaryTreeStatic.isEmpty()) {
            return 0;
        }
        return 1 + pesoArbol(binaryTreeStatic.getLeft()) + pesoArbol(binaryTreeStatic.getRight());
    }

    public static int alturaArbol(BinaryTreeStatic arbolito){ // calcula la cantidad de niveles de un arbol binario
        if(arbolito == null || arbolito.isEmpty()) {
            return 0;
        }
        int altIzq = alturaArbol(arbolito.getLeft()); // altura x la izquierda
        int altDer = alturaArbol(arbolito.getRight()); // altura x la derecha
        if(altIzq >= altDer){ // muestro la altura mas alta xd
            return altIzq + 1;
        } else {
            return altDer + 1;
        }
    }
}

