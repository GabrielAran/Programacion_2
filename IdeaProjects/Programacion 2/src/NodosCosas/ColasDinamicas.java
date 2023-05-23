package NodosCosas;

import Clase_02.colasEstaticas;
import Clase_03.Node;

public class ColasDinamicas implements colasEstaticas {
    private Node first;
    @Override
    public void acolar(int a) {
        Node nodoNuevo = new Node(a, null); // genero un nodo
        if(this.first == null) { // si no habian nodos -->
            this.first = nodoNuevo; // --> este es el primero
            return;
        }
        // --> si ya habia un nodo -->
        Node nodoAux = this.first;
        while(nodoAux.getNext() != null) { // recorre hasta agarrar el ultimo nodo asi despues le seteo de next el nuevo
            nodoAux = nodoAux.getNext();
        }
        nodoAux.setNext(nodoNuevo);
    }

    @Override
    public void desacolar() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean estaVacio() {
        return this.first == null;
    }

    @Override
    public int getPrimero() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return -1;
        }
        return this.first.getValue();
    }
}
