package NodosCosas;

public class ColasPrioridadNodos {

    private NodosPrioridad first;

    public ColasPrioridadNodos() {
        this.first = null;
    }

    public void add(int a, int priority) {
        if(this.first == null) {
            this.first = new NodosPrioridad(a, priority,null);
            return;
        }
        NodosPrioridad candidate = this.first;
        while(candidate.getNext() != null && candidate.getPriority() > priority) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new NodosPrioridad(a, priority,candidate.getNext()));
    }

    public void remove() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return -1;
        }
        return this.first.getValue();
    }

    public int getPriority() {
        if(this.first == null) {
            System.out.println("No se puede obtener la prioridad del primero una cola vacia");
            return -1;
        }
        return this.first.getPriority();
    }
}
