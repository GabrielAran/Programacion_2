package Arboles;
public class Main {
    public static void main(String[] args){
        System.out.println("Esto es arboles papaaaaa");
        BinaryTreeStatic binaryTreeStatic = new BinaryTreeStatic();
        binaryTreeStatic.create(1);
        binaryTreeStatic.addLeft(2);
        binaryTreeStatic.addRight(3);

        binaryTreeStatic.getLeft().addLeft(4);
        binaryTreeStatic.getLeft().addRight(5);
        binaryTreeStatic.getLeft().getRight().addRight(6);

        // ESTO PRINTEA IN-ORDER, OSEA: LEFT-ROOT-RIGHT
        printInOrder(binaryTreeStatic);
        System.out.println("El peso del Arbol es: " + pesoArbol(binaryTreeStatic));
        System.out.println("La altura del Arbol es: " + alturaArbol(binaryTreeStatic));
    }

    public static void printInOrder(BinaryTreeStatic binaryTreeStatic) { // PRINT (LEFT - ROOT - RIGHT)
        if(binaryTreeStatic == null || binaryTreeStatic.isEmpty()) {
            return;
        }
        printInOrder(binaryTreeStatic.getLeft());
        System.out.println(binaryTreeStatic.getValue());
        printInOrder(binaryTreeStatic.getRight());
    }

    public static int pesoArbol(BinaryTreeStatic binaryTreeStatic) { // CANTIDAD DE NODOS DEL ARBOL
        if(binaryTreeStatic == null || binaryTreeStatic.isEmpty()) {
            return 0;
        }
        return 1 + pesoArbol(binaryTreeStatic.getLeft()) + pesoArbol(binaryTreeStatic.getRight());
    }

    public static int alturaArbol(BinaryTreeStatic arbolito){ // nop f
        if(arbolito == null || arbolito.isEmpty()) {
            return 0;
        }
        if(arbolito.getLeft() == null || arbolito.getRight() == null){
            return 1 + alturaArbol(arbolito.getLeft()) + alturaArbol(arbolito.getRight());
        }
        return alturaArbol(arbolito.getLeft()) + alturaArbol(arbolito.getRight());
    }
}

