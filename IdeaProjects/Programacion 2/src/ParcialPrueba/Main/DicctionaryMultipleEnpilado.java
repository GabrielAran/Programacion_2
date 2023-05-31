package ParcialPrueba.Main;

import Clase_03.Stack;
import NodosCosas.ISet;
import NodosCosas.Set;

public class DicctionaryMultipleEnpilado implements IMultipleDiccionaryEnpilado{
    private NodoMultipleDiccionaryEnpilado first;

    @Override
    public void add(int key, int value) { // complejidad = O(n)
        Stack stack = new Stack();
        stack.add(value);
        if (this.first == null) { // si no hay nodos, first = diccionario con key, set de valores y apunta a null
            this.first = new NodoMultipleDiccionaryEnpilado(key, stack, null);
            return;
        }
        NodoMultipleDiccionaryEnpilado candidate = this.first;
        while (candidate.getNext() != null) {
            if (candidate.getKey() == key) {
                candidate.getValue().add(value); // agarro el set de la key y le agrego el valor
                return;
            }
            candidate = candidate.getNext(); // sigo buscando hasta encontrar la key
        }
        if (candidate.getKey() == key) {
            candidate.getValue().add(value);
            return; // x si era el ultimo
        }
        candidate.setNext(new NodoMultipleDiccionaryEnpilado(key, stack, null)); // si no habia, creo el nuevo diccionario
    }

    @Override
    public void remove(int key, int value) {
        NodoMultipleDiccionaryEnpilado backup = null;
        NodoMultipleDiccionaryEnpilado candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                candidate.getValue().remove(); // encuentro la key, agarro el set y borro el valor
                if (candidate.getValue().isEmpty()) { // si el set esta vacio:
                    if (backup == null) {
                        if (candidate.getNext() == null) { // si es el ultimo y lo borro: first = null
                            this.first = null;
                            return; // chau chau
                        }
                        this.first = this.first.getNext(); // si no es el ultimo, lo píso
                        return;
                    }
                    if (candidate.getNext() == null) {
                        backup.setNext(null);
                        return;
                    }
                    candidate.setNext(candidate.getNext().getNext());
                }
                return;
            }
            backup = candidate;
            candidate = candidate.getNext(); // recorro
        }
    }

    @Override
    public ISet getKeys() { // N^2 devuelve el set cn las keys
        ISet keySet = new Set(); // C
        NodoMultipleDiccionaryEnpilado candidate = this.first; // C
        while (candidate != null) { // N * (N * C) = N^2 C = N^2
            keySet.add(candidate.getKey()); // N*C
            candidate = candidate.getNext(); // recorro
        }
        return keySet; // C
    }

    @Override
    public Stack getValues(int key) { // recorre y devuelve el set de valores de la key asociada
        NodoMultipleDiccionaryEnpilado candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                return candidate.getValue();
            }
            candidate = candidate.getNext();
        }
        return null; // Error
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
