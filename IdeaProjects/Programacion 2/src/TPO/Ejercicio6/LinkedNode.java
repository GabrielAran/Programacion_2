package TPO.Ejercicio6;

public class LinkedNode {
    private int value;
    private LinkedNode next;
    private LinkedNode previous;

    public LinkedNode(int value, LinkedNode next, LinkedNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public LinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedNode previous) {
        this.previous = previous;
    }
}
