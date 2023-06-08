package Parcial_Aran;

import java.util.Random;

public class SetEstaticoParcial implements ISetParcial {
    private boolean[] conjunto; //el contenido del conjunto
    private int cont; //la cantidad de elementos

    public SetEstaticoParcial() {
        this.conjunto = new boolean[100];
        this.cont = 0;
    }

    public void add(boolean x) {
        // SE PUEDEN CREAR SOLO 2 SUBCONJUNTOS YA QUE NO SE PERMITEN REPETIR LOS VALORES
        // DICHOS SUBCONJUNTOS SERAN 1 TRUE Y EL OTRO FALSE
        if (!Pertenece(x)) {
            this.conjunto[this.cont] = x;
            this.cont++;
        } else {
            throw new RuntimeException("Solo se permite un TRUE y un FALSE por Set");
        }
    }

    public boolean isEmpty() {
        return (this.cont == 0);
    }

    public boolean choose() {
        if (this.cont == 0){
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacio");
        }
        int randomIndex = (new Random()).nextInt(this.cont); // agarro un num random
        return this.conjunto[randomIndex];
    }

    public boolean Pertenece(boolean x) {
        int i = 0;
        while (i < this.cont && this.conjunto[i] != x) {
            i++;
        }
        return (i < this.cont);
    }

    public void remove(boolean x) {
        int i = 0;
        while (i < this.cont && this.conjunto[i] != x) {
            i++;
        }
        if (i < this.cont) {
            this.conjunto[i] = this.conjunto[this.cont - 1];
            this.cont--;
        }
    }
}
