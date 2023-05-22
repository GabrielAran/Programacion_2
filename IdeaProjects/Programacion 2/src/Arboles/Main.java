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
    }

    public static void printInOrder(BinaryTreeStatic binaryTreeStatic) {
        if(binaryTreeStatic == null || binaryTreeStatic.isEmpty()) {
            return;
        }
        printInOrder(binaryTreeStatic.getLeft());
        System.out.println(binaryTreeStatic.getValue());
        printInOrder(binaryTreeStatic.getRight());
    }

    public static int pesoArbol(BinaryTreeStatic binaryTreeStatic) {
        if(binaryTreeStatic == null || binaryTreeStatic.isEmpty()) {
            return 0;
        }
        return 1 + pesoArbol(binaryTreeStatic.getLeft()) + pesoArbol(binaryTreeStatic.getRight());
    }

    public static int alturaArbol(BinaryTreeStatic arbolito){
        // ESTUDIAR RECURSIVIDAD
        return 1;
    }
}

