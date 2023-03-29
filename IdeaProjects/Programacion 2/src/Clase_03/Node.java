package Clase_03;

public class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) { // public record hace q los atributos ya tengan getter y setters en el constructor
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
