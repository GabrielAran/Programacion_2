package Diccionarios;

import Clase_03.Conjuntos;
import Clase_03.conjuntosInterfaz;

import java.util.Arrays;

public class StaticMultipleDictionary implements IMultipleDictionary {
    private int[] keys;
    private conjuntosInterfaz[] values;
    private int cantValores;

    public StaticMultipleDictionary() {
        this.keys = new int[100];
        this.values = new Conjuntos[100];
        this.cantValores = 0;
    }

    @Override
    public void add(int key, int value) {
        int index = indexOfKey(key);
        if (index != -1) {
            Conjuntos staticSet = new Conjuntos();
            staticSet.Agregar(value);
            this.values[index] = staticSet;
            return;
        }
        if (this.cantValores == this.keys.length) {
            // Si el array de keys está lleno, se duplica su tamaño
            this.keys = Arrays.copyOf(this.keys, this.keys.length * 2);
            this.values = Arrays.copyOf(this.values, this.values.length * 2);
        }
        this.keys[this.cantValores] = key;
        this.values[this.cantValores].Agregar(value);
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

    private boolean existsValue(conjuntosInterfaz set, int value) {
        conjuntosInterfaz copy = new Conjuntos();
        boolean exists = false;
        while(!set.ConjuntoVacio()) {
            int element = set.Elegir();
            if(element == value) {
                exists = true;
                break;
            }
            copy.Agregar(element);
            set.Sacar(element);
        }
        while(!copy.ConjuntoVacio()) {
            int element = copy.Elegir();
            set.Agregar(element);
            copy.Sacar(element);
        }
        return exists;
    }

    @Override
    public conjuntosInterfaz getKeys() {
        conjuntosInterfaz keySet = new Conjuntos();
        for (int i = 0; i < this.cantValores; i++) {
            keySet.Agregar(this.keys[i]);
        }
        return keySet;
    }

    @Override
    public conjuntosInterfaz getValues(int key) {
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
