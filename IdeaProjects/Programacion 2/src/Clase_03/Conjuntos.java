package Clase_03;

import java.util.Random;

public class Conjuntos implements conjuntosInterfaz{
    private int[] conjunto; //el contenido del conjunto
    private int cont; //la cantidad de elementos

    public Conjuntos() {
        this.conjunto = new int[100];
        this.cont = 0;
    }

    public void Agregar(int x) {
        if (!Pertenece(x)) { //verifiacion de no pertenencia
            this.conjunto[this.cont] = x;
            this.cont++; //nuevo elemento
        }
    }

    public boolean ConjuntoVacio() {
        return (this.cont == 0);
    }

    public int Elegir() {
        if (this.cont == 0){
            System.out.println("No se puede elegir un elemento de un conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.cont);
        return this.conjunto[randomIndex];
    }

    public boolean Pertenece(int x) {
        int i = 0;
        while (i < this.cont && this.conjunto[i] != x) {
            // LO Q HACE ES: RECORRE Y SUMA 'i', SI 'i' ES MENOR A CONT, ENTONCES ESTA DENTRO DEL CONJUNTO (:
            i++;
        }
        return (i < this.cont);
    }

    public void Sacar(int x) {
        int i = 0;
        while (i < this.cont && this.conjunto[i] != x) { // MISMO Q PERTENECE, PERO NECESITO 'i'
            i++;
        }
        if (i < this.cont) { //elemento encontrado
            this.conjunto[i] = this.conjunto[this.cont - 1]; // REEMPLAZA X EL ULTIMO YA Q NO HAY ORDEN XD
            this.cont--;
        }
    }
}
