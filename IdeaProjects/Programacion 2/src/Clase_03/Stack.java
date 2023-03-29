package Clase_03;

public class Stack implements IStack{
    private Node first;

    public Stack() {
        this.first = null;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(int a) {
        Node node = new Node(a, null);
        if(this.first == null) {
            this.first = node;
            return; //SALE DE LA FUNCION
        }
        Node candidato = this.first;
        while(candidato.getNext() != null) {
            candidato = candidato.getNext();
        }
        candidato.setNext(node);
    }

    @Override
    public void remove() {
        if (this.first.getNext() == null) {
            this.first = null;
            return;
        }

        Node backup = this.first;
        Node candidate = this.first.getNext();
        while(candidate.getNext() != null) {
            backup = candidate;
            candidate = candidate.getNext();
        }

        backup.setNext(null);
    }

    @Override
    public int getTop() {
        if(this.first.getNext() == null) {
            return this.first.getValue();
        }

        Node candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        return candidate.getValue();
    }
}