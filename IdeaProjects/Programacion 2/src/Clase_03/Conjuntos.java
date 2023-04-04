package Clase_03;

public class Conjuntos {
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
        return this.conjunto[this.cont - 1]; //esto es arbitrario; podria ser cualquiera
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
