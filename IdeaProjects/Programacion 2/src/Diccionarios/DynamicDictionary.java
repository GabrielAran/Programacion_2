package Diccionarios;

import Clase_03.Conjuntos;
import Clase_03.conjuntosInterfaz;

public class DynamicDictionary implements IDictionary {

    private DictionaryNode first;
    private int cantNodos;

    public DynamicDictionary() {
        this.cantNodos = 0;
        this.first = null;
    }

    @Override
    public void add(int key, int value) {
        DictionaryNode index = indexOfKey(key);
        if (index != null) {
            index.setValue(value); // Si la key ya existe, se reemplaza el value
            return;
        }
        index.setNext(new DictionaryNode(key, value, null));
        cantNodos++;
    }

    @Override
    public void remove(int key, int value) {
        if(this.first == null) { // SI NO HAY NODOS, CORTA LA FUNCION
            return;
        }
        if(this.first.getKey() == key && this.first.getValue() == value) {
            this.first = this.first.getNext();
            return;
        } // SI EL PRIMERO ES EL Q QUERES BORRAR, REEMPLAZA DICIENDO Q EL PRIMERO ES IGUAL AL SEGUNDO
        DictionaryNode backup = null;
        DictionaryNode candidate = this.first;
        /*
        Back up es un aux que va a estar atras del que queres borrar, si lo encontras, le decis q backup
        apunta a nada, por lo tanto borraste el tuyo
         */
        while(candidate.getNext() != null) { // mientras haya siguiente
            if(candidate.getKey() == key && candidate.getValue() == value) {
                backup.setNext(candidate.getNext());
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
        if(candidate.getKey() == key && candidate.getValue() == value) {
            backup.setNext(null);
        }
    }

    @Override
    public conjuntosInterfaz getKeys() { // JUNTA TODAS LAS KEYS EN UN CONJUNTO
        conjuntosInterfaz keySet = new Conjuntos();
        DictionaryNode candidate = this.first;
        while(candidate != null) {
            keySet.Agregar(candidate.getKey());
            if(candidate.getNext() != null) {
                candidate = candidate.getNext();
            }
        }
        return keySet; // RETORNA UN CONJUNTO CON TODAS LAS LLAVES QUE HAY
    }

    @Override
    public int getValue(int key) {
        DictionaryNode candidate = this.first;
        while(candidate != null) {
            if(candidate.getKey() == key) {
                return candidate.getValue();
            }

            if(candidate.getNext() != null) {
                candidate = candidate.getNext();
            }
        }
        return -1; // No existe tal key
    }

    @Override
    public boolean isEmpty() {
        return cantNodos == 0;
    }

    private DictionaryNode indexOfKey(int key) {
        if(this.first == null) { // Si no hay nada xd
            return null;
        }
        DictionaryNode candidate = this.first;
        while(candidate.getNext() != null) {
            if(candidate.getKey() == key) {
                return candidate; // RETORNA EL NODO, QUE ES DONDE ESTA LA KEY, NO EXISTEN POSICIONES
            }
            candidate = candidate.getNext(); // AGARRA EL SIGUIENTE PARA CHECKEAR SI ESE TIENE LA KEY
        }
        return null;
    }
}
