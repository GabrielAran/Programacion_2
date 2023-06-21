package TPO.Ejercicio6;
public class NodeRepetitions {

    private int value;
    private NodeRepetitions next;
    private int repeticiones;

    public NodeRepetitions(int value, NodeRepetitions next, int repeticiones) { // public record hace q los atributos ya tengan getter y setters en el constructor
        this.value = value;
        this.next = next;
        this.repeticiones = repeticiones;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeRepetitions getNext() {
        return next;
    }

    public void setNext(NodeRepetitions next) {
        this.next = next;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
}
