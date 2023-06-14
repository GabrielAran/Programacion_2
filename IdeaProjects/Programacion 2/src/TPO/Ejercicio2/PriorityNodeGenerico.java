package TPO.Ejercicio2;

public class PriorityNodeGenerico<T> {
    private T value;
    private int priority;
    private PriorityNodeGenerico<T> next;

    public PriorityNodeGenerico(T value, int priority, PriorityNodeGenerico<T> next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PriorityNodeGenerico<T> getNext() {
        return next;
    }

    public void setNext(PriorityNodeGenerico<T> next) {
        this.next = next;
    }
}
