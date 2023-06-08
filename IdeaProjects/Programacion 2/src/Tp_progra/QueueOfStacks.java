package Tp_progra;

import Clase_02.PIla;

public class QueueOfStacks implements IQueueOfStacks{
    private PIla[] cola;
    private int count;
    private int elementosXPila;
    private int indexPila;

    public QueueOfStacks(int n){
        this.cola = new PIla[n];
        this.count = 0;
        this.elementosXPila = n;
        this.indexPila = 0;
    }
    @Override
    public void acolar(int valor) {
        if (this.indexPila == this.elementosXPila - 1 && this.count == 3){
            throw new RuntimeException("no podes acolar mas de n elementos");
        }

        if (this.count == this.elementosXPila){ // si se lleno la pila, voy con la sig
            this.indexPila++; // posicion de la pila en la cola
            this.count = 0; // cantidad de elementos en cada pila actual
        } // creo la pila

        if (this.cola[this.indexPila] == null){
            this.cola[this.indexPila] = new PIla();
        } // apilo
        this.cola[this.indexPila].apilar(valor); // apilo el valor
        this.count++; // la pila tiene 1 elemento
    }

    @Override
    public void desacolar() {
        for (int i = 0; i < this.indexPila; i++) {
            this.cola[i] = this.cola[i + 1];
        }
        this.cola[indexPila] = null;
        this.indexPila--;
    }

    @Override
    public boolean estaVacio() {
        if (this.cola[0] == null){
            return true;
        }
        return (this.cola[0].isEmpty());
    }

    @Override
    public PIla getPrimero() {
        if (this.indexPila == -1){
            return null;
        }
        return this.cola[0];
    }
}
