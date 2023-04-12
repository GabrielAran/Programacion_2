package NodosCosas;

public class NodosPrioridad {
    private int value;
    private int priority;
    private NodosPrioridad next;

    public NodosPrioridad(int value, int priority, NodosPrioridad next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public NodosPrioridad getNext() {
        return next;
    }

    public void setNext(NodosPrioridad next) {
        this.next = next;
    }
}
