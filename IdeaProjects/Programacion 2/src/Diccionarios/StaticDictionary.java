package Diccionarios;

import Clase_03.Conjuntos;
import Clase_03.conjuntosInterfaz;

import java.util.Arrays;

public class StaticDictionary implements IDictionary {

    private int[] keys;
    private int[] values;
    private int cantValues;

    public StaticDictionary() {
        this.keys = new int[100];
        this.values = new int[100];
        this.cantValues = 0;
    }

    @Override
    public void add(int key, int value) {
        int index = indexOfKey(key); // INDEX = -1: NO EXISTE LA KEY
        if (index != -1) { // EXISTE LA KEY, ENTONCES:
            this.values[index] = value; // Si la key ya existe, se reemplaza el value
            return;
        }
        if (this.cantValues == this.keys.length) {
            // Si el array de keys está lleno, se duplica su tamaño
            this.keys = Arrays.copyOf(this.keys, this.keys.length * 2);
            this.values = Arrays.copyOf(this.values, this.values.length * 2);
        }
        this.keys[this.cantValues] = key;
        this.values[this.cantValues] = value;
        this.cantValues++;
    }

    @Override
    public void remove(int key, int value) {
        int index = indexOfKey(key);
        if (index != -1 && this.values[index] == value) {
            for (int i = index; i < this.cantValues - 1; i++) { // LOS PISA DESDE Q ESTA EL VALOR
                this.keys[i] = this.keys[i + 1];
                this.values[i] = this.values[i + 1];
            }
            this.cantValues--;
        }
    }

    @Override
    public conjuntosInterfaz getKeys() { // NO SE PARA QUE HACE ESTO
        conjuntosInterfaz keySet = new Conjuntos();
        for (int i = 0; i < this.cantValues; i++) {
            keySet.Agregar(this.keys[i]);
        }
        return keySet; // CONJUNTO CN LAS CLAVES DEL DICCIONARIO
    }

    @Override
    public int getValue(int key) {
        int index = indexOfKey(key);
        if (index != -1) {
            return this.values[index];
        }
        return -1; // NO EXISTE LA CLAVE
    }

    @Override
    public boolean isEmpty() {
        return this.cantValues == 0;
    }

    private int indexOfKey(int key) {
        for (int i = 0; i < this.cantValues; i++) {
            if (this.keys[i] == key) {
                return i;
            }
        }
        return -1;
    }
}