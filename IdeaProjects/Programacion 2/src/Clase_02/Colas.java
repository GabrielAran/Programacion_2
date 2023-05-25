package Clase_02;

public class Colas implements colasEstaticas{
    private int[] array;
    private int count;

    public Colas(){ // INICIALIZAR LA COLA
        this.array = new int[1000];
        this.count = 0;  // THIS.VARIABLE SIRVE PA ACLARAR Q LA VARIABLE ES DE LA CLASE Y NO DE ARAFUE
    }
    @Override
    public void acolar(int valor) {
        this.array[this.count] = valor;
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
    public int getPrimero() {
        if (this.count == 0){
            return -1;
        }
        return this.array[0];
    }
}
