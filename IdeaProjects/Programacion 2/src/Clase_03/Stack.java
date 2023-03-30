package Clase_03;

public class Stack implements IStack{
    private Node first;

    public Stack() {
        this.first = null; // INICIALIZA LA PILA
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(int a) {
        Node node = new Node(a, null);

        if(this.first == null) { // SI ES EL PRIMERO Q AGREGAS
            this.first = node;
            return; // SALE DE LA FUNCION, LO Q SIGUE NO SE EJECUTA
        }

        Node candidato = this.first; // CREA AUXILIAR
        while(candidato.getNext() != null) {
            candidato = candidato.getNext();
        }
        candidato.setNext(node);
    }

    @Override
    public void remove() {
        if (this.first.getNext() == null) { // SI HAY UNO SOLO
            this.first = null; // ESE SOLO PASA A SER NULL
            return; // CORTA LA FUNCION
        }

        // CASO Q HAYA MAS DE UN NODO

        Node primero = this.first;
        Node segundo = this.first.getNext();

        while(segundo.getNext() != null) {
            primero = segundo;
            segundo = segundo.getNext();
        }

        primero.setNext(null);
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