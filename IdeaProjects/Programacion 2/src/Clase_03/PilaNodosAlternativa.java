package Clase_03;

public class PilaNodosAlternativa implements IStack {
    private Node tope;
    public PilaNodosAlternativa() {
        this.tope = null;
    }

    public void add(int valor) {
        Node nuevoNodo = new Node(valor, null);
        nuevoNodo.setNext(tope);
        tope = nuevoNodo;
    }

    public void remove() {
        if (tope != null) {
            tope = tope.getNext();
        }
    }

    public int getTop() {
        if (tope != null) {
            return tope.getValue();
        }
        return -1; // o una excepción podría ser lanzada aquí para indicar que la pila está vacía
    }

    public boolean isEmpty() {
        return tope == null;
    }
}
