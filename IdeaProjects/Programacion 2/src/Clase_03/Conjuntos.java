package Clase_03;

import NodosCosas.ISet;

import java.util.Random;

public class Conjuntos implements ISet {
    private int[] conjunto; //el contenido del conjunto
    private int cont; //la cantidad de elementos

    public Conjuntos() {
        this.conjunto = new int[100];
        this.cont = 0;
    }

    public void add(int x) { // no se puede agregar un elemento que ya exista (:
        if (!Pertenece(x)) { //verifiacion de no pertenencia
            this.conjunto[this.cont] = x;
            this.cont++; //nuevo elemento
        }
    }

    public boolean isEmpty() {
        return (this.cont == 0);
    }

    public int choose() {
        if (this.cont == 0){
            System.out.println("No se puede elegir un elemento de un conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.cont); // agarro un num random
        return this.conjunto[randomIndex]; // agarro del conjunto, la pos del random (:
    }

    public boolean Pertenece(int x) {
        int i = 0;
        while (i < this.cont && this.conjunto[i] != x) {
            // LO Q HACE ES: RECORRE Y SUMA 'i', SI 'i' ES MENOR A CONT, ENTONCES ESTA DENTRO DEL CONJUNTO (:
            i++;
        }
        return (i < this.cont); // si i < cont entonces retorna true
    }

    public void remove(int x) { // no se puede borrar un elemento que no esta, obvio (:
        int i = 0;
        while (i < this.cont && this.conjunto[i] != x) { // MISMO Q PERTENECE, PERO NECESITO 'i'
            i++;
        }
        if (i < this.cont) { // si es true, el elemento pertenece al conjunto
            this.conjunto[i] = this.conjunto[this.cont - 1]; // REEMPLAZA X EL ULTIMO YA Q NO HAY ORDEN XD
            this.cont--; // al restarle una al contador ya no se tendra en cuenta el elemento borrado
        }
    }
}
