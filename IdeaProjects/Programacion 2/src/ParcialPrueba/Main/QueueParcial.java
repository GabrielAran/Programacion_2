package ParcialPrueba.Main;
public class QueueParcial implements IColas{
    private int[] array;
    private int count;

    public QueueParcial(){ // INICIALIZAR LA COLA
        this.array = new int[1000];
        this.count = 0;  // THIS.VARIABLE SIRVE PA ACLARAR Q LA VARIABLE ES DE LA CLASE Y NO DE ARAFUE
    }
    @Override
    public void acolar(int valor, int repetirValor) {
        for(int i = 0; i < repetirValor; i++){ // for i in range(0, 3, 1) desde 0 hasta 3 sumandole a i 1
            this.array[this.count] = valor;
            this.count++;
        }
    }

    @Override
    public void desacolar(int cantidadBorrar) {
        if (cantidadBorrar < 0){
            throw new RuntimeException("No puedes desacolar menos de 0 elementos");
        }
        if (cantidadBorrar > count){
            throw new RuntimeException("No podes eliminar mas elementos de los q hay"); // ESTO TIRA UN ERROR Y CORTA LA FUNCIÓN
        } else {
            for (int i = 0; i < cantidadBorrar; i++) {
                for (int j = 0; j < count - 1; j++) {
                    this.array[j] = this.array[j + 1];
                }
                count--;
            }
        }
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

