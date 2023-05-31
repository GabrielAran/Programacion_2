package NodosCosas;

import Clase_03.Node;

import java.util.Objects;
import java.util.Random;

public class Set implements ISet {

    private Node first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) { // si el set esta vacio, asigno el first y cont +1
            this.first = new Node(a, null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) { // no puedo asignar un valor que ya existe
            return;
        }

        Node aux = this.first;
        while (aux.getNext() != null) { // busco el ultimo
            aux = aux.getNext();
            if (aux.getValue() == a) { // no puedo agregar uno q ya esta
                return;
            }
        }
        aux.setNext(new Node(a, null)); // le seteo de next al ultimo nodo el nuevo nodo
        this.count++;
    }

    @Override
    public void remove(int a) { // le digo cual quiero remover --> (a)
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

        Node backup = this.first; // primero
        Node candidate = this.first.getNext(); // segundo

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

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() { // devuelve el valor de un nodo random
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Node candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        } // agarro uno random y voy cn el aux hasta esa "pos"
        return candidate.getValue();
    }

    @Override
    public boolean equals(Object o) { // retorna true si dos sets son iguales
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        if (count != set.count) {
            return false;
        }

        Node aux = this.first;
        while (aux != null) {
            if (!exists(aux.getValue(), set.first)) {
                return false;
            }
            aux = aux.getNext();
        }
        return true;
    }

    private boolean exists(int value, Node node) { // retorna true si un value esta en el set
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        }
        return exists(value, node.getNext());
    }
}