package TPO.Ejercicio6;

import Clase_03.Node;

public class StackLimitada {
    private Node first;

    private int limite;
    private int count;

    public StackLimitada(int limite){
        this.limite = limite;
        this.count = 0;
    }

    public void add(int a) {
        if (!full()){
            this.first = new Node(a, this.first);
            this.count++;
        }
    }
    public boolean full(){
        return this.count == this.limite;
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

    public int getTop() {
        return this.first.getValue();
    }
}
