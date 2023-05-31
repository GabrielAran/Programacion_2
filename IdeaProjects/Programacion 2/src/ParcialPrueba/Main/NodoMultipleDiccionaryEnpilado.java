package ParcialPrueba.Main;

import Clase_03.Stack;

public class NodoMultipleDiccionaryEnpilado {
    private int key;
    private Stack value;
    private NodoMultipleDiccionaryEnpilado next;

    public NodoMultipleDiccionaryEnpilado(int key, Stack value, NodoMultipleDiccionaryEnpilado next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Stack getValue() {
        return value;
    }

    public void setValue(Stack value) {
        this.value = value;
    }

    public NodoMultipleDiccionaryEnpilado getNext() {
        return next;
    }

    public void setNext(NodoMultipleDiccionaryEnpilado next) {
        this.next = next;
    }
}
