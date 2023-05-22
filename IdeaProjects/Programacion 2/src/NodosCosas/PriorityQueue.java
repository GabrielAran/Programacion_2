package NodosCosas;

public class PriorityQueue implements IPriorityQueue {

    private NodosPrioridad first;

    @Override
    public void add(int a, int priority) {
        // 0 elementos
        if (this.first == null) {
            this.first = new NodosPrioridad(a, priority, null);
            return;
        }
        // 0 elementos

        // 1 elemento -->
        if (this.first.getNext() == null) {
            if (this.first.getPriority() > priority) { // si la prio del primero es > nuevo, entonces lo pone adelante
                this.first = new NodosPrioridad(a, priority, this.first);
            } else { // si la prio del primero es < nuevo, entonces le pone como next al primero, el nuevo
                this.first.setNext(new NodosPrioridad(a, priority, null));
            }
            return;
        }
        // 1 elemento -->

        // n elementos -->
            // 1° checko el primero:
        if (this.first.getPriority() > priority) {
            this.first = new NodosPrioridad(a, priority, this.first);
            return;
        } // si la prioridad del nuevo es menor q la del primero, entonces pone el nuevo al principio (:

        NodosPrioridad primero = this.first; // primero
        NodosPrioridad segundo = this.first.getNext(); // segundo
        while (segundo.getNext() != null) { // si el segundo tiene next
            /*if (segundo.getPriority() > priority) {
                primero.setNext(new NodosPrioridad(a, priority, segundo));
                return;
            }*/
            segundo = segundo.getNext(); // PREGUNTAR AL PROFE
            primero = primero.getNext();
        }

        if (segundo.getPriority() > priority) {
            primero.setNext(new NodosPrioridad(a, priority, segundo));
        } else {
            segundo.setNext(new NodosPrioridad(a, priority, null));
        }
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getFirstValue() {
        if (this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return -1;
        }
        return this.first.getValue();
    }

    @Override
    public int getFirstPriority() {
        if (this.first == null) {
            System.out.println("No se puede obtener la prioridad del primero una cola vacia");
            return -1;
        }
        return this.first.getPriority();
    }
}
