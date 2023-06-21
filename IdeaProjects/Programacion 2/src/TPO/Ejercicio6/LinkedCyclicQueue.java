package TPO.Ejercicio6;

public class LinkedCyclicQueue {
    private LinkedNode first;

    public void add(int a) {
        // genero un nodo
        LinkedNode nodoNuevo = new LinkedNode(a, null, null);

        // si no habian nodos -->
        if(this.first == null) {
            this.first = nodoNuevo; // --> este es el primero
            return;
        }
        // si hay mas de uno -->
        if (this.first.getNext() != null){
            // this.first.getPrevious() es el ultimo nodo ya que es round
            this.first.getPrevious().setNext(nodoNuevo); // seteo el nuevo como siguiente
            nodoNuevo.setPrevious(this.first.getPrevious()); // linked -- apunta al anterior tmb
            nodoNuevo.setNext(this.first); // rounded -- apunta al first
            this.first.setPrevious(nodoNuevo); // rounded -- apunta al nuevo
        }
        // si habia un nodo solo -->
        else {
            this.first.setNext(nodoNuevo); // apunta al nuevo
            nodoNuevo.setPrevious(this.first); // apunta al first
            this.first.setPrevious(nodoNuevo); // rounded
            nodoNuevo.setNext(this.first); // rounded
        }
    }

    public void remove() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        // si hay uno solo
        if (this.first.getNext() == null){
            this.first = null;
            return;
        }
        // hay que reasignar los next y previous para que se mantenga el rounded
        // hay mas de 2 nodos
        if (this.first.getNext() != this.first.getPrevious()) {
            this.first.getNext().setPrevious(this.first.getPrevious()); // que el nuevo first apunte al ultimo
            this.first.getPrevious().setNext(this.first.getNext()); // que el ultimo apunte al siguiente
            this.first = this.first.getNext(); // seteo como first al siguiente
        } else { // hay 2 nodos
            this.first = this.first.getNext();
            this.first.setNext(null);
            this.first.setPrevious(null);
        }
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
}
