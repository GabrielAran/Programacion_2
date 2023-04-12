package NodosCosas;

import Clase_02.colasEstaticas;
import Clase_03.Node;

public class ColasDinamicas implements colasEstaticas {
    private Node first;

    public ColasDinamicas(){
        this.first = null;
    }
    @Override
    public void acolar(int a) {
        Node node = new Node(a, null);
        if(this.first == null) {
            this.first = node;
            return;
        }
        Node candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(node);
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
