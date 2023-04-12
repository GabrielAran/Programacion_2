package Diccionarios;

import Clase_03.conjuntosInterfaz;

public class MultipleDictionaryNode {

    private int key;
    private conjuntosInterfaz value;
    private MultipleDictionaryNode next;

    public MultipleDictionaryNode(int key, conjuntosInterfaz value, MultipleDictionaryNode next) {
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

    public conjuntosInterfaz getValue() {
        return value;
    }

    public void setValue(conjuntosInterfaz value) {
        this.value = value;
    }

    public MultipleDictionaryNode getNext() {
        return next;
    }

    public void setNext(MultipleDictionaryNode next) {
        this.next = next;
    }
}
