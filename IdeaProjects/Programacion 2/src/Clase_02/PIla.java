package Clase_02;

public class PIla implements pilasEstatica { //AL PONER IMLEMENTS LA INTERFAZ, TE OBLIGA A USAR LOS METODOS D ESA
    private int[] array; // PRIVATE HACE Q NO SE PUEDAN ACCEDER DESDE AFUERA
    private int count;

    public PIla(){ // INICIALIZAR LA PILA
        this.array = new int[100000];
        this.count = 0;  // THIS.VARIABLE SIRVE PA ACLARAR Q LA VARIABLE ES DE LA CLASE Y NO DE ARAFUE
    }
    @Override
    public void apilar(int a){
        this.array[this.count] = a;
        this.count++;
    }

    public void desapilar(){
        this.count--;
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public int getTope(){
        return this.array[count - 1]; //ME DA EL ULTIMO VALOR DE LA PILA
    }
}
