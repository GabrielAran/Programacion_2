package FinalDeEjemplo;

import Clase_02.pilasEstatica;
import NodosCosas.ColasDinamicas;

import java.awt.font.TextHitInfo;

public class Ejercicio1B implements pilasEstatica{
    //private int[] array;
    private final ColasDinamicas values; // en vez de un array utiliza una queue
    private int count;

    public Ejercicio1B(){
        this.values = new ColasDinamicas(); // instancio una cola y la lleno de 1 para q sea estatica
        for (int i = 0; i < 100; i++){ // seteo q la pila tiene 100 lugares = ESTATICO
            this.values.acolar(1);
        }
        this.count = 0;
    }

    @Override
    public void apilar(int a){
        this.set(this.count, a); // estaba al revez en el del profe?
        this.count++;
    }

    private void set(int a, int index){ // nose la verdad esto
        ColasDinamicas aux = new ColasDinamicas();
        for (int i = 0; i < index; i++){
            aux.acolar(this.values.getPrimero());
            this.values.desacolar();
        }
        this.values.desacolar();
        this.values.acolar(a);
        while (!aux.estaVacio()){
            this.values.acolar(aux.getPrimero());
            aux.desacolar();
        }
    }

    public void desapilar(){
        if (this.count == 0){
            System.out.println("No podes desapilar si ya esta vacio");
        } else {
            this.count--;
        }
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public int getTope(){
        if (this.count == 0){
            System.out.println("No podes agarrar tope si esta vacia");
            return -1;
        } else {
            return this.get(this.count - 1);
        }
    }

    private int get(int index){
        ColasDinamicas aux = new ColasDinamicas();
        for(int i = 0; i < index; i++) {
            aux.acolar(this.values.getPrimero());
            this.values.desacolar();
        }
        int result = this.values.getPrimero();
        while(!aux.estaVacio()) {
            this.values.acolar(aux.getPrimero());
            aux.desacolar();
        }
        return result;
    }
}

