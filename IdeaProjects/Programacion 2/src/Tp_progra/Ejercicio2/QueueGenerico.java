package Tp_progra.Ejercicio2;

public class QueueGenerico<T> {
    private NodeGenerico<T> first;

    public void acolar(T a) {
        NodeGenerico<T> nodoNuevo = new NodeGenerico<>(a, null); // genero un nodo
        if(this.first == null) { // si no habian nodos -->
            this.first = nodoNuevo; // --> este es el primero
            return;
        }
        // --> si ya habia un nodo -->
        NodeGenerico<T> nodoAux = this.first;
        while(nodoAux.getNext() != null) { // recorre hasta agarrar el ultimo nodo asi despues le seteo de next el nuevo
            nodoAux = nodoAux.getNext();
        }
        nodoAux.setNext(nodoNuevo);
    }

    public void desacolar() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    public boolean estaVacio() {
        return this.first == null;
    }

    public T getPrimero() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return null;
        }
        return this.first.getValue();
    }
}
