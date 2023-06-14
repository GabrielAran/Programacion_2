package TPO.Ejercicio2;

public class NodeGenerico<T> {
    private T value;
    private NodeGenerico<T> next;

    public NodeGenerico(T value, NodeGenerico<T> next) { // public record hace q los atributos ya tengan getter y setters en el constructor
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeGenerico<T> getNext() {
        return next;
    }

    public void setNext(NodeGenerico<T> next) {
        this.next = next;
    }
}
