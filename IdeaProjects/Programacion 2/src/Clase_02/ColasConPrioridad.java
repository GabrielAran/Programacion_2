package Clase_02;

public class ColasConPrioridad implements colasPrioridad{
    private char[] array;
    private int[] prioridades;
    private int count;
    private char aux;
    private int auxPrio;

    public ColasConPrioridad(){
        this.array = new char[100];
        this.prioridades = new int[100];
        this.count = 0;
    }
    @Override
    public void acolarPrioridad(char valor, int priori) {
        boolean cambios = false;
        this.array[this.count] = valor;
        this.prioridades[this.count] = priori;

        while (true) {
            cambios = false;
            for (int i = 0; i < count; i++) {
                if (this.prioridades[i] < prioridades[i + 1]) {
                    // Cambio los valores d lugar ya que son paralelos
                    aux = this.array[i];
                    this.array[i] = array[i + 1];
                    array[i + 1] = aux;

                    // Cambio las prioridades d lugar ya que son paralelos
                    auxPrio = this.prioridades[i];
                    this.prioridades[i] = prioridades[i + 1];
                    prioridades[i + 1] = auxPrio;

                    cambios = true;
                }
            }
            if (!cambios){
                break; // YA NO HAY QUE ORDENAR --> NO ENTRO AL IF (:
            }
        }
        this.count++;
    }

    @Override
    public void desacolarPrioridad() {
        for(int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
            this.prioridades[i] = this.prioridades[i + 1];
        }
        count--;
    }

    @Override
    public boolean estaVacioPrioridad() {
        return this.count == 0;
    }

    @Override
    public char getPrimeroPrioridad() {
        return this.array[0];
    }

    public int getPrimeroPrioridadPrioridad(){
        return this.prioridades[0];
    }
}