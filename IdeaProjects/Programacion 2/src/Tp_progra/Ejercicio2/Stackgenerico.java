package Tp_progra.Ejercicio2;
public class Stackgenerico<T> { // STACK GENERICO
    private NodeGenerico<T> first;

    public void add(T a) {
        this.first = new NodeGenerico<T>(a, this.first);
    }

    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T getTop() {
        return this.first.getValue();
    }
}
