package TPO.Ejercicio6;

import java.util.Random;

public class RepeatedSet {
    private NodeRepetitions first;
    private int count;

    public void add(int a) {
        int repetitions = 1;
        if (this.first == null) {
            this.first = new NodeRepetitions(a, null, repetitions);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) { // el primero se repite -->
            repetitions = this.first.getRepeticiones() + 1;
            this.first.setRepeticiones(repetitions);
            return;
        }

        NodeRepetitions candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) { // si ya existe el nodo -->
                repetitions = candidate.getRepeticiones() + 1;
                candidate.setRepeticiones(repetitions);
                return;
            }
        }
        candidate.setNext(new NodeRepetitions(a, null, repetitions));
        this.count++;
    }

    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) { // uno solo, no cambian las repeticiones ya que desaparece
            if (this.first.getValue() == a) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if (this.first.getValue() == a) {
            if (this.first.getRepeticiones() > 1){
                this.first.setRepeticiones(this.first.getRepeticiones() - 1);
            } else {
                this.first = this.first.getNext();
                this.count--;
            }
            return;
        }

        NodeRepetitions backup = this.first;
        NodeRepetitions candidate = this.first.getNext();
        while (candidate != null) {
            if (candidate.getValue() == a) {
                if (candidate.getRepeticiones() > 1){
                    candidate.setRepeticiones(candidate.getRepeticiones() - 1);
                } else {
                    backup.setNext(candidate.getNext());
                    this.count--;
                    return;
                }
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public NodeRepetitions choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        NodeRepetitions candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate;
    }

    private boolean exists(int value, NodeRepetitions node) {
        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;
        }
        return exists(value, node.getNext());
    }
}
