package NodosCosas;

import Clase_03.Node;
import java.util.Random;

public class ConjuntoDinamico {
    private Node first;
    private int count;

    public ConjuntoDinamico() {
        this.first = null; // ESTA BIEN ESTO?????????????
        this.count = 0;
    }
    public void add(int a) { //  PUEDE EL PRIMERO SER NULL???
        Node candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new Node(a, null)); // PUEDE EL PRIMERO SER NULL???
        count++; // PORQUE ESTO NO LO HABIA PUESTO EL PROFE...
    }

    public void remove(int a) {
        Node candidate = this.first;
        while(candidate.getNext() != null && candidate.getValue() != a) {
            if(candidate.getValue() == a) {
                candidate.setNext(candidate.getNext());
                return;
            }
            candidate = candidate.getNext();
        }
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int choose() {
        if(this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Node candidate = this.first;
        for(int i = 0; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }
}
