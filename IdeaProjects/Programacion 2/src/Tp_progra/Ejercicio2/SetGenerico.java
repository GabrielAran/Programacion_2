package Tp_progra.Ejercicio2;
import java.util.Random;

public class SetGenerico<T> {
    private NodeGenerico<T> first;
    private int count;

    public void add(T a) {
        if (this.first == null) { // si el set esta vacio, asigno el first y cont +1
            this.first = new NodeGenerico<T>(a, null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) { // no puedo asignar un valor que ya existe
            return;
        }

        NodeGenerico<T> aux = this.first;
        while (aux.getNext() != null) { // busco el ultimo
            aux = aux.getNext();
            if (aux.getValue() == a) { // no puedo agregar uno q ya esta
                return;
            }
        }
        aux.setNext(new NodeGenerico<T>(a, null)); // le seteo de next al ultimo nodo el nuevo nodo
        this.count++;
    }

    public void remove(T a) { // le digo cual quiero remover --> (a)
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return; // si el primero es null, o no hay segundo, o el primero es distinto a a, no borro nada XD
        }

        if (this.first != null && this.first.getNext() == null) { // un solo nodo
            if (this.first.getValue() == a) { // si hay un solo nodo y ese = a, first = null
                this.first = null;
                this.count--; // quedo el set vacio
            }
            return;
        }

        if (this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.count--; // si el primero es el q borras, first = segundo (:
            return;
        }

        NodeGenerico<T> backup = this.first; // primero
        NodeGenerico<T> candidate = this.first.getNext(); // segundo

        while (candidate != null) {
            if (candidate.getValue() == a) {
                backup.setNext(candidate.getNext()); // si queres borrar uno le pones al anterior de next al siguiente del borrado
                this.count--;
                return;
            }
            backup = candidate; // voy avanzando hasta encontrarlo
            candidate = candidate.getNext(); // voy avanzando hasta encontrarlo
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public T choose() { // devuelve el valor de un nodo random
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        NodeGenerico<T> candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        } // agarro uno random y voy cn el aux hasta esa "pos"
        return candidate.getValue();
    }

    @Override
    public boolean equals(Object o) { // retorna true si dos sets son iguales
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetGenerico<T> set = (SetGenerico<T>) o;
        if (count != set.count) {
            return false;
        }

        NodeGenerico<T> aux = this.first;
        while (aux != null) {
            if (!exists(aux.getValue(), set.first)) {
                return false;
            }
            aux = aux.getNext();
        }
        return true;
    }

    private boolean exists(T value, NodeGenerico<T> node) { // retorna true si un value esta en el set
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        }
        return exists(value, node.getNext());
    }
}
