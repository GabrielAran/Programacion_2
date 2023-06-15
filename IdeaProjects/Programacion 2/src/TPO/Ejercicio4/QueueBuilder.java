package TPO.Ejercicio4;

import Clase_02.colasEstaticas;

public class QueueBuilder {
    private int[] array;
    private int count;

    public QueueBuilder(){ // INICIALIZAR LA COLA
        this.array = new int[1000];
        this.count = 0;  // THIS.VARIABLE SIRVE PA ACLARAR Q LA VARIABLE ES DE LA CLASE Y NO DE ARAFUE
    }

    public QueueBuilder(int... valores) {
        this.array = new int[valores.length];
        this.count = 0;
        for (int valor : valores) {
            acolar(valor);
        }
    }

    public void acolar(int valor) {
        this.array[this.count] = valor;
        this.count++;
    }

    public void desacolar() {
        for(int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    public boolean estaVacio() {
        return this.count == 0;
    }

    public int getPrimero() {
        if (this.count == 0){
            return -1;
        }
        return this.array[0];
    }
}