package Arboles;
public class Main {
    public static void main(String[] args){
        System.out.println("Esto es arboles papaaaaa");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(1);
        binaryTree.addLeft(2);
        binaryTree.addRight(3);

        binaryTree.getLeft().addLeft(4);
        binaryTree.getLeft().addRight(5);
        binaryTree.getLeft().getRight().addRight(6);

        // ESTO PRINTEA IN-ORDER, OSEA: LEFT-ROOT-RIGHT

        printInOrder(binaryTree);
    }

    public static void printInOrder(BinaryTree binaryTree) {
        if(binaryTree == null || binaryTree.isEmpty()) {
            return;
        }
        printInOrder(binaryTree.getLeft());
        System.out.println(binaryTree.getValue());
        printInOrder(binaryTree.getRight());
    }
}

