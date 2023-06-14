package TPO.Ejercicio3;

import Clase_02.Colas;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public class QueueOfQueue implements IQueueOfQueue{
    private Colas[] array;
    private int count;

    public QueueOfQueue(){ // INICIALIZAR LA COLA
        this.array = new Colas[100];
        this.count = 0;  // THIS.VARIABLE SIRVE PA ACLARAR Q LA VARIABLE ES DE LA CLASE Y NO DE ARAFUE
    }
    @Override
    public void acolar(Colas queue) { // recibe una Queue
        this.array[this.count] = queue;
        this.count++;
    }

    @Override
    public void desacolar() {
        for(int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    @Override
    public boolean estaVacio() {
        return this.count == 0;
    }

    @Override
    public Colas getPrimero() {
        if (this.count == 0){
            return null;
        }
        return this.array[0];
    }
}
