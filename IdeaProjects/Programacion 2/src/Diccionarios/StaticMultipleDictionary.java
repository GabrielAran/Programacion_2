package Diccionarios;

import Clase_03.Conjuntos;
import NodosCosas.ISet;

import java.util.Arrays;

public class StaticMultipleDictionary implements IMultipleDictionary {
    private int[] keys;
    private ISet[] values;
    private int cantValores;

    public StaticMultipleDictionary() {
        this.keys = new int[100];
        this.values = new Conjuntos[100]; // TOMA A LOS VALORES DE UNA KEY COMO UN SET, (conjunto).
        this.cantValores = 0;
    }

    @Override
    public void add(int key, int value) {
        int index = indexOfKey(key);
        if (index != -1) { // la key ya existe
            Conjuntos staticSet = new Conjuntos();
            staticSet.add(value);
            this.values[index] = staticSet;
            return;
        }
        if (this.cantValores == this.keys.length) { // NO LEER ESTO, MUY XD
            // Si el array de keys está lleno, se duplica su tamaño
            this.keys = Arrays.copyOf(this.keys, this.keys.length * 2);
            this.values = Arrays.copyOf(this.values, this.values.length * 2);
        }
        this.keys[this.cantValores] = key;
        this.values[this.cantValores].add(value);
        this.cantValores++;
    }

    @Override
    public void remove(int key, int value) { // TODO no debe eliminar el conjunto, sino un elemento del conjunto
        int index = indexOfKey(key);
        if (index != -1 && this.existsValue(this.values[index], value)) {
            for (int i = index; i < this.cantValores - 1; i++) {
                this.keys[i] = this.keys[i + 1];
                this.values[i] = this.values[i + 1]; // ESTO NO ESTA BIEN, FALTA CODIGO
            }
            this.cantValores--;
        }
    }

    private boolean existsValue(ISet set, int value) {
        ISet copy = new Conjuntos();
        boolean exists = false;
        while(!set.isEmpty()) {
            int element = set.choose();
            if(element == value) {
                exists = true;
                break;
            }
            copy.add(element);
            set.remove(element);
        }
        while(!copy.isEmpty()) {
            int element = copy.choose();
            set.add(element);
            copy.remove(element);
        }
        return exists;
    }

    @Override
    public ISet getKeys() {
        ISet keySet = new Conjuntos();
        for (int i = 0; i < this.cantValores; i++) {
            keySet.add(this.keys[i]);
        }
        return keySet;
    }

    @Override
    public ISet getValues(int key) {
        int index = indexOfKey(key);
        if (index != -1) {
            return this.values[index];
        }
        return null; // Error
    }

    @Override
    public boolean isEmpty() {
        return this.cantValores == 0;
    }

    private int indexOfKey(int key) {
        for (int i = 0; i < this.cantValores; i++) {
            if (this.keys[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
