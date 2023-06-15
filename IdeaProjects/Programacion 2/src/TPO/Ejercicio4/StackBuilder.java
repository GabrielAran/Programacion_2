package TPO.Ejercicio4;

public class StackBuilder implements IStackBuilder{
    private int[] array; // PRIVATE HACE Q NO SE PUEDAN ACCEDER DESDE AFUERA
    private int count;

    public StackBuilder(){ // INICIALIZAR LA PILA // cuando crees un objeto pila, se crea el array y el cont
        this.array = new int[100000];
        this.count = 0;  // THIS.VARIABLE SIRVE PA ACLARAR Q LA VARIABLE ES DE LA CLASE Y NO DE ARAFUE
    }
    @Override
    public IStackBuilder add(int a){ // void no retorna nada
        this.array[this.count] = a;
        this.count++; // cada vez q agregas, suma 1 a contador
        return this;
    }

    @Override
    public void remove(){
        if (this.count == 0){
            System.out.println("No podes desapilar si ya esta vacio");
        } else {
            this.count--; // lo dejas de tener en cuenta
        }
    }

    @Override
    public boolean isEmpty(){
        return this.count == 0;
    }

    @Override
    public int getTop(){
        if (this.count == 0){
            System.out.println("No podes agarrar tope si esta vacia");
            return -1;
        } else {
            return this.array[count - 1]; //ME DA EL ULTIMO VALOR DE LA PILA
        }
    }
}
