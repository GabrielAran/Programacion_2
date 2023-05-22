package Diccionarios;

import Clase_03.Conjuntos;
import NodosCosas.ISet;

public class Dictionary implements IDictionary {

    private DictionaryNode first;
    private int size;

    public Dictionary() {
        size = 0; // cantidad de nodos, (elementos).
    }

    @Override
    public void add(int key, int value) {
        if (this.first == null) {
            this.first = new DictionaryNode(key, value, null);
            this.size++;
            return;
        }
        DictionaryNode index = indexOfKey(key); // agarro el index de la key
        if (index != null) {
            index.setValue(value); // Si la key ya existe, se reemplaza el value
            return;
        }
        DictionaryNode lastNode = this.first;
        while (lastNode.getNext() != null) { // agrega nodo al final como siempre xd wow
            lastNode = lastNode.getNext();
        }
        lastNode.setNext(new DictionaryNode(key, value, null));
        this.size++;
    }

    @Override
    public void remove(int key, int value) {
        if (this.first == null) {
            return;
        }
        if (this.first.getKey() == key && this.first.getValue() == value) {
            this.first = this.first.getNext(); // si el primero es el q queres borrar, first = first.getNext()
            this.size--;
            return;
        }
        DictionaryNode backup = null;
        DictionaryNode candidate = this.first;
        while (candidate.getNext() != null) {
            if (candidate.getKey() == key && candidate.getValue() == value) {
                backup.setNext(candidate.getNext());
                this.size--;
                return; // a -> b -> c :(si borro b, a apunta a c): a -> c
            }
            backup = candidate;
            candidate = candidate.getNext(); // voy recorriendo como siempre hasta encontrar el par key-value
        }
        if (candidate.getKey() == key && candidate.getValue() == value) {
            backup.setNext(null);
            this.size--; // si ya borro arriba ya no entra aca
        }
    }

    @Override
    public ISet getKeys() { // crea un conjunto con las keys
        ISet keySet = new Conjuntos();
        DictionaryNode candidate = this.first;
        while (candidate != null) {
            keySet.add(candidate.getKey());
            candidate = candidate.getNext();
        }
        return keySet;
    }

    @Override
    public int getValue(int key) {
        DictionaryNode candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                return candidate.getValue();
            }

            candidate = candidate.getNext(); // voy recorriendo lineal hasta encontrar la key
        }
        return -1; // si no encuentra la key, retorna -1 // si la encuentra, retorna su value
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private DictionaryNode indexOfKey(int key) { // hace una busqueda de la key y devuelve el index
        if (this.first == null) {
            return null;
        }
        DictionaryNode candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                return candidate;
            }
            candidate = candidate.getNext();
        }
        return null;
    }
}
